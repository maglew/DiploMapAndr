package com.pack.diplommapandr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class MapPanel extends SurfaceView implements SurfaceHolder.Callback
{
    Point worldLocation=new Point(0,0);
   Point currentTouchCoord =new Point(0,0);
    boolean moveRegime=true;
    boolean delregime=false;
    private MainThread mainThread;
    DrawMap drawmap;
    int size=1;
TouchManager touchManager;
MapCamera mapCamera;


    public MapPanel(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        getHolder().addCallback(this);
        mainThread= new MainThread(getHolder(),this);
        drawmap=new DrawMap();
        Activity MA=(Activity)context;
        touchManager=new TouchManager();
        mapCamera=new MapCamera();
    }


    @Override
    public void surfaceCreated(SurfaceHolder p1)
    {

        mainThread.setRunning(true);
        mainThread.start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
    {

    }

    public void tick()
    {
        mapCamera.tick();
drawmap.tick(mapCamera.relgetWorldLoc(),size);

    }

    public void render(Canvas canvas)
    {
        canvas.save();
        canvas.drawColor(Color.BLACK);
      Paint  paint=new Paint();
        paint.setColor(Color.WHITE);
//canvas.drawPoint(100,100,paint  );
drawmap.render(canvas);
touchManager.render(canvas);
mapCamera.render(canvas);

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder p1)
    {
        boolean retry = true;
        while(retry)
        {
            try{mainThread.setRunning(false);
                mainThread.join();
                retry=false;
            }catch(InterruptedException e)
            {e.printStackTrace();}
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchManager.setevent(event);
      //  currentTouchCoord =new Point(event.getX(),event.getY());
/*
              switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            {   pressCoord.x= event.getX();
                pressCoord.y = event.getY();}
                break;
            case MotionEvent.ACTION_UP:
            {   releaseCoord.x=event.getX();
                releaseCoord.y=event.getY();
                deviation.x=0;
                deviation.y=0;

                }
                break;
            case MotionEvent.ACTION_MOVE:
            {   moved.x=event.getX();
                moved.y=event.getY();
                deviation.x= -(pressCoord.x-moved.x);
                deviation.y= -(pressCoord.y-moved.y);
                //tempDeviation= deviation;
            }
                break;



        }
*/
       // currentTouchCoord =new PointF(event.getX(),event.getY());
        return true;
    }

}

