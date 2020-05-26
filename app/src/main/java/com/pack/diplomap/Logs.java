package com.pack.diplomap;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logs
{
    String log="";
    String root ;
    File myDir ;
    File file ;
    String fname = "Log.txt";

    public Logs()
    {
        try {
             root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
             myDir = new File(root, "DiplomapAndr");
             file = new File(myDir, fname);
        }
        catch (Throwable t)
        {

        }
        createnewlog();

    }

    public void createnewlog()
    {
        try {

            if (!myDir.exists()) {
                myDir.mkdirs();
            }

            if (file.exists())
                file.delete();
        }
        catch (Throwable t)
        {

        }
    }

    public void cleanlog()
    {

    }

    public void addtolog(String logstring)
    {
       // Toast toast = Toast.makeText(Manifest, "Hello Android 7", Toast.LENGTH_LONG);
     //   toast.show();

        MapPanel.exception++;

        String buf=MapPanel.exception+") "+ logstring+"\n";
        System.out.println(buf);
        try {

            FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(buf);
            bufferWriter.close();
        }
        catch (Throwable t)
        {

        }


    }
}
