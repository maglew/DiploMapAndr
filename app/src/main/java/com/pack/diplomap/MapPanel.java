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
    public static boolean drawing;
    private MainThread mainThread;
    public static DrawMap drawmap ;
    int size=1;
    TouchManager touchManager;
    public static   MapCamera mapCamera;
    public  MapInterface mapInterface;
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
        mapInterface=new MapInterface();
    }


    @Override
    public void surfaceCreated(SurfaceHolder p1)
    {
        mainThread.setRunning(true);
        mainThread.start();
        // drawmap.loadmap();
    }

    @Override
    public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
    {

    }

    public void tick()
    {
        mapCamera.tick();
        drawmap.tick();
        mapInterface.tick();
    }

    public void render(Canvas canvas)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);

        canvas.save();
        canvas.drawColor(Color.BLACK);
        Paint  paint=new Paint();
        paint.setColor(Color.WHITE);


        canvas.translate(mapCamera.getWorldloc().x,mapCamera.getWorldloc().y);
        canvas.scale(mapCamera.getSize(),mapCamera.getSize());
        drawmap.render(canvas);

        canvas.restore();
        Paint p2=new Paint();
        p2.setColor(Color.RED);
        canvas.drawText("exception: "+exception,400,100,p);
        touchManager.render(canvas);
        mapCamera.render(canvas);
        mapInterface.render(canvas);

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

