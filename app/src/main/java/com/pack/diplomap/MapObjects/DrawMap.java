package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;

import android.os.Environment;

import com.pack.diplomap.MapPanel;
import com.pack.diplomap.gfx.Assets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class DrawMap implements Serializable
{


    private static final long serialVersionUID = -6515152604847457796L;

    public  int selectedfloor = 0;
    public ArrayList<DrawMapFloor> floors = new ArrayList<>();


    public DrawMap()
    {
        for (int i = 0; i < 4; i++)
        { floors.add(new DrawMapFloor()); }
        add();

    }

    public void tick()
    {
        floors.get(selectedfloor).tick();
    }

    public void render(Canvas g)
    {
        floors.get(selectedfloor).render(g);
    }


    public void loadmap()
    {
        DrawMap newmap=new DrawMap();
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myfile = new File(root+"/DiplomapAndr" , "DiplomapPc.dat");
            FileInputStream fis = new FileInputStream(myfile);
            ObjectInputStream is = new ObjectInputStream(fis);/////////////

            newmap=(DrawMap)is.readObject();

            is.close();
            fis.close();

            MapPanel.setmap(newmap);

        }
        catch (Throwable t)
        {
            MapPanel.log.addtolog(t.toString());
        }
    }

public void savemap()
{
    try {
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
        File myDir = new File(root , "DiplomapAndr");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }

        String fname = "DiplomapPc.dat";
        File file = new File (myDir, fname);
        if (file.exists ())
            file.delete ();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(MapPanel.drawmap);


        os.close();
        fos.close();


    } catch (Throwable t) {
MapPanel.log.addtolog(t.toString());
    }

}



    public  void add()
    {
        //  floors.get(0).drawObjects.grids.add(new Grid(10, 100));

     //   floors.get(0).drawObjects.addNewRoom(new MyPoint(100,100) );

     //   floors.get(0).drawObjects.addNewRoom(new MyPoint(120,200) );

     //   floors.get(0).drawObjects.addNewRoom(new MyPoint(250,350) );

        //  floors.get(1).drawObjects.grids.add(new Grid(10, 100));
        floors.get(0).drawObjects.image= new MapImage(Assets.firstFloor,new MyPoint(0,0) );
        floors.get(1).drawObjects.image= new MapImage(Assets.secondFloor,new MyPoint(0,0) );
        floors.get(2).drawObjects.image= new MapImage(Assets.thirdFloor,new MyPoint(0,0) );
        floors.get(3).drawObjects.image= new MapImage(Assets.forthFloor,new MyPoint(0,0) );
        /*
        floors.get(0).drawObjects.image.add(new MapImage(Assets.firstFloor,new MyPoint(0,0) ));
        floors.get(1).drawObjects.image.add(new MapImage(Assets.secondFloor,new MyPoint(0,0) ));
        floors.get(2).drawObjects.image.add(new MapImage(Assets.thirdFloor,new MyPoint(0,0) ));
        floors.get(3).drawObjects.image.add(new MapImage(Assets.forthFloor,new MyPoint(0,0) ));
*/
        //   floors.get(2).drawObjects.grids.add(new Grid(10, 100));

        floors.get(0).drawObjects.rasst();
        floors.get(1).drawObjects.rasst();
        floors.get(2).drawObjects.rasst();
        floors.get(3).drawObjects.rasst();
    }

    public int getSelectedfloor() {
        return selectedfloor;
    }

    public void setSelectedfloor(int selectedfloor) {
        this.selectedfloor = selectedfloor;
    }
}
