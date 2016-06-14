package edu.ohiostate.havefun;


import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by hefang on 6/9/16.
 */
public class TopBorder extends GameObject{

    private Bitmap image;

    public TopBorder(Bitmap res, int x, int y, int h){

        height = h;
        width = 20;

        this.x = x;
        this.y = y;

        //the speed of the border is the same as the bg
        dx = GamePanel.MOVESPEED;
        image = Bitmap.createBitmap(res, 0, 0,width, height);
    }

    public void update(){
        x = x + dx;
    }

    public void draw(Canvas canvas){
        try{
            canvas.drawBitmap(image, x, y, null);
        }catch(Exception e){};
    }
}
