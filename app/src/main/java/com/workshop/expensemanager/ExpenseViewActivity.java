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
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ExpenseViewActivity extends AppCompatActivity
{ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_view);
        Intent b5=getIntent();
        lv1=(ListView)findViewById(R.id.Listview1);
        SQLiteDatabase db=openOrCreateDatabase("ALPHA_DB", Context.MODE_APPEND,null);
        Cursor cursor=db.rawQuery("select * from Expenses",null);
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
            View v=inflator.inflate(R.layout.column,parent,false);
            return v;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor)
        {
            TextView tvcategory=(TextView)view.findViewById(R.id.textView1);
            TextView tvamount=(TextView)view.findViewById(R.id.textView2);
            TextView tvdate2=(TextView)view.findViewById(R.id.textView3);
            TextView tvtid=(TextView)view.findViewById(R.id.textView4);
           // int cid=cursor.getInt(cursor.getColumnIndex("_id"));
            String category =cursor.getString(cursor.getColumnIndex("category"));
            String amount=cursor.getString(cursor.getColumnIndex("amount"));
            String date2 =cursor.getString(cursor.getColumnIndex("date2"));
            String tid=cursor.getString(cursor.getColumnIndex("tid"));
            tvcategory.setText("CATEGORY:"+category);
            tvamount.setText("AMOUNT:"+amount);
            tvdate2.setText("DATE:"+date2);
            tvtid.setText("TRIP ID:"+tid);


        }
    }

}
