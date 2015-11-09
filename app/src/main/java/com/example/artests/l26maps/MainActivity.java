package com.example.artests.l26maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void onClick(View view) {
        String geoUriString;
        if (!((CheckBox)(findViewById(R.id.checkBoxView))).isChecked()) {
            if (((EditText) findViewById(R.id.addressText)).getText() != null) {
                geoUriString = "geo:0,0?q=" + ((EditText) findViewById(R.id.addressText)).getText();
                if (((EditText) findViewById(R.id.scaleText)) != null) {
                    geoUriString += "&z=" + ((EditText) findViewById(R.id.scaleText));
                }
            } else {
                geoUriString = "geo:" + ((EditText) findViewById(R.id.latitudeText)).getText() +
                        "," + ((EditText) findViewById(R.id.longitudeText)).getText() + "?z=" +
                        ((EditText) findViewById(R.id.scaleText)).getText();
            }
        }
        else{
            geoUriString = "google.streetview:cbll=" + ((EditText) findViewById(R.id.latitudeText)).getText() +
                    "," + ((EditText) findViewById(R.id.longitudeText)).getText() +
                    "&cbp=1,99.56,,1,2.0&mz="+
                    ((EditText) findViewById(R.id.scaleText)).getText();
        }
        Toast.makeText(this, geoUriString, Toast.LENGTH_LONG).show();
        Intent geoIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString));
        startActivity(geoIntent);
    }
}
