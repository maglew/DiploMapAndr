package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import com.pack.diplomap.MapCamera;
import com.pack.diplomap.MapPanel;

import java.io.Serializable;

import static java.lang.Math.round;

public class Edge extends MapElement implements Serializable
{
    private static final long serialVersionUID = -2515152604847457796L;


    public Edge(MyPoint coord)
    {
        this.movable = true;
        location = coord;

        this.touchzone.add(0,new MyPoint(location.x   - 10,location.y   - 10));
        this.touchzone.add(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.add(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.add(3,new MyPoint(location.x   - 10,location.y   +10));
        this.relativetouchzone=touchzone;
        elemid = ++MapElement.numInstances + "E";
    }

    public Edge()
    {

        this.movable = true;

        location = new MyPoint(0,0);

        this.touchzone.add(0,new MyPoint(location.x   - 10,location.y   - 10));
        this.touchzone.add(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.add(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.add(3,new MyPoint(location.x   - 10,location.y   +10));
        this.relativetouchzone=touchzone;
        elemid = ++MapElement.numInstances + "E";
    }

@Override
    public  void tick()
{
    this.relativetouchzone.set(0,new MyPoint(location.x   - 10 ,location.y   - 10));
    this.relativetouchzone.set(1,new MyPoint(location.x   + 10,location.y   - 10));
    this.relativetouchzone.set(2,new MyPoint(location.x   + 10,location.y   + 10));
    this.relativetouchzone.set(3,new MyPoint(location.x   - 10,location.y   +10));

    for(int i=0;i<relativetouchzone.size();i++)
    {
        touchzone.set(i,new MyPoint((relativetouchzone.get(i).x)*round(MapPanel.mapCamera.getSize()),(relativetouchzone.get(i).y)*round(MapPanel.mapCamera.getSize())) );
    }
}

@Override
    public  void render(Canvas g)
{

    Paint p=new Paint();
    p.setColor(Color.YELLOW);

    g.drawRect(location.x - width / 4, location.y - width / 4, location.x + width / 4, location.x + width / 4 ,p);
    p.setColor(Color.RED);

Path path=new Path();

path.moveTo(relativetouchzone.get(0).x,relativetouchzone.get(0).y);
for(int i=1;i<relativetouchzone.size();i++)
{
    path.lineTo(relativetouchzone.get(i).x,relativetouchzone.get(i).y);

}
    path.lineTo(relativetouchzone.get(relativetouchzone.size()-1).x,relativetouchzone.get(relativetouchzone.size()-1).y);
    path.close();
    g.drawPath(path,p);

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
