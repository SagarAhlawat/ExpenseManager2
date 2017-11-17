package com.workshop.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteTripActivity extends AppCompatActivity
{
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_trip);
        Intent b6=getIntent();
        et=(EditText)findViewById(R.id.editText1);
    }


    public void deletetrip(View v)
    {
        int cid=Integer.parseInt(et.getText().toString());
        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND,null);
        String query="delete from Details where _id=" + cid;
        db.execSQL(query);
        Toast.makeText(this, "Record deleted", Toast.LENGTH_SHORT).show();
    }
}
