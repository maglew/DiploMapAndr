package com.pack.diplomap.MapObjects;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.Serializable;

public class MapImage extends MapElement implements Serializable
{
    private static final long serialVersionUID = -8515152004847457796L;
    transient Bitmap image;

    public MapImage(Bitmap image,MyPoint loc)
    {
        this.image = image;
        this.location=loc;
    }

    public MapImage(MyPoint loc)
    {
        this.location=loc;
    }

    public MapImage()
    {
        this.location=new MyPoint(0,0);
        image=null;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(Canvas g)
    {
        Paint p=new Paint();
        if(image!=null)
            g.drawBitmap(image,location.x,location.y,p);
      //  g.drawImage(image,  location.x, location.y, image.getWidth(), image.getHeight(), null);

    }

    @Override
    public void move(MyPoint coord) {
        super.move(coord);
    }
}
