package com.miao.administrator.dbtest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnRead, btnWrite;
    private EditText etDate, etID;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        etDate = (EditText) findViewById(R.id.etDate);
        etID = (EditText) findViewById(R.id.etID);
        tvShow = (TextView) findViewById(R.id.tvShow);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.insertDT(etDate.getText().toString(), etID.getText().toString());
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strQuery = "select * from " + DBHelper.DATE_TITLEID;
                Cursor cursor = DBHelper.rawQuery(strQuery);
                String strShow = "";
                while (cursor.moveToNext()) {
                    strShow = strShow + cursor.getString(0) + ":" + cursor.getString(1) + "\n";
                    Log.e(cursor.getString(0), cursor.getString(1));
                }
                tvShow.setText(strShow);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
