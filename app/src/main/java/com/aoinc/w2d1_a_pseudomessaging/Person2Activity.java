package com.aoinc.w2d1_a_pseudomessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Person2Activity extends AppCompatActivity {

    public static final String P2_SENDS = "P2_SENDS";

    private SharedPreferences prefs;

    private EditText message_edittext;
    private TextView message_textview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person2);

        prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        message_edittext = findViewById(R.id.message_edittext2);
        message_textview = findViewById(R.id.messageRecieved_textview2);
        message_textview.setText(prefs.getString(MainActivity.P1_SENDS, ""));

        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString(P2_SENDS, message_edittext.getText()
                        .toString()).apply();
                finish();
            }
        });
    }
}