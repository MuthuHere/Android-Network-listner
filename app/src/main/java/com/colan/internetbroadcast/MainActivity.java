package com.colan.internetbroadcast;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends BaseActivity {


    TextView tv_check_connection;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_check_connection = (TextView) findViewById(R.id.tv_check_connection);
        btnClick = (Button) findViewById(R.id.btnClick);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callSecond = new Intent(MainActivity.this, SecondClass.class);
                startActivity(callSecond);
            }
        });

    }

    @Override
    public void isNetConnected(boolean b) {
        Log.i("mmm main activity",""+b);
        Toast.makeText(this, ""+b, Toast.LENGTH_SHORT).show();
    }

}
