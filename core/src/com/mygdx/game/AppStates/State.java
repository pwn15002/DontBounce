package com.mygdx.game.AppStates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class State
{
    public StateManager m_sm = null;
    Cam m_cam = null;

    public State(StateManager sm)
    {
        m_sm = sm;
        m_cam = new Cam();
    }

    public abstract void update(float dt);
    public abstract void render(SpriteBatch sr);
    public abstract void handleInput();
    public abstract void dispose();
    public abstract void resize(int width, int height);
}
