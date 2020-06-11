package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;



import java.util.ArrayList;

public class MyPointer
{
    public MyPoint location ;
    public ArrayList<MyPoint> points = new ArrayList<>();

    public MyPointer(MyPoint coord)
    {

        location = coord;
        this.points.add(0,new MyPoint(location.x   ,location.y  ));
        this.points.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.points.add(2,new MyPoint(location.x   + 50,location.y   - 50));

    }

    public MyPointer()
    {

        location = new MyPoint(0,0);
        this.points.add(0,new MyPoint(location.x   ,location.y  ));
        this.points.add(1,new MyPoint(location.x   -50,location.y   - 50));
        this.points.add(2,new MyPoint(location.x   + 50,location.y   - 50));


    }


    public  void tick()
    {

    }

    public  void render(Canvas g)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);

        Path path=new Path();
        path.moveTo(points.get(0).x,points.get(0).y);
        for(int i=1;i<points.size();i++)
        {
            path.lineTo(points.get(i).x,points.get(i).y);

        }
        path.lineTo(points.get(points.size()-1).x,points.get(points.size()-1).y);
        path.close();
        g.drawPath(path,p);
    }






}
