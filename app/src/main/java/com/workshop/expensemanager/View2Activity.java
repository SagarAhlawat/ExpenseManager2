package com.workshop.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class View2Activity extends AppCompatActivity
{
ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        Intent box2=getIntent();
        lv1=(ListView)findViewById(R.id.listView1);
        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND,null);

        Cursor cursor=db.rawQuery("select * from Details",null);
        CursorAdapter MycursorAdapter=new MycursorAdapter(this,cursor,0);
        lv1.setAdapter(MycursorAdapter);
    }



    class MycursorAdapter extends CursorAdapter
    {

        public MycursorAdapter(Context context, Cursor c, int flags)
        {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent)
        {
            LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=inflator.inflate(R.layout.row,parent,false);
            return v;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor)
        {
            //TextView tvcid=(TextView)view.findViewById(R.id.textView7);
            TextView tvid=(TextView)view.findViewById(R.id.textView1);
            TextView tvfrom1=(TextView)view.findViewById(R.id.textView2);
            TextView tvto1=(TextView)view.findViewById(R.id.textView3);
            TextView tvstart1=(TextView)view.findViewById(R.id.textView4);
            TextView tvend1=(TextView)view.findViewById(R.id.textView5);
            TextView tvbudget=(TextView)view.findViewById(R.id.textView6);
            //int cid=cursor.getInt(cursor.getColumnIndex("_id"));

            String id=cursor.getString(cursor.getColumnIndex("id"));
            String from1=cursor.getString(cursor.getColumnIndex("from1"));
            String to1=cursor.getString(cursor.getColumnIndex("to1"));
            String start1=cursor.getString(cursor.getColumnIndex("start1"));
            String end1=cursor.getString(cursor.getColumnIndex("end1"));
            String budget=cursor.getString(cursor.getColumnIndex("budget"));
            //tvcid.setText("CUSTOMER ID:"+cid);
            tvid.setText("TRIP ID:"+id);
            tvfrom1.setText("FROM:"+from1);
            tvto1.setText("TO:"+to1);
            tvstart1.setText("DATE OF START:"+start1);
            tvend1.setText("END DATE:"+end1);
            tvbudget.setText("APPROVED BUDGET:"+budget);




        }
    }

}
