package edu.ohiostate.havefun;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by hefang on 6/8/16.
 */


public class MainThread extends Thread{

    //frames per second
    private int fps = 30;
    private double averagePPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

    }

    @Override
    public void run(){

        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        //fps: each time over a game loop, it takes targetTime
        long targetTime = 1000/fps;

        while(running){
            startTime = System.nanoTime();
            canvas = null;

            //try looking the canvas for pixal editing

            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }catch(Exception e){

            }
            finally{
                if(canvas != null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }

            //it take timeMillis to draw and drop the canvas
            timeMillis = (System.nanoTime() - startTime)/1000000;
            //time left should wait
            waitTime = targetTime - timeMillis;

            try{
                this.sleep(waitTime);
            }catch(Exception e){}

            totalTime = totalTime + System.nanoTime() - startTime;
            frameCount++;

            if(frameCount == fps){
                averagePPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averagePPS);
            }

        }
    }

    public void setRunning(boolean b){
        running = b;
    }
}
