package com.workshop.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Button1Activity extends AppCompatActivity
{EditText et1,et2,et3,et4,et5,et6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        Intent box=getIntent();
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        et5=(EditText)findViewById(R.id.editText5);
        et6=(EditText)findViewById(R.id.editText6);

        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND,null);
        db.execSQL("create table if not exists Details(_id INTEGER PRIMARY KEY AUTOINCREMENT,id varchar,from1 varchar,to1 varchar,start1 varchar,end1 varchar,budget varchar)");
        db.close();
        Toast.makeText(this, "DATABASE CREATED", Toast.LENGTH_SHORT).show();


    }
    public void insert(View v)
    {
        String id=et1.getText().toString();
        String from1=et2.getText().toString();
        String to1=et3.getText().toString();
        String start1=et4.getText().toString();
        String end1=et5.getText().toString();
        String budget=et6.getText().toString();

        id="'" + id + "'";
        from1="'" + from1 + "'";
        to1="'" + to1 + "'";
        start1="'" + start1 + "'";
        end1="'" + end1 + "'";
        budget="'" + budget + "'";


        String q="insert into Details(id,from1,to1,start1,end1,budget) values ("+id+","+from1+","+to1+","+start1+","+end1+","+budget+")";
        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB",Context.MODE_APPEND,null);//SQLitedb should be opened whenever it is needed
        db.execSQL(q);
        db.close();
        Toast.makeText(this, "record inserted", Toast.LENGTH_SHORT).show();
    }
    public void clickme(View v)
    {
        Intent b=new Intent(Button1Activity.this,ExpenseActivity.class);
        startActivity(b);

    }
}
