package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Wall extends MapElement
{
    Edge A;
    Edge B;
    int id;
    Point dest;

    public Wall(Edge A, Edge B)
    {
        movable = true;
        this.A = A;
        this.B = B;
        id++;
        dest = new Point(Math.abs(B.relativeLocation.x - A.relativeLocation.x), Math.abs(B.relativeLocation.y - A.relativeLocation.y));

        touchzone.add(new Point(A.relativeLocation.x + 3, A.relativeLocation.y - 3));
        touchzone.add(new Point(B.relativeLocation.x + 3, B.relativeLocation.y - 3));
        touchzone.add(new Point(B.relativeLocation.x - 3, B.relativeLocation.y + 3));
        touchzone.add(new Point(A.relativeLocation.x - 3, A.relativeLocation.y + 3));
/*
        bordType.add(0);
        bordType.add(1);
        bordType.add(1);
        bordType.add(1);
*/
    }


@Override
    public  void tick(Point relativeLocation, int size)
{

    dest = new Point(Math.abs(B.relativeLocation.x - A.relativeLocation.x), Math.abs(B.relativeLocation.y - A.relativeLocation.y));
    A.tick(relativeLocation, size);
    B.tick(relativeLocation, size);
    touchzone.get(0).set(A.relativeLocation.x + 3, A.relativeLocation.y - 3);
    touchzone.get(1).set(A.relativeLocation.x + 3, A.relativeLocation.y - 3);
    touchzone.get(2).set(A.relativeLocation.x - 3, A.relativeLocation.y + 3);
    touchzone.get(3).set(A.relativeLocation.x -3, A.relativeLocation.y + 3);

}

@Override
    public  void render(Canvas canvas)
{
    Paint p=new Paint();
    p.setColor(Color.GREEN);
    p.setStrokeWidth(3);
    canvas.drawLine(A.relativeLocation.x,A.relativeLocation.y,B.relativeLocation.x,B.relativeLocation.y,p);
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

}
