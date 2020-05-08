package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;


import java.util.ArrayList;

public class Edge extends MapElement
{

    ArrayList<Edge> neighbors = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();
    Point temp = new Point(0, 0);

    byte[] types = { 0, 1, 1, 1 };
    public Edge(Point coord)
    {
        //  bordType.addRange(types);
        this.movable = true;
       // this.id = Guid.NewGuid();
        location = coord;
        relativeLocation = location;
        //locpoints.add(coord);
        //relpoints.add(locpoints[0]);
        //this.location = coord;
        //this.relativeLocation = location;

        this.touchzone.add(new Point(relativeLocation.x - width / 2-5, relativeLocation.y - width / 2-5));
        this.touchzone.add(new Point(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 - 5));
        this.touchzone.add(new Point(relativeLocation.x - width / 2 + 5, relativeLocation.y - width / 2 + 5));
        this.touchzone.add(new Point(relativeLocation.x - width / 2 - 5, relativeLocation.y - width / 2 + 5));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
        */
    }

@Override
    public  void tick(Point wordloc, int size)
{
    if (temp.x != wordloc.x || temp.y != wordloc.y)
    {
        relativeLocation = new Point(wordloc.x + location.x, wordloc.y + location.y );
        temp = wordloc;
    }
    else
    {
        //      relativeLocation = new Point(wordloc.x + location.x, wordloc.y + location.y);
    }
    //relativeLocation.x = relativeLocation.x * size;
    //relativeLocation.y = relativeLocation.y * size;

    this.touchzone.get(0).set(relativeLocation.x   - 10,relativeLocation.y   - 10);
    this.touchzone.get(1).set(relativeLocation.x   + 10,relativeLocation.y   - 10);
    this.touchzone.get(2).set(relativeLocation.x   + 10,relativeLocation.y   + 10);
    this.touchzone.get(3).set(relativeLocation.x   - 10,relativeLocation.y   + 10);


}

@Override
    public  void render(Canvas g)
{

    Paint p=new Paint();
    p.setColor(Color.WHITE);

    g.drawRect( relativeLocation.x - width / 4, relativeLocation.y - width / 4, width / 2, width / 2,p);
    p.setColor(Color.RED);
 //  float[]a;
    //touchzone.toArray();
  //  g.drawPoints ( touchzone.toArray(a[]),p);

}
/*
@Override
    public  void move(Point coord)
{
    this.relativeLocation = coord;
    this.location = new Point(relativeLocation.x- MapCamera.getWorldLoc().x, relativeLocation.y - MapCamera.getWorldLoc().y);

}
*/

/*
    public override bool touchhit(Point coord)
{

    return base.touchhit(coord);
}
*/
}
