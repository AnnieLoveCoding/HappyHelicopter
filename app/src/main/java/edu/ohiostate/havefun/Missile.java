package edu.ohiostate.havefun;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by hefang on 6/9/16.
 */
public class Missile extends GameObject{
    private int score;
    private int speed;
    private Random rand = new Random();
    private Animation animation = new Animation();
    private Bitmap spritesheet;

    public Missile(Bitmap res, int x, int y, int w, int h, int s, int numFrames) {
        super.x = x;
        super.y = y;
        width = w;
        height = h;
        score = s;

        //speed up with the score
        speed = 7 + (int) (rand.nextDouble() * score / 30);


        //range the speed
        if (speed > 40) speed = 40;

        Bitmap[] images = new Bitmap[numFrames];

        spritesheet = res;

        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createBitmap(spritesheet, 0, i * height, width, height);

        }
        animation.setFrames(images);
        animation.setDelay(100 - speed);

    }

    public void update(){
        x = x - speed;
        animation.update();
    }

    public void draw(Canvas canvas){
        try{
            canvas.drawBitmap(animation.getImage(), x, y, null);
        }catch(Exception e){}

    }

    public int getWidth(){
        //offset
        return width - 10;
    }
}
