package com.pack.diplomap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.MotionEvent;

import com.pack.diplomap.MapObjects.MyPoint;

import static java.lang.Math.round;

public class TouchManager
{
    public static boolean touched=false;

    public static MyPoint touchdown=new MyPoint(0,0);
    public static MyPoint grab=new MyPoint(0,0);
    public static MyPoint touchup=new MyPoint(0,0);

    public static MyPoint reltouchdown=new MyPoint(0,0);
    public static MyPoint relgrab=new MyPoint(0,0);
    public static MyPoint reltouchup=new MyPoint(0,0);

    public TouchManager()
    {


    }

    public void tick()
    {

    }

    public void render(Canvas canvas)
    {
        Paint p=new Paint();
        p.setColor(Color.GREEN);
      //  canvas.drawText("touchcoord"+touchcoord.toString(),100,415,p);
        canvas.drawText("downcoord: "+touchdown.x+"."+touchdown.y,400,70,p);
        canvas.drawText("upcoord: "+touchup.x+"."+touchup.y,400,80,p);
        canvas.drawText("grabcoord: "+grab.x+"."+grab.y,400,90,p);

        canvas.drawText("reldowncoord: "+reltouchdown.x+"."+reltouchdown.y,400,110,p);
        canvas.drawText("relupcoord: "+reltouchup.x+"."+reltouchup.y,400,120,p);
        canvas.drawText("relgrabcoord: "+relgrab.x+"."+relgrab.y,400,130,p);
    }

    public void setevent(MotionEvent event)
    {
         // touchcoord =new MyPoint(event.getX(),event.getY());

              switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            {   touchdown=new MyPoint((int)event.getX(),(int)event.getY());
                reltouchdown=new MyPoint((int)(event.getX()-MapPanel.mapCamera.getWorldloc().x)/round((int)MapPanel.mapCamera.getSize()),(int)(event.getY()-MapPanel.mapCamera.getWorldloc().y)/round((int)MapPanel.mapCamera.getSize()));
                touchup=new MyPoint(0,0);
                reltouchup=new MyPoint(0,0);
                touched=true;
            }
                break;
            case MotionEvent.ACTION_UP:
            {
                touchup=new MyPoint((int)event.getX(),(int)event.getY());
                 grab=new MyPoint(0,0);
                reltouchup=new MyPoint((int)(event.getX()-MapPanel.mapCamera.getWorldloc().x)/round((int)MapPanel.mapCamera.getSize()),(int)(event.getY()-MapPanel.mapCamera.getWorldloc().y)/round((int)MapPanel.mapCamera.getSize()));
                relgrab=new MyPoint(0,0);
                touched=false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
            {
                grab=new MyPoint((int)event.getX(),(int)event.getY());
                touchup=new MyPoint(0,0);
                relgrab=new MyPoint((int)(event.getX()-MapPanel.mapCamera.getWorldloc().x)/round((int)MapPanel.mapCamera.getSize()),(int)(event.getY()-MapPanel.mapCamera.getWorldloc().y)/round((int)MapPanel.mapCamera.getSize()));
                reltouchup=new MyPoint(0,0);

            }
                break;
        }



    }


    public static boolean isTouched() {
        return touched;
    }

    public static MyPoint getTouchdown() {
        return touchdown;
    }

    public static MyPoint getGrab() {
        return grab;
    }

    public static MyPoint getTouchup() {
        return touchup;
    }

    public static MyPoint getReltouchdown() {
        return reltouchdown;
    }

    public static MyPoint getRelgrab() {
        return relgrab;
    }

    public static MyPoint getReltouchup() {
        return reltouchup;
    }
}
