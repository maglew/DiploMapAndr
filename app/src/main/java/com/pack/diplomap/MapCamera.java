package com.pack.diplomap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;


import androidx.constraintlayout.solver.widgets.Rectangle;

import com.pack.diplomap.MapObjects.MyPoint;

public class MapCamera
{
    public static float size = 1;
    static Rectangle screenRect;
    static MyPoint razn = new MyPoint(0, 0);
    boolean moved=false;
    public static int canvasW=0 ;
    public static int canvasH=0;
    public static MyPoint  worldlocation = new MyPoint(0, 0);
    public static MyPoint  relativeworldlocation = new MyPoint(0, 0);
    public static MyPoint  cursor = new MyPoint(0, 0);

    public MapCamera()
    {
       // screenRect = new Rectangle(0, 0, 2, 2);
    }

    public  void tick()
    {

        cursor=  TouchManager.grab;
        if(TouchManager.touched &&moved==false)
        {
            razn.x = (int) TouchManager.touchdown.x- relativeworldlocation.x;
            razn.y = (int) TouchManager.touchdown.y - relativeworldlocation.y;
        }

        if(TouchManager.grab.x!=0&& TouchManager.grab.y!=0)
        {
            relativeworldlocation=new MyPoint((int) TouchManager.grab .x-razn.x,(int) TouchManager.grab.y-razn.y);
            moved=true;
        }
        else
        {
            moved=false;
            razn = new MyPoint(0, 0);
        }
    }

    public  void render(Canvas canvas)
    {
        Paint p=new Paint();
        p.setColor(Color.YELLOW);
        canvas.drawText("size: "+size,400,10,p);
        canvas.drawText("worldloc"+relativeworldlocation.x+"."+relativeworldlocation.y,400,25,p);


    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public MyPoint getWorldloc() {
        return relativeworldlocation;
    }
}
