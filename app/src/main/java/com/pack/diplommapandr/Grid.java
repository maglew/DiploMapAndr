package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Grid extends MapElement
{
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
        location=new Point(0, 0);
        relativeLocation = new Point(0, 0);


    }

    @Override
    public  void tick(Point relLocation, int size)
{

    //super.tick(relLocation, size);
    relativeLocation = new Point(relLocation.x + location.y, relLocation.y + location.y);
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
