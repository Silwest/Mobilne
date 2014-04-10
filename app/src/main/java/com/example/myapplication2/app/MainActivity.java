package com.example.myapplication2.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    // LAB01
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button lab01_button = (Button)findViewById(R.id.button_lab01);
        lab01_button.setOnClickListener(this);
        Button lab02_button = (Button)findViewById(R.id.button_lab02);
        lab02_button.setOnClickListener(this);
        Button button_exit = (Button)findViewById(R.id.button_exit);
        button_exit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.button_lab01:
                intent = new Intent(this, lab01.Main.class);
                startActivity(intent);
                break;
            case R.id.button_exit:
                finish();
                break;
            case R.id.button_lab02:
                intent = new Intent(this, lab02.database.AddTask.class);
                startActivity(intent);
                break;
        }
    }
}
