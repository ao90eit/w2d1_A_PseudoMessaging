package com.aoinc.w2d1_a_pseudomessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String P1_SENDS = "P1_SENDS";

    private SharedPreferences prefs;

    private EditText message_edittext;
    private TextView message_textview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        message_edittext = findViewById(R.id.message_edittext1);
        message_textview = findViewById(R.id.messageRecieved_textview1);

        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString(P1_SENDS, message_edittext.getText()
                        .toString()).apply();
                message_edittext.setText("");
                startActivity(new Intent(MainActivity.this, Person2Activity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        message_textview.setText(prefs.getString(Person2Activity.P2_SENDS, ""));
    }
}