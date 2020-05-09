package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;

public class TouchManager
{
   // PointF touchcoord=new PointF(0,0);
    public static boolean touched=false;
    public static   PointF touchdown=new PointF(0,0);
    public static   PointF grab=new PointF(0,0);
    public static PointF touchup=new PointF(0,0);

    public TouchManager()
    {


    }

    public void tick()
    {

    }

    public void render(Canvas canvas)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);
      //  canvas.drawText("touchcoord"+touchcoord.toString(),100,415,p);
        canvas.drawText("downcoord"+touchdown.toString(),100,430,p);
        canvas.drawText("upcoord"+touchup.toString(),100,445,p);
        canvas.drawText("grabcoord"+grab.toString(),100,460,p);
    }

    public void setevent(MotionEvent event)
    {
         // touchcoord =new PointF(event.getX(),event.getY());

              switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            {   touchdown.x= event.getX();
                touchdown.y = event.getY();
                touchup=new PointF(0,0);
                touched=true;
            }
                break;
            case MotionEvent.ACTION_UP:
            {   touchup.x=event.getX();
                touchup.y=event.getY();
          //       touchcoord=new PointF(0,0);
           //      touchdown=new PointF(0,0);
                 grab=new PointF(0,0);
               // deviation.x=0;
              //  deviation.y=0;
            touched=false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
            {   grab.x=event.getX();
                grab.y=event.getY();
                touchup=new PointF(0,0);
              //  deviation.x= -(pressCoord.x-moved.x);
             //   deviation.y= -(pressCoord.y-moved.y);
                //tempDeviation= deviation;
            }
                break;
        }

      //  touchcoord =new PointF(event.getX(),event.getY());

    }
}
