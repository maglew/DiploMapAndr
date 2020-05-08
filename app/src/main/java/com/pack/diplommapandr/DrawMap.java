package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class DrawMap
{
    public static int selectedfloor = 0;
    public ArrayList<DrawMapFloor> floors = new ArrayList<>();


    public DrawMap()
    {
        for (int i = 0; i < 3; i++)
        { floors.add(new DrawMapFloor()); }
        load();
    }

    public void tick(Point wordloc, int size)
    {

        floors.get(selectedfloor).tick(wordloc, size);
    }

    public void render(Canvas g)
    {
        floors.get(selectedfloor).render(g);
    }

   /*
    public void saveSer(String path)
    {
        BinaryFormatter formatter = new BinaryFormatter();
        FileStream savestream = null;
        //SoapFormatter formatter = new SoapFormatter();
        String text = "";
        using (FileStream fs = new FileStream(path + "TcMap.dat", FileMode.OpenOrCreate))
        {
            formatter.Serialize(fs, MapPanel.map);
            formatter.Serialize(fs, MapPanel.map.floors);


        }

    }
    */
    public  void load()
    {

        floors.get(0).drawObjects.grids.add(new Grid(10, 10, 50));
        //floors[0].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(100, 100)));
        //floors[0].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(200, 200)));
        //floors[0].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(100, 200)));
        //floors[0].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(200, 100)));


        floors.get(1).drawObjects.grids.add(new Grid(10, 10, 50));



        floors.get(2).drawObjects.grids.add(new Grid(10, 10, 50));


        //floors[2].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(100, 100)));
        //floors[2].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(200, 100)));
        //floors[2].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(200, 200)));
        //floors[2].drawObjects.edges.add(new com.pack.diplommapandr.Edge(new Point(100, 200)));


        //floors[2].drawObjects.rooms.add(new Room(floors[2].drawObjects.edges[0], floors[2].drawObjects.edges[1],
        //floors[2].drawObjects.edges[2], floors[2].drawObjects.edges[3]));




        floors.get(0).drawObjects.rasst();
        floors.get(1).drawObjects.rasst();
        floors.get(2).drawObjects.rasst();
    }
/*
    public  void loadSer(String path)
    {
        DrawMap newMap;
        // SoapFormatter formatter = new SoapFormatter();
        BinaryFormatter formatter = new BinaryFormatter();


        using (FileStream fs = new FileStream(path + "TcMap.dat", FileMode.OpenOrCreate))
        {
            newMap = (DrawMap)formatter.Deserialize(fs);

            newMap.floors= formatter.Deserialize(fs) as List<DrawMapFloor>;

            MapPanel.map = newMap;
        }

    }
*/
}
