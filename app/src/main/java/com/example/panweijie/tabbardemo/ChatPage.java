package com.example.panweijie.tabbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ChatPage extends AppCompatActivity {
    private int  onClickNum;
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
        Intent intent = getIntent();
//         Log.d("intent",":"+intent.getStringExtra("extra"));
        Log.d("INTENT",":"+intent.getIntExtra(DefineString.BOUNTKEY_CHAT,0));
        onClickNum = intent.getIntExtra(DefineString.BOUNTKEY_CHAT,0);
        textView = (TextView) findViewById(R.id.chatPage);
        textView.setText(""+onClickNum);
    }
}
