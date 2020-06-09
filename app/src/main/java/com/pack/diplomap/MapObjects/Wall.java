package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;


import java.io.Serializable;

public class Wall extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1415152604847457796L;
    Edge A;
    Edge B;
    int id;
    MyPoint dest;

    public Wall(Edge A, Edge B)
    {
        movable = true;
        this.A = A;
        this.B = B;
        id++;
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));

        touchzone.add(new MyPoint(A.location.x + 3, A.location.y - 3));
        touchzone.add(new MyPoint(B.location.x + 3, B.location.y - 3));
        touchzone.add(new MyPoint(B.location.x - 3, B.location.y + 3));
        touchzone.add(new MyPoint(A.location.x - 3, A.location.y + 3));
        elemid =++MapElement.numInstances+"W";
    }

    public Wall()
    {
        movable = true;
        this.A = new Edge(new MyPoint(0,0));
        this.B = new Edge(new MyPoint(0,0));
        id++;
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));
        touchzone.add(new MyPoint(A.location.x + 3, A.location.y - 3));
        touchzone.add(new MyPoint(B.location.x + 3, B.location.y - 3));
        touchzone.add(new MyPoint(B.location.x - 3, B.location.y + 3));
        touchzone.add(new MyPoint(A.location.x - 3, A.location.y + 3));
        elemid =++MapElement.numInstances+"W";
    }

    @Override
    public  void tick()
    {
        dest = new MyPoint(Math.abs(B.location.x - A.location.x), Math.abs(B.location.y - A.location.y));
        A.tick();
        B.tick();
        touchzone.set(0,new MyPoint( A.location.x + 3, A.location.y - 3));
        touchzone.set(1,new MyPoint( B.location.x + 3, B.location.y - 3));
        touchzone.set(2,new MyPoint( B.location.x - 3, B.location.y + 3));
        touchzone.set(3,new MyPoint( A.location.x - 3, A.location.y + 3));


    }

@Override
    public  void render(Canvas canvas)
{
    Paint p=new Paint();
    p.setColor(Color.GREEN);
    p.setStrokeWidth(3);
    canvas.drawLine(A.location.x,A.location.y,B.location.x,B.location.y,p);
    //g.DrawPolygon(pen2, touchzone.ToArray());
}



    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public boolean touchhit(Point coord)
    {
        return false;
    }


}
