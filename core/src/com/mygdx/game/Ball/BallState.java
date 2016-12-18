package com.mygdx.game.Ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Basics.Drawable;
import com.mygdx.game.Basics.InputHandler;
import com.mygdx.game.Obstacles.Obstacle;

abstract class BallState extends Drawable
{
    Ball m_ball = null;
    float m_gravity = 0f;
    float m_maxSpeed = 0f;

    BallState()
    {
    }

    BallState(Ball b)
    {
        m_ball = b;
    }
    public void setBall(Ball b)
    {
        m_ball = b;
    }


    protected abstract boolean hasDeltaMove();
    protected abstract void updateSprite();
    protected abstract void onCollision(Vector2 pos, int side);

    protected void setDeltaMove(float deltaMove)
    {
    }

    @Override
    public String toString()
    {
        String str = "m_ball: " + m_ball.toString() + "\n";
        return str;
    }
}
