package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import java.io.Serializable;

public class Grid extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1515152604847457796L;

    int rows;
    int columns;
    int length;
    int templength = 0;


    public Grid(int rows, int columns, int length)
    {
        this.deletable = false;
        this.rows = rows;
        this.columns = columns;
        this.length = length;
        location=new MyPoint(0, 0);
        relativeLocation = new MyPoint(0, 0);
        elemid = ++MapElement.numInstances + "G";

    }

    public Grid()
    {

        this.deletable = false;
        this.rows = 10;
        this.columns = 10;
        this.length = 50;
        location=new MyPoint(0, 0);
        relativeLocation = new MyPoint(0, 0);
        elemid = ++MapElement.numInstances + "G";

    }

    @Override
    public  void tick(MyPoint relLocation, int size)
{

    //super.tick(relLocation, size);
    relativeLocation = new MyPoint(relLocation.x + location.y, relLocation.y + location.y);
    //  relpoints[0].x = relpoints[0].x * size;
    //  relpoints[0].y = relpoints[0].y * size;
    templength = length * size;


}

    @Override
    public  void render(Canvas canvas)
{

    Paint p=new Paint();
    p.setColor(Color.CYAN);
    for(int i=0;i<=rows;i++)
    {
        canvas.drawLine(relativeLocation.x,relativeLocation.y+templength*i,relativeLocation.x+templength*rows,relativeLocation.y+templength*i,p);

    }
    for(int i=0;i<=columns;i++)
    {
        canvas.drawLine(relativeLocation.x+templength*i,relativeLocation.y,relativeLocation.x+templength*i,relativeLocation.y+templength*columns,p);
    }

}

/*
    @Override
    public  bool touchhit(Point coord)
{
    return false;
}
*/

}
