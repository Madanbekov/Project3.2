package com.example.project32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {
    private TextInputEditText email,title,sms;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.username);
        title = findViewById(R.id.title);
        sms = findViewById(R.id.text);
        btn = findViewById(R.id.btn_send);
        setEmail();
    }
    private void setEmail() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, sms.getText());
                startActivity(intent);
            }
        });
    }}