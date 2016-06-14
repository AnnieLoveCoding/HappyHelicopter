package edu.ohiostate.havefun;

import android.graphics.Rect;

/**
 * Created by hefang on 6/8/16.
 */

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int dy;
    protected int dx;
    protected int width;
    protected int height;

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    //Rect method is for collision method in GamePanel
    public Rect getRectangle(){
        return new Rect(x, y, x + width, y + height);
    }
}
