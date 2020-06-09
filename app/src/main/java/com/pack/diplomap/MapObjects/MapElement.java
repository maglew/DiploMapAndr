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
    public ArrayList<MyPoint> touchzone = new ArrayList<>();
    public boolean deletable = true;
    public MyPoint location = new MyPoint(0, 0);
    public int width = 10;
    RoomInfo roomInfo;
    public String elemid;
    public static int numInstances;
    //  public int rotation;
    public boolean movable = true;

    transient MyPolygon polygon;

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

    public RoomInfo getRoomInfo()
    {
        return  roomInfo;
    }
}
