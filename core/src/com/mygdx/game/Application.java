package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.MainMenuScreen;

public class Application extends Game {
	
	@Override
	public void create () {
		this.setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void dispose () {
	}
}
