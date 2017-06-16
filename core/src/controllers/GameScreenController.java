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

/**
 * Created by rjawa on 6/16/2017.
 */

public class GameScreenController {
    Viewport viewport ;
    Stage stage ;
    boolean  upPressed, downPressed, rightPressed, leftPressed, pausePressed, attackPressed, potionPressed ;
    OrthographicCamera cam ;

    public GameScreenController(Application game){
        cam = new OrthographicCamera() ;
        viewport = new FitViewport(800,400,cam) ;
        stage = new Stage(viewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);

        Table directionsTable = new Table() ;
        directionsTable.left().bottom();

        Table actionTable = new Table() ;
        actionTable.right();

        GameConstants.UP_BUTTON.setSize(50,50);
        GameConstants.UP_BUTTON.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        }) ;

        GameConstants.DOWN_BUTTON.setSize(50,50);
        GameConstants.DOWN_BUTTON.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        }) ;

        GameConstants.LEFT_BUTTON.setSize(50,50);
        GameConstants.LEFT_BUTTON.addListener(new InputListener(){

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

        GameConstants.RIGHT_BUTTON.setSize(50,50);
        GameConstants.RIGHT_BUTTON.addListener(new InputListener(){

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

        GameConstants.DOWN_BUTTON.setSize(50,50);
        GameConstants.DOWN_BUTTON.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        }) ;

        GameConstants.PAUSE_BUTTON.setSize(50,50);
        GameConstants.PAUSE_BUTTON.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pausePressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                pausePressed = false;
            }
        }) ;

        GameConstants.ATTACK_BUTTON.setSize(50,50);
        GameConstants.ATTACK_BUTTON.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                attackPressed = true ;
                return true ;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                attackPressed = false;
            }
        }) ;

        directionsTable.add() ;
        directionsTable.add(GameConstants.UP_BUTTON).size(GameConstants.UP_BUTTON.getWidth(),GameConstants.UP_BUTTON.getHeight()) ;
        directionsTable.add() ;
        directionsTable.add(GameConstants.ATTACK_BUTTON).size(GameConstants.ATTACK_BUTTON.getWidth(),GameConstants.ATTACK_BUTTON.getHeight()) ;
        directionsTable.add() ;
        directionsTable.row().pad(5,5,5,5) ;
        directionsTable.add(GameConstants.LEFT_BUTTON).size(GameConstants.LEFT_BUTTON.getWidth(),GameConstants.LEFT_BUTTON.getHeight()) ;
        directionsTable.add() ;
        directionsTable.add(GameConstants.RIGHT_BUTTON).size(GameConstants.RIGHT_BUTTON.getWidth(),GameConstants.RIGHT_BUTTON.getHeight()) ;
        directionsTable.row().padBottom(5) ;
        directionsTable.add() ;
        directionsTable.add(GameConstants.DOWN_BUTTON).size(GameConstants.DOWN_BUTTON.getWidth(),GameConstants.DOWN_BUTTON.getHeight()) ;
        directionsTable.add() ;

        stage.addActor(directionsTable);

        //actionTable.add(GameConstants.ATTACK_BUTTON).size(GameConstants.ATTACK_BUTTON.getWidth(),GameConstants.ATTACK_BUTTON.getHeight()) ;
        //actionTable.add(GameConstants.BLANK_BUTTON).size(GameConstants.BLANK_BUTTON.getWidth(),GameConstants.BLANK_BUTTON.getHeight()) ;


        //stage.addActor(actionTable);

    }

    public void draw(){
        stage.draw();
    }


    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isPausePressed() {
        return pausePressed;
    }

    public boolean isAttackPressed() {
        return attackPressed;
    }

    public boolean isPotionPressed() {
        return potionPressed;
    }
}
