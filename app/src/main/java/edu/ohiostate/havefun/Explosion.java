package edu.ohiostate.havefun;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by hefang on 6/10/16.
 */
public class Explosion {
    private int x;
    private int y;
    private int width;
    private int height;
    private int row;
    private Animation animation = new Animation();
    private Bitmap spritesheet;

    public Explosion(Bitmap res, int x, int y, int w, int h, int numFrame){
        this.x = x;
        this.y = y;
        width = w;
        height = h;

        Bitmap[] image = new Bitmap[numFrame];

        spritesheet = res;

        for(int i = 0; i < image.length; i++){

            if(i%5 == 0 && i > 0) row++;

            image[i] = Bitmap.createBitmap(spritesheet, (i - (5*row))*width, row*height, width, height);

        }
        animation.setFrames(image);
        animation.setDelay(1);



    }

    public void draw(Canvas canvas){
        if(!animation.playedOnce()){
            canvas.drawBitmap(animation.getImage(), x, y, null);
        }
    }

    public void update(){
        //first round
        if(!animation.playedOnce()){
            animation.update();
        }
    }

    public int getHeight(){
        return height;
    }

}
