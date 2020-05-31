package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;

import java.util.ArrayList;

public class MyPolygon
{
    public ArrayList<MyPoint> points = new ArrayList<>();
    Path path;

    public MyPolygon(ArrayList<MyPoint> points)
    {
        this.points = points;
        path=new Path();
        path.moveTo(points.get(0).x,points.get(0).y);
        for(int i=1;i<points.size();i++)
        {
            path.lineTo(points.get(i).x,points.get(i).y);
        }
        path.lineTo(points.get(points.size()-1).x,points.get(points.size()-1).y);
        path.close();
    }


    public void drawMyPolygon(Canvas g)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        g.drawPath(path,p);
    }

    public void fillMyPolygon(Canvas g)
    {



    }

    public boolean contains(Point coord)
    {
        boolean inside=false;

        Region r;
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        r = new Region();
        r.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        if (r.contains(coord.x,coord. y))
        {
            inside=true;
        }


/*
        RectF figureLocationF = new RectF();
        path.computeBounds(figureLocationF, true);
        Rect figureLocation = new Rect((int)Math.floor(figureLocationF.left), (int)Math.floor(figureLocationF.top)
                ,(int)Math.ceil(figureLocationF.right), (int)Math.ceil(figureLocationF.bottom));


        Rect bounds = new Rect();
        Region region = new Region();
        region.setPath(path, new Region(figureLocation));
        region.getBounds(bounds);
        if (region.contains(coord.x,coord. y))
        {
            inpol=true;
        }
*/
        return inside;
       // return  true;
    }

    public ArrayList<MyPoint> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<MyPoint> points) {
        this.points = points;
    }
}
