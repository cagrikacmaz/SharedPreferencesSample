package com.beykent.cagrikacmaz.SharedPreferencesExample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.beykent.cagrikacmaz.testshare.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        final Animation animation = new AlphaAnimation(1, 0); // Görünürlük Oranı
        animation.setDuration(500); // Zaman Aralığı / Yarım Saniye
        animation.setInterpolator(new LinearInterpolator()); //
        animation.setRepeatCount(Animation.INFINITE); // Animasyonu süresiz tekrarlama
        animation.setRepeatMode(Animation.REVERSE); // Bitirme değeri
        final Button btn = (Button) findViewById(R.id.btnRetr);
        btn.startAnimation(animation);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                view.clearAnimation();
                if (sharedpreferences.contains(Name)) {
                    name.setText(sharedpreferences.getString(Name, ""));
                }
                if (sharedpreferences.contains(Email)) {
                    email.setText(sharedpreferences.getString(Email, ""));

                }
            }
        });


    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");

    }

    public void Get(View view) {
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }



}
