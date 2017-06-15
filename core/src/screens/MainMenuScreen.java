package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

/**
 * Created by rjawa on 6/10/2017.
 */
public class MainMenuScreen extends ScreenAdapter {
    final Application game  ;
    OrthographicCamera camera;
    OrthographicCamera guicam ;
    private int mainSwitch ;
    private SpriteBatch batch ;
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

        guicam = new OrthographicCamera(480, 320);
        guicam.position.set(480/2F, 320/2F, 0);

       // this.camera.setToOrtho(false, 1920, 1080);

        mainSwitch = 0 ;
        //slack test

        batch = new SpriteBatch() ;

        openingScreen = new Sprite(GameConstants.MAIN_MENU_SCREEN) ;
        selectScreen = new Sprite(GameConstants.CLASS_SELECT_SCREEN) ;

        openingScreen.setOrigin(0,0);
        openingScreen.setPosition(-openingScreen.getWidth()/2,-openingScreen.getHeight()/2);

        selectScreen.setOrigin(0,0);
        selectScreen.setPosition(-selectScreen.getWidth()/2,-selectScreen.getHeight()/2);


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
                //batch.draw(GameConstants.MAIN_MENU_SCREEN, 0.0F, 0.0F);
                openingScreen.draw(batch);
                break ;
            case CLASS:
                //batch.draw(GameConstants.CLASS_SELECT_SCREEN, 0.0F, 0.0F);
                selectScreen.draw(batch);
                break ;
        }

        batch.end();

        checkInput() ;
    }

    public void checkInput()
    {
        if(Gdx.input.isTouched())
        {
            if(state == State.MAIN)
            {
                state = State.CLASS ;
            }
        }

    }

    public void show ()
    {

    }

    public void dispose(){

    }
}
