package com.pack.diplomap.gfx;

import android.graphics.Bitmap;



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
