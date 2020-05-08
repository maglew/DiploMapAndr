package com.pack.diplommapandr.activities;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pack.diplommapandr.GameManager;
import com.pack.diplommapandr.MapPanel;
import com.pack.diplommapandr.R;

public class MapActivity extends Activity
{
    MapPanel mapPanel;
    int zoom=100;
    //Состояние кнопки редактирования/сдвига
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        gameManager = new GameManager(this);
        mapPanel=findViewById(R.id.canvasPanelSing);

        //prepareNewGame();
/*
        Button inButton = findViewById(R.id.panelButtZIn);
        // Устанавливаем действие по нажатию
        inButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom=zoom+10;
               mapPanel.getCam().setZoom(zoom);
            }
        });

        Button outButton = findViewById(R.id.panelButtZOut);
        // Устанавливаем действие по нажатию
        outButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapPanel.getCam().getZoom()>0)
                {zoom=zoom-10;
                mapPanel.getCam().setZoom(zoom);}
            }
        });

        Button alignButton = findViewById(R.id.panelButtAlign);
        // Устанавливаем действие по нажатию
        alignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
mapPanel.getCam().setCamlocation(new PointF(0,0));
            }
        });

        Button moveButton = findViewById(R.id.panelButtMoveRegime);
        // Устанавливаем действие по нажатию
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapPanel.isMoveRegime())
                mapPanel.setMoveRegime(false);
                else
                mapPanel.setMoveRegime(true);
            }
        });

        Button delButton = findViewById(R.id.panelDelButt);
        // Устанавливаем действие по нажатию
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapPanel.isDelregime())
                    mapPanel.setDelregime(false);
                else
                    mapPanel.setDelregime(true);
            }
        });

*/

    }

    private void prepareNewGame()
    {

        gameManager.game_init();
    }
}
