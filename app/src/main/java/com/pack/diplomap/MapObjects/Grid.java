package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;


import java.io.Serializable;
import java.util.ArrayList;

public class Grid extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1515152604847457796L;
    int diagquads;

    int length;
    int templength = 0;

    public Grid(int diagquads,int width)
    {
        this.deletable = false;
        this.width = width;
        this.diagquads = diagquads;
        location=new MyPoint(0, 0);
        elemid = ++MapElement.numInstances + "G";


    }

    public Grid()
    {

        this.deletable = false;
        this.width = 100;
        this.diagquads = 10;
        this.length = 50;
        location=new MyPoint(0, 0);

        elemid = ++MapElement.numInstances + "G";

    }

    @Override
    public  void tick()
    {

    }

    @Override
    public  void render(Canvas g)
    {

        Paint p=new Paint();
        p.setColor(Color.WHITE);

        for(int i=0;i<=diagquads;i++)
        {
            for(int j=0;j<=diagquads;j++)
            {
                p.setStyle(Paint.Style.STROKE);
                g.drawRect(location.x+width*j,location.y+width *i,location.x+width *i+width,location.y+width *i+width,p);
            }
        }


    }

    @Override
    public boolean touchhit(Point coord)
    {
        return false;
    }




}
