package com.workshop.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Button2Activity extends AppCompatActivity
{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        //Intent box2 = getIntent();

        tv = (TextView) findViewById(R.id.textView1);
        SQLiteDatabase db = openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND, null);
        Cursor cursor = db.rawQuery("Select * from Details", null);
        tv.setText("All Trip Details \n------------------------------\n");
        while (cursor.moveToNext())
        {
            int roll=cursor.getInt(0);
            String id = cursor.getString(1);
            String from1 = cursor.getString(2);
            String to1 = cursor.getString(3);
            String start1 = cursor.getString(4);
            String end1 = cursor.getString(5);
            String budget = cursor.getString(6);

            String details =roll+"\t\t" + id + "\t\t" + from1 + "\t\t" + to1 + "\t\t" + start1 + "\t\t" + end1 + "\t\t" + budget + "\n";
            tv.append(details);

        }

        Cursor cursor1=db.rawQuery("Select * from Expenses",null);
        tv.append("expense table---------------------\n");
        while(cursor1.moveToNext())
        {int roll=cursor1.getInt(0);

            String category=cursor1.getString(1);
            String amount=cursor1.getString(2);
            String date2=cursor1.getString(3);
            String tid=cursor1.getString(4);

            String details1=roll+"\t\t" + category + "\t\t" + amount + "\t\t" +date2 +"\t\t" + tid +"\n";
            tv.append(details1);



        }
    }
}
