package com.pack.diplomap.activities;

import android.app.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.pack.diplomap.GameManager;
import com.pack.diplomap.MapObjects.DrawMap;
import com.pack.diplomap.MapObjects.DrawMapFloor;
import com.pack.diplomap.MapObjects.MyPoint;
import com.pack.diplomap.MapObjects.Room;
import com.pack.diplomap.MapObjects.RoomInfo;
import com.pack.diplomap.MapPanel;
import com.pack.diplomap.gfx.Assets;
import com.pack.diplommapandr.R;

public class MapActivity extends Activity {

    MapPanel mapPanel;
    final int DIALOG = 1;
    static RoomInfo roomInfo = new RoomInfo();
    LinearLayout view;
    //Состояние кнопки редактирования/сдвига
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        gameManager = new GameManager(this);
        mapPanel = findViewById(R.id.canvasPanelSing);
        MapPanel.drawing=false;
        prepareNewGame();
        MapPanel.drawmap.loadmap();
        //prepareNewGame();

        Button zoominbutt = findViewById(R.id.zoominbutt);
        // Устанавливаем действие по нажатию
        zoominbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize() * 2);
            }
        });

        Button zoomoutbutt = findViewById(R.id.zoomoutbutt);
        // Устанавливаем действие по нажатию
        zoomoutbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize() / 2);
            }
        });

        Button findButt = findViewById(R.id.findbutt);
        // Устанавливаем действие по нажатию
        findButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText editText=findViewById(R.id.editText);
                String text=editText.getText().toString();
                int num=Integer.parseInt( text);
                int floornum=0;

                for(DrawMapFloor floor: MapPanel.drawmap.floors)
                {
                    for(Room room : floor.drawObjects.rooms)
                    {
                        if(room.roomInfo.getNumber() ==num)
                        {
                            MapPanel.drawmap.selectedfloor=floornum;
                            //   State.getCurrentState().mapCamera.relativeworldlocation.setLocation( new Point(room.location.x,room.location.y));
                            MapPanel.drawmap.floors.get(floornum).drawObjects.addPointer(new MyPoint(room.location.x,room.location.y));

                            //State.getCurrentState().drawMap.floors.get(floornum).drawObjects.clearadd();
                            // location=(new MyPoint(room.location.x,room.location.y));
                        }
                    }

                    floornum++;
                }
            }
        });

        Button regimebutt = findViewById(R.id.regimebutt);
        // Устанавливаем действие по нажатию
        regimebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapPanel.mapInterface.getRegime() == "move")
                    mapPanel.mapInterface.setRegime("touch");
                else
                    mapPanel.mapInterface.setRegime("move");
            }
        });

        Spinner spinner = findViewById(R.id.floorspin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // int floor = i ;

                MapPanel.drawmap.setSelectedfloor(i);


            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                MapPanel.drawmap.setSelectedfloor(0);
            }
        });


    }


    private void prepareNewGame() {
        gameManager.game_init();
    }

}


