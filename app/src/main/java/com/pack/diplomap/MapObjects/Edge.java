package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
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
        elemid = ++MapElement.numInstances + "E";
    //    polygon=new MyPolygon(touchzone);
    }

    public Edge()
    {
        this.movable = true;

        location = new MyPoint(0,0);

        this.touchzone.add(0,new MyPoint(location.x   - 10,location.y   - 10));
        this.touchzone.add(1,new MyPoint(location.x   + 10,location.y   - 10));
        this.touchzone.add(2,new MyPoint(location.x   + 10,location.y   + 10));
        this.touchzone.add(3,new MyPoint(location.x   - 10,location.y   +10));
        elemid = ++MapElement.numInstances + "E";
    //    polygon=new MyPolygon(touchzone);
    }

@Override
    public  void tick()
{
    this.touchzone.set(0,new MyPoint(location.x   - 10 ,location.y   - 10));
    this.touchzone.set(1,new MyPoint(location.x   + 10,location.y   - 10));
    this.touchzone.set(2,new MyPoint(location.x   + 10,location.y   + 10));
    this.touchzone.set(3,new MyPoint(location.x   - 10,location.y   +10));
}

@Override
    public  void render(Canvas g)
{
    if(MapPanel.drawing) {
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        g.drawRect(location.x - 5, location.y - 5, location.x + 5, location.y + 5, p);

        p.setColor(Color.RED);


        Path path = new Path();
        path.moveTo(touchzone.get(0).x, touchzone.get(0).y);
        for (int i = 1; i < touchzone.size(); i++) {
            path.lineTo(touchzone.get(i).x, touchzone.get(i).y);

        }
        path.lineTo(touchzone.get(touchzone.size() - 1).x, touchzone.get(touchzone.size() - 1).y);
        path.close();
        g.drawPath(path, p);


        //  polygon.drawMyPolygon(g);
    }
}
    @Override
    public  void move(MyPoint coord)
    {
        location = new MyPoint(coord.x, coord.y);
    }


    @Override
    public boolean touchhit(Point coord)
    {
        return super.touchhit(coord);
    }

}
