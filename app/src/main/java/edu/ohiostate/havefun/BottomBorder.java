package edu.ohiostate.havefun;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Created by hefang on 6/9/16.
 */
public class BottomBorder extends GameObject{

    private Bitmap image;

    public BottomBorder(Bitmap res, int x, int y){
        //image = res;

        this.x = x;
        this.y = y;

        width = 20;
        //?
        height = 200;
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
