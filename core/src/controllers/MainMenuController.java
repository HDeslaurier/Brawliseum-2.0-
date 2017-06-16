package controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Application;

import constants.GameConstants;
import screens.MainMenuScreen;

/**
 * Created by rjawa on 6/15/2017.
 */

public class MainMenuController {
    Viewport viewport ;
    Stage stage ;
    boolean  leftPressed, centerPressed, rightPressed;
    OrthographicCamera cam ;

    public MainMenuController(Application game){
        cam = new OrthographicCamera() ;
        viewport = new FitViewport(800,400,cam) ;
        stage = new Stage(viewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table() ;
        table.center();

        GameConstants.ARCHER_BOX.setSize(100,100);
        GameConstants.ARCHER_BOX.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        }) ;

        GameConstants.FIGHTER_BOX.setSize(100,100);
        GameConstants.FIGHTER_BOX.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                centerPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                centerPressed = false;
            }
        }) ;

        GameConstants.MAGE_BOX.setSize(100,100);
        GameConstants.MAGE_BOX.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        }) ;

        table.add(GameConstants.ARCHER_BOX).size(GameConstants.ARCHER_BOX.getWidth(),GameConstants.ARCHER_BOX.getHeight()).pad(10) ;
        table.add(GameConstants.FIGHTER_BOX).size(GameConstants.FIGHTER_BOX.getWidth(),GameConstants.FIGHTER_BOX.getHeight()).pad(10) ;
        table.add(GameConstants.MAGE_BOX).size(GameConstants.MAGE_BOX.getWidth(),GameConstants.MAGE_BOX.getHeight()).pad(10) ;
        table.padLeft(790)  ;
        table.padBottom(540) ;

        stage.addActor(table);


    }

    public void draw(){
        stage.draw();
    }



    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isCenterPressed() {
        return centerPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
