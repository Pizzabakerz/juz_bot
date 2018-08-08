package com.pizzabakerz.juzbot;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ConnectivityManager check = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (check.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                check.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_logo_launcher);
            Logolaunch logolaunch = new Logolaunch();
            logolaunch.start();
        } else {
            Toast.makeText(this, "Turn your internetconnection", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            //setting title
            alert.setTitle("NO INTERNET FOUND");
            //setting message bode
            alert.setMessage("Turn on wifi or mobile data");
            //making non cancelable
            alert.setCancelable(false);

            //making wifi button
            alert.setPositiveButton("wifi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(LogoLauncher.this, "opening wifi settings", Toast.LENGTH_SHORT).show();
                    startActivityForResult(new Intent(Settings.ACTION_WIFI_SETTINGS), 0);
                    finish();
                }
            });
            //making mobile data button
            alert.setNegativeButton("mobile data", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(LogoLauncher.this, "opening mobile data settings", Toast.LENGTH_SHORT).show();
                    startActivityForResult(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS), 0);
                    finish();
                }
            });
            //to show alert
            alert.create().show();
        }
    }

    private class Logolaunch extends Thread {
        public void run(){
            try {
                sleep(2500);
                Intent intent = new Intent(LogoLauncher.this,Login.class);
                startActivity(intent);
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
