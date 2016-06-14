package edu.ohiostate.havefun;

import android.graphics.Bitmap;
import android.graphics.Canvas;
//import android.view.animation.Animation; use my own Animation, not the one in the api

/**
 * Created by hefang on 6/8/16.
 */
public class Player extends GameObject{
    private Bitmap spritsheet;
    private int score;

    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;

    public Player(Bitmap res, int w, int h, int numFrames){
        spritsheet = res;
        x = 100;
        y = GamePanel.HEIGHT/2;
        dy = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];


        //use three images consequencely to display the dynamic helicopter, so we need the animation class
        for(int i = 0; i < image.length; i++){
            image[i] = Bitmap.createBitmap(spritsheet, i*width, 0, width, height);

        }

        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){
        up = b;
    }

    public void update(){
        long elapse = (System.nanoTime() - startTime)/1000000;
        if(elapse > 100){
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        if(up){
            dy = dy - 1;
        }else{
            dy = dy + 1;
        }

        if(dy > 5) dy = 5;
        if(dy < -5) dy = -5;

        y = y + dy*2;
       // dy = 0;

    }

    public void draw(Canvas canvs){
        canvs.drawBitmap(animation.getImage(), x, y, null);
    }

    public int getScore() {
        return score;
    }

    public boolean getPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void resetDY(){
        dy = 0;
    }

    public void resetScore(){
        score = 0;
    }
}
