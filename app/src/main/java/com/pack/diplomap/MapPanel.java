package com.pack.diplomap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.pack.diplomap.MapObjects.DrawMap;


public class MapPanel extends SurfaceView implements SurfaceHolder.Callback
{

    boolean moveRegime=true;

    private MainThread mainThread;
    public static DrawMap drawmap ;
    int size=1;
    TouchManager touchManager;
    MapCamera mapCamera;
public static Logs log;
    public static int exception=0;


    public MapPanel(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        getHolder().addCallback(this);
        log=new Logs();
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
        Paint p=new Paint();
        p.setColor(Color.RED);

        canvas.save();
        canvas.drawColor(Color.BLACK);
        Paint  paint=new Paint();
        paint.setColor(Color.WHITE);

        drawmap.render(canvas);
        touchManager.render(canvas);
        mapCamera.render(canvas);

        canvas.drawText("exception: "+exception,100,500,p);

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
        return true;
    }

    public static void setmap(DrawMap map)
    {
drawmap=map;
    }

    public static void getmap()
    {

return;
    }

}
