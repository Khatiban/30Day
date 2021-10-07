package com.android.fury.a30day;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.fury.a30day.page.Page_2;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by fury on 1/15/2017.
 */
public class Not_net extends Activity {

    int sport_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.not_net);

        Bundle back = getIntent().getExtras();
        sport_page = back.getInt("d_m_b");

        Button again = (Button) findViewById(R.id.btn_not_net);
        ImageView btn_menu_5 = (ImageView) findViewById(R.id.btn_menu_5);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (app_net.getInstance(Not_net.this).isOnline()) {

                    Intent music = new Intent(Not_net.this, com.android.fury.a30day.menu_view.music.class);
                    music.putExtra("d_m_b", sport_page);
                    Not_net.this.startActivity(music);
                    finish();

                } else {

                    Toast.makeText(Not_net.this, "ERR INTERNET DISCONNECTED", Toast.LENGTH_LONG).show();

                }

            }
        });

        btn_menu_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (sport_page == 1) {

                    finish();

                } else if (sport_page == 2) {

                    Intent back_p = new Intent(Not_net.this, Page_2.class);
                    Not_net.this.startActivity(back_p);

                    finish();

                }


            }
        });
        FirebaseCrash.log("log 1");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(Not_net.this, getResources().getText(R.string.about_alertdialog_8), Toast.LENGTH_LONG).show();
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (sport_page == 1) {

                finish();

            } else if (sport_page == 2) {

                Intent back_p = new Intent(Not_net.this, Page_2.class);
                Not_net.this.startActivity(back_p);

                finish();

            }

            FirebaseCrash.log("log 2");
        }
        return false;
    }

}
