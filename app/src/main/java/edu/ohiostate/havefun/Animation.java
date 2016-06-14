package edu.ohiostate.havefun;

import android.graphics.Bitmap;

/**
 * Created by hefang on 6/8/16.
 */
public class Animation {
    private Bitmap[] frames;
    private int currentFrames;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames){
        this.frames = frames;
        currentFrames = 0;
        startTime = System.nanoTime();
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void setCurrentFrames(int currentFrames) {
        this.currentFrames = currentFrames;
    }

    public void update(){
        long elapsed = (System.nanoTime() - startTime)/1000000;

        if(elapsed > delay){
            currentFrames++;
            startTime = System.nanoTime();

        }
        if(currentFrames == frames.length){
            currentFrames = 0;
            playedOnce = true;
        }
    }

    public Bitmap getImage(){
        return frames[currentFrames];
    }

    public int getCurrentFrames() {
        return currentFrames;
    }

    public boolean playedOnce(){
        return playedOnce;
    }
}

