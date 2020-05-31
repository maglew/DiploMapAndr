package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class MapElement implements Serializable
{
    private static final long serialVersionUID = -3515152604847457796L;
    public MyPoint location = new MyPoint(0, 0);
    public ArrayList<MyPoint> touchzone = new ArrayList<>();
    MyPolygon polygon;
    public boolean deletable = true;



    public int width = 10;

    public String elemid;
    public static int numInstances;

    //   public int size = 0;
    //  public int rotation;
    public boolean movable = true;



    public  void tick()
{


}

    public  void render(Canvas g)
{



}

    public  void move(MyPoint coord)
{



}


    public  boolean touchhit(Point coord)
    {
        boolean inpol = false;

        inpol=polygon.contains(coord);

        return inpol;


    }
    public  void setedgescount(int count)
    {

    }
}
