package com.pack.diplomap.gfx;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;


public class SpriteSheet {

	private Bitmap sheet;
	public SpriteSheet(Bitmap sheet)
	{
		this.sheet=sheet;
	}
	public Bitmap crop(int x,int y,int width,int height)
	{
		return Bitmap.createBitmap(sheet,x,y,width,height,null,false);
	}

	public Bitmap crop2(int x1,int y1,int x2,int y2)
	{
		return Bitmap.createBitmap(sheet,x1,y2,x2-x1,y2-y1,null,false);
	}

	public Bitmap crop0(int width,int height)
	{
		return Bitmap.createBitmap(sheet,0,0,width,height,null,false);
	}
	public Bitmap compress(int quality)
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		sheet.compress(Bitmap.CompressFormat.JPEG,quality,stream);
		byte[] byteArray = stream.toByteArray();
		return BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
	}

	public Bitmap getSheet() {
		return sheet;
	}

	public int getHeight()
	{
	return	sheet.getHeight();
	}
	public int getWidth()
	{
		return	sheet.getWidth();
	}
}
