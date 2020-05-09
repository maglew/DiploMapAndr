package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class MapCamera
{
    public static int size = 1;
    static Rectangle screenRect;
    static int attenuation = 10;
    static Point vec = new Point(0, 0);
    static Point  razn = new Point(0, 0);
boolean moved=false;
    public static Point  worldlocation = new Point(0, 0);
    public static Point  relativeworldlocation = new Point(0, 0);

    public MapCamera()
    {
       // screenRect = new Rectangle(0, 0, 2, 2);
    }

    public  void tick()
    {



        if(TouchManager.touched&&moved==false)
        {
            razn.x = (int)TouchManager.touchdown.x- relativeworldlocation.x;
            razn.y = (int)TouchManager.touchdown.y - relativeworldlocation.y;
        }

        if(TouchManager.grab.x!=0&&TouchManager.grab.y!=0)
        {
            relativeworldlocation=new Point((int)TouchManager.grab.x-razn.x,(int)TouchManager.grab.y-razn.y);
        moved=true;
        }
        else
        {
            moved=false;
            razn = new Point(0, 0);
        }

   //     if(TouchManager.grab.x!=0&&TouchManager.grab.y!=0)
  //      {relativeworldlocation=new Point((int)TouchManager.grab.x,(int)TouchManager.grab.y);}

    }

    public  void render(Canvas canvas)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);

        canvas.drawText("relwoeldloc"+relativeworldlocation.toString(),100,485,p);
        canvas.drawText("vec"+vec.toString(),100,400,p);
        canvas.drawText("razn"+razn.toString(),100,415,p);


    }

    public  Point relgetWorldLoc()
    { return relativeworldlocation; }

    public  void setWorldLoc(Point coord)
    { worldlocation = coord; }
}
