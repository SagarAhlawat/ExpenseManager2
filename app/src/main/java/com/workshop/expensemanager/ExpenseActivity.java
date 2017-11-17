package com.workshop.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity
{EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        Intent b=getIntent();
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);


        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND,null);
        db.execSQL("create table if not exists Expenses(_id INTEGER PRIMARY KEY AUTOINCREMENT,category varchar,amount varchar,date2 varchar,tid varchar)");
        db.close();
        Toast.makeText(this, "DATABASE CREATED", Toast.LENGTH_SHORT).show();

    }
    public void addme(View v)
    {

        String category=et1.getText().toString();
        String amount=et2.getText().toString();
        String date2=et3.getText().toString();
        String tid=et4.getText().toString();

        category="'" + category + "'";
        amount="'" + amount + "'";
        date2="'" + date2 + "'";
        tid="'" + tid + "'";

        String q="insert into Expenses(category,amount,date2,tid) values ("+category+","+amount+","+date2+","+tid+")";
        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB",Context.MODE_APPEND,null);//SQLitedb should be opened whenever it is needed
        db.execSQL(q);
        db.close();
        Toast.makeText(this, "record inserted", Toast.LENGTH_SHORT).show();
    }
}
