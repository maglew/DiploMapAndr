package com.pack.diplomap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.pack.diplomap.gfx.Assets;
import com.pack.diplommapandr.R;


public class GameManager
{
    private MainThread mainThread;
    private Activity MA;

    public GameManager(Activity  MA)
    {
        this.MA=MA;
        //  Options.startupOptions();

    }
    public   void game_init()
    {
        Assets.init2(MA);
    }

    public Activity getMA() {
        return MA;
    }
}