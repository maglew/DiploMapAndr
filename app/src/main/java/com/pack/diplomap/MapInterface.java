package com.pack.diplomap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MapInterface
{
    public  static String regime = "move";
    public static int chosedObjId = -1;
    public static  int schot=0;
    public static boolean dragged = false;

    public MapInterface()
    {
    }


    public void tick()
    {

    }

    public void render(Canvas g)
    {
        Paint p=new Paint();
        p.setColor(Color.RED);

        g.drawText("regime:  "+regime,400,50,p);
        g.drawText("objID:  "+chosedObjId,400,60,p);

    }

    public static String getRegime() {
        return regime;
    }

    public static void setRegime(String regime) {
        MapInterface.regime = regime;
    }

    public static int getChosedObjId() {
        return chosedObjId;
    }

    public static void setChosedObjId(int chosedObjId) {
        MapInterface.chosedObjId = chosedObjId;
    }
}