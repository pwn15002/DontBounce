package com.mygdx.game.Basics;

import com.mygdx.game.Basics.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Ball.Ball;

public abstract class Collidable extends Drawable
{
    protected  Vector2 m_position = null;

    public Collidable(float x, float y)
    {
        m_position = new Vector2(x,y);
    }
    public abstract void checkCollision(Ball b);
    protected abstract boolean isColliding(Circle c);
    protected abstract Vector2 getCollisionPosition(Circle c);

    @Override
    public String toString()
    {
        String str = super.toString();
        str += "m_position: " + m_position.toString() + "\n";

        return str;
    }

}
