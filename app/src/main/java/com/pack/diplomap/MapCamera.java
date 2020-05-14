package com.pack.diplomap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import androidx.constraintlayout.solver.widgets.Rectangle;

import com.pack.diplomap.MapObjects.MyPoint;

public class MapCamera
{
    public static int size = 1;
    static Rectangle screenRect;
    static int attenuation = 10;
    static MyPoint vec = new MyPoint(0, 0);
    static MyPoint  razn = new MyPoint(0, 0);
    boolean moved=false;
    public static MyPoint  worldlocation = new MyPoint(0, 0);
    public static MyPoint  relativeworldlocation = new MyPoint(0, 0);

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
            relativeworldlocation=new MyPoint((int)TouchManager.grab.x-razn.x,(int)TouchManager.grab.y-razn.y);
        moved=true;
        }
        else
        {
            moved=false;
            razn = new MyPoint(0, 0);
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

    public  MyPoint relgetWorldLoc()
    { return relativeworldlocation; }

    public  void setWorldLoc(MyPoint coord)
    { worldlocation = coord; }
}
