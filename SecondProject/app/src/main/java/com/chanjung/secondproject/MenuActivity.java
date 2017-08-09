package com.chanjung.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MenuActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 아이디가 textView인 TextView에 1000ms당 conut를 1씩 증가시킨 후 textView의 내용을 업데이트 시킨다.
        final TextView textView = (TextView)findViewById(R.id.textView);

        Thread t = new Thread(){
          @Override
            public void run(){
              while(!isInterrupted()){
                  try {
                      Thread.sleep(1000);       // 1000ms = 1 second

                      runOnUiThread(new Runnable() {      //
                          @Override
                          public void run() {
                              count++;

                              textView.setText(String.valueOf(count));
                          }
                      });

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
        };
        t.start();
        // end
    }

    public void onBackButtonClicked(View v){
        Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀어요.", Toast.LENGTH_LONG).show();

        // MainActivity로 count값을 String으로 넘겨준다.
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        intent.putExtra("counter", String.valueOf(count));
        // end

        startActivity(intent);
    }
}
