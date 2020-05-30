package com.pack.diplomap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.MotionEvent;

import com.pack.diplomap.MapObjects.MyPoint;

public class TouchManager
{
   // MyPoint touchcoord=new MyPoint(0,0);
    public static boolean touched=false;
    public static MyPoint touchdown=new MyPoint(0,0);
    public static   MyPoint grab=new MyPoint(0,0);
    public static MyPoint touchup=new MyPoint(0,0);

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
        canvas.drawText("downcoord"+touchdown.x+"."+touchdown.y,400,70,p);
        canvas.drawText("upcoord"+touchup.x+"."+touchup.y,400,80,p);
        canvas.drawText("grabcoord"+grab.x+"."+grab.y,400,90,p);
    }

    public void setevent(MotionEvent event)
    {
         // touchcoord =new MyPoint(event.getX(),event.getY());

              switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            {   touchdown=new MyPoint((int)event.getX(),(int)event.getY());
                touchup=new MyPoint(0,0);
                touched=true;
            }
                break;
            case MotionEvent.ACTION_UP:
            {   touchup=new MyPoint((int)event.getX(),(int)event.getY());
          //       touchcoord=new MyPoint(0,0);
           //      touchdown=new MyPoint(0,0);
                 grab=new MyPoint(0,0);
               // deviation.x=0;
              //  deviation.y=0;
            touched=false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
            {
                grab=new MyPoint((int)event.getX(),(int)event.getY());
                touchup=new MyPoint(0,0);
              //  deviation.x= -(pressCoord.x-moved.x);
             //   deviation.y= -(pressCoord.y-moved.y);
                //tempDeviation= deviation;
            }
                break;
        }

      //  touchcoord =new MyPoint(event.getX(),event.getY());

    }
}
