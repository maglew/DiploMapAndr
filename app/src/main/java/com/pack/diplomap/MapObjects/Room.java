package com.pack.diplomap.MapObjects;

import android.graphics.Canvas;
import android.graphics.Point;


import com.pack.diplomap.MapPanel;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;

public class Room extends MapElement implements Serializable
{
    private static final long serialVersionUID = -1315152604847457796L;
    public ArrayList<Wall> walls = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<MyPoint> dest = new ArrayList<>();

    public static int Statnumber=0;
    public  int number=0;
    public RoomInfo roomInfo;

    public Room(Edge A, Edge B, Edge C, Edge D)
    {
        location = new MyPoint((A.location.x+ C.location.x)/2, (A.location.y + C.location.y) / 2);
        this.movable = true;

        this.edges.add(A);
        this.edges.add(B);
        this.edges.add(C);
        this.edges.add(D);

        walls.add(new Wall(A, B));
        walls.add(new Wall(B, C));
        walls.add(new Wall(C, D));
        walls.add(new Wall(D, A));

        touchzone.add(edges.get(0).location);
        touchzone.add(edges.get(1).location);
        touchzone.add(edges.get(2).location);
        touchzone.add(edges.get(3).location);

        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
        Room.Statnumber++;
        number+=Room.Statnumber;
        roomInfo=new RoomInfo();
       // polygon=new MyPolygon(touchzone);
    }

    public Room()
    {
        location = new MyPoint(0, 0);
        this.movable = true;
        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));
        this.edges.add(new Edge(new MyPoint(0,0)));

        walls.add(new Wall(new Edge(new MyPoint(0,0)),new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));
        walls.add(new Wall(new Edge(new MyPoint(0,0)), new Edge(new MyPoint(0,0))));

        touchzone.add(edges.get(0).location);
        touchzone.add(edges.get(1).location);
        touchzone.add(edges.get(2).location);
        touchzone.add(edges.get(3).location);
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));
        dest.add(new MyPoint(0, 0));

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }
        elemid =++MapElement.numInstances+"R";
        roomInfo=new RoomInfo();

    }

    @Override
    public  void tick()
    {

        for (int i = 0; i < dest.size(); i++)
        {
            dest.get(i).set(location.x - edges.get(i).location.x, location.y - edges.get(i).location.y);
        }

        for (int j = 0; j < edges.size() ; j++)
        {
            edges.get(j).tick();

        }


        for (int j = 0; j < walls.size() ; j++)
        {
            walls.get(j).tick();

        }

        for (int j = 0; j < touchzone.size() ; j++)
        {
            touchzone.set(j,new MyPoint( edges.get(j).location.x,edges.get(j).location.y));
        }
    }

    @Override
    public  void render(Canvas g)
    {

        for (int j = 0; j < edges.size() ; j++)
        {
            edges.get(j).render(g);

        }


        for (int j = 0; j < walls.size() ; j++)
        {
            walls.get(j).render(g);

        }
/*
        g.setColor(Color.red);
        Polygon poly=new Polygon();
        for(int i=0;i<relativetouchzone.size();i++)
        {
            poly.addPoint(relativetouchzone.get(i).x/round(State.getCurrentState().mapCamera.getSize()),relativetouchzone.get(i).y/round(State.getCurrentState().mapCamera.getSize()));
        }

        g.drawPolygon(poly);

 */

      //  polygon.drawMyPolygon(g);
    }

    @Override
    public  void move(MyPoint coord)
    {
        location = new MyPoint(coord.x, coord.y);

        for (int j = 0; j < edges.size(); j++)
        {
            edges.get(j).move(new MyPoint(coord.x-dest.get(j).x, coord.y-dest.get(j).y ));
        }
    }


    @Override
    public boolean touchhit(Point coord)
    {
        boolean inpol = false;
        MyPolygon polygon;
        polygon=new MyPolygon(touchzone);
          inpol=polygon.contains(coord);

        return inpol;
    }

    @Override
    public RoomInfo getRoomInfo()
    {
        return this.roomInfo;
    }
}
