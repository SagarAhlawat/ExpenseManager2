package com.workshop.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent splash=getIntent();
    }

    public void start(View v)
    {
        //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        Intent box = new Intent(MainActivity.this, Button1Activity.class);
        startActivity(box);

    }

    public void showme(View v)
    {
        Intent box2 = new Intent(MainActivity.this, View2Activity.class);
        startActivity(box2);

    }

    public void dance(View v)
    {
        Intent b5 = new Intent(MainActivity.this, ExpenseViewActivity.class);
        startActivity(b5);
    }

    public void tripdelete(View v)
    {
        Intent b6=new Intent(MainActivity.this,DeleteTripActivity.class);
        startActivity(b6);
    }
}
