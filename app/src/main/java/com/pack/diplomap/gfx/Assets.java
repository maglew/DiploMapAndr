package com.pack.diplomap.gfx;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.pack.diplommapandr.R;

import java.io.ByteArrayOutputStream;


public class Assets
{
    public static Bitmap firstFloor, secondFloor, thirdFloor, forthFloor;
    public static Bitmap firstlegend, secondlegend, thirdlegend, forthlegend;

    public static void init(Bitmap sheet)
    {
        /*
        SpriteSheet tsheet=new SpriteSheet(sheet);

        firstFloor = tsheet.crop2(909, 913, 3589,3369);
        secondFloor = tsheet.crop2(909, 3493, 3589, 5621);
        thirdFloor = tsheet.crop2(909 , 5713, 3589, 7897);
        forthFloor = tsheet.crop2(909 , 8025, 3589, 9313);

         */
    }

    public static void init2(Activity MA)
    {

        firstFloor = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.firstfloor));
        secondFloor = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.secondfloor));
        thirdFloor = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.thirdfloor));
        forthFloor = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.fourthfloor));

        /*
        firstlegend = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.legfirst));
        secondlegend = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.legsecond));
        thirdlegend = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.legthird));
        forthlegend = Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.legfourth));
*/



        firstFloor = Bitmap.createScaledBitmap(firstFloor, 2685, 2469, false);
        secondFloor = Bitmap.createScaledBitmap(secondFloor, 2685, 2145, false);
        thirdFloor = Bitmap.createScaledBitmap(thirdFloor, 2681, 2189, false);
        forthFloor = Bitmap.createScaledBitmap(forthFloor, 2689, 1293, false);


    }




}
