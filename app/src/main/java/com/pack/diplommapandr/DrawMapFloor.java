package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Point;

public class DrawMapFloor
{
    public DrawObjects drawObjects;

    public DrawMapFloor()
    {
        drawObjects = new DrawObjects();
    }

    public void tick(Point wordloc, int size)
    {
        drawObjects.tick(wordloc,size);
    }

    public void render(Canvas g)
    {
        drawObjects.render(g);
    }

    public DrawObjects getdraw()
    {
        return drawObjects;
    }


}
