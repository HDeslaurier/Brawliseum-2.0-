package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Application;

import constants.GameConstants;
import controllers.MainMenuControl;

/**
 * Created by rjawa on 6/10/2017.
 */
public class MainMenuScreen implements Screen {
    final Application game  ;
    private SpriteBatch batch ;
    OrthographicCamera camera;
    MainMenuControl controller ;
    private int mainSwitch ;
    private Sprite openingScreen ;
    private Sprite selectScreen ;
    Music titleMusic = Gdx.audio.newMusic(Gdx.files.internal("Ice9.mp3"));

    public MainMenuScreen(Application game)
    {
        titleMusic.setVolume(.5f);
        titleMusic.setLooping(true);
        titleMusic.play();
        this.game = game ;
        this.camera = new OrthographicCamera(1920,1080) ;

        mainSwitch = 0 ;

        batch = game.getBatch() ;

        openingScreen = new Sprite(GameConstants.MAIN_MENU_SCREEN) ;
        selectScreen = new Sprite(GameConstants.CLASS_SELECT_SCREEN) ;

        openingScreen.setOrigin(0,0);
        openingScreen.setPosition(-openingScreen.getWidth()/2,-openingScreen.getHeight()/2);

        selectScreen.setOrigin(0,0);
        selectScreen.setPosition(-selectScreen.getWidth()/2,-selectScreen.getHeight()/2);

        controller = new MainMenuControl(game) ;
    }


    public enum State
    {
        MAIN,
        CLASS,
    }

    private State state = State.MAIN;

    public void render (float delta)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        switch(state)
        {
            case MAIN:
                openingScreen.draw(batch);
                break ;
            case CLASS:
                selectScreen.draw(batch);

                break ;
        }

        batch.end();

        if(state==State.CLASS){
            controller.draw();
        }


        checkInput() ;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void checkInput()
    {
        if(Gdx.input.isTouched())
        {
            if(state == State.MAIN)
            {
                state = State.CLASS ;
            }else if(state == State.CLASS){
                if(controller.isLeftPressed()){
                    titleMusic.stop();
                    titleMusic.dispose();
                    game.setScreen(new GameScreen(game, "bow"));

                }else if(controller.isCenterPressed()){
                    titleMusic.stop();
                    titleMusic.dispose();
                    game.setScreen(new GameScreen(game, "sword"));
                }else if(controller.isRightPressed()){
                    titleMusic.stop();
                    titleMusic.dispose();
                    game.setScreen(new GameScreen(game, "mage"));

                }
            }
        }

    }

    public void show ()
    {

    }

    public void dispose(){

    }
}
