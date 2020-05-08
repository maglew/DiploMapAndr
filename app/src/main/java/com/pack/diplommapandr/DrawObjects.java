package com.pack.diplommapandr;

import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Iterator;

public class DrawObjects {

    public  ArrayList<MapElement> elements = new ArrayList<>();
    public  ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Grid> grids = new ArrayList<>();
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Wall> walls = new ArrayList<>();

    public DrawObjects()
    {
        rasst();
    }


    public  void addobj()
    {

    }


    public  void rasst()
    {

        elements.clear();

        elements.addAll(grids);
        elements.addAll(edges);
        //  elements.addRange(zones);
        elements.addAll(rooms);
        elements.addAll(walls);

    }


    public void tick(Point worldloc, int size)
    {
        Iterator<MapElement> itermo=elements.iterator();
        while(itermo.hasNext())
        {
            MapElement mo=itermo.next();
            mo.tick(worldloc,size);
        }
    }

    public void render(Canvas g)
    {
        Iterator<MapElement> itermo=elements.iterator();
        while(itermo.hasNext())
        {
            MapElement mo=itermo.next();
            mo.render(g);
        }
    }



    public  void delobj(int id)
    {
        if (id != -1)
        { elements.remove((elements.get(id))); }

    }
/*
    public  int searchObjByCoord(Point touchcoord)
    {
        int i = 0;

        foreach (MapElement mo in elements)
        {
            if (mo.touchhit(touchcoord) && mo.deletable)
            {
                return i;
            }
            i++;
        }

        return -1;
    }
*/
    public  MapElement getElement(int id)
    {
        return elements.get(id);
    }


    public  void moveElement(int id, Point coord)
    {
        elements.get(id).move(coord);
    }
/*
    public  void setElement(MapElement element)
    {
        for (int i = 0; i < elements.; i++)
        {
            if (elements.get(i).id== element.id)
            {
                elements.get(i) = element;
            }
        }
    }
*/


    public  void addNewEdge(Point coord)
    {
        // elements.add(new com.pack.diplommapandr.Edge(coord));
        edges.add(new Edge(coord));
        rasst();
    }

    /*
    public void addNewRoom(Point coord)
    {

        edges.add(new com.pack.diplommapandr.Edge(new Point(coord.x - 50, coord.y - 50)));
        edges.add(new com.pack.diplommapandr.Edge(new Point(coord.x + 50, coord.y - 50)));
        edges.add(new com.pack.diplommapandr.Edge(new Point(coord.x + 50, coord.y + 50)));
        edges.add(new com.pack.diplommapandr.Edge(new Point(coord.x - 50, coord.y + 50)));

        rooms.add(new Room(edges[edges.size()-4], edges[edges.size() - 3], edges[edges.size() - 2], edges[edges.size() - 1]));

        rasst();
    }
*/
    public  void addNewWall(int a, int b)
    {
        walls.add(new Wall(edges.get(a-1),edges.get(b-1)));
        rasst();
    }

}