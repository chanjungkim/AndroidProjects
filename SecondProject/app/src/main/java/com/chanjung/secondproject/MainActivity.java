package com.chanjung.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra("counter");
        TextView textView = (TextView)findViewById(R.id.textView3);
        textView.setText(message);
    }

    public void onStartButtonClicked(View v){
        // Toast.makeText(getApplicationContext(), "시작 버튼을 눌렀어요.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        startActivity(intent);
    }
}
