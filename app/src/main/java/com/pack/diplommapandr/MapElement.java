package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class MapElement
{
    // public Rectangle touchrect = new Rectangle(0, 0, 0, 0);
    public String text = "";


    public ArrayList<Point> touchzone = new ArrayList<>();
   // public ArrayList<byte> bordType = new ArrayList<>();


    public boolean deletable = true;

    public Point location = new Point(0, 0);
    public Point relativeLocation = new Point(0, 0);

    //public List<Point> locpoints = new List<Point>();
    //public List<Point> relpoints = new List<Point>();


    public int width = 10;
    //public Guid id;

    public int size = 0;
    //  public int rotation;
    public boolean movable = true;


    public  void tick(Point wordloc, int size)
{
    this.size = size;




}

    public  void render(Canvas g)
{



}

    public  void move(Point coord)
{



}


/*

    public virtual bool touchhit(Point coord)
{
    bool inpol = false;

    using (var p = new GraphicsPath(touchzone.ToArray(), bordType.ToArray()))
    {
        var newVal = p.IsVisible(coord);
        if (newVal != inpol)
        {
            inpol = newVal;
        }
    }

    return inpol;
}
*/

/*
    public virtual void setedgessize()(int size())
{
    //if (size() == locpoints.size())
    //{ return; }
    //if (size() > locpoints.size())
    //{
    //    for (int i = 0; i < size() - locpoints.size(); i++)
    //    {
    //        locpoints.add(new Point(locpoints[locpoints.size() - 1].x + 15, locpoints[locpoints.size() - 1].y + 15));
    //        relpoints.add(new Point(locpoints[locpoints.size() - 1].x + MapCamera.worldlocation.x, locpoints[locpoints.size() - 1].y + MapCamera.worldlocation.y));
    //        touchzone.add(locpoints.get(i));
    //        bordType.add(1);


    //    }
    //}
    //if (size() < locpoints.size())
    //{
    //    for (int i = locpoints.size() - 1; i > size() - 1; i--)
    //    {
    //        locpoints.RemoveAt(i);
    //        relpoints.RemoveAt(i);
    //        touchzone.RemoveAt(i);
    //        bordType.RemoveAt(i);

    //    }
    //}
}
*/
}
