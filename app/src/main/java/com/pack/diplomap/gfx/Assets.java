package com.pack.diplomap.gfx;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.pack.diplommapandr.R;


public class Assets
{
    public static Bitmap firstFloor, secondFloor, thirdFloor, forthFloor;

    public static void init(Bitmap sheet)
    {
        SpriteSheet tsheet=new SpriteSheet(sheet);

        firstFloor = tsheet.crop2(909, 913, 3589,3369);
        secondFloor = tsheet.crop2(909, 3493, 3589, 5621);
        thirdFloor = tsheet.crop2(909 , 5713, 3589, 7897);
        forthFloor = tsheet.crop2(909 , 8025, 3589, 9313);
    }

    public static void init2(Activity MA)
    {
        SpriteSheet first = new SpriteSheet(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.firstfloor)));
        SpriteSheet second = new SpriteSheet(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.secondfloor)));
        SpriteSheet third = new SpriteSheet(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.thirdfloor)));
        SpriteSheet fourth = new SpriteSheet(Bitmap.createBitmap(BitmapFactory.decodeResource(MA.getResources(), R.drawable.fourthfloor)));

        firstFloor = first.getSheet();
        secondFloor = second.getSheet();
        thirdFloor = third.getSheet();
        forthFloor = fourth.getSheet();
    }


}
