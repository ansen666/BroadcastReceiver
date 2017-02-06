package com.ansen.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String ACTION_DYNAMIC_BROADCAST="android.intent.action.DYNAMIC_BROADCAST";

    private DynamicBroadcast dynamicBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_dynamic_broadcast_send_message).setOnClickListener(this);
        findViewById(R.id.btn_static_broadcast_send_message).setOnClickListener(this);

        //动态注册广播
        dynamicBroadcast=new DynamicBroadcast();
        IntentFilter intentFilter=new IntentFilter(ACTION_DYNAMIC_BROADCAST);
        registerReceiver(dynamicBroadcast,intentFilter);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_dynamic_broadcast_send_message:
                Intent intent = new Intent(ACTION_DYNAMIC_BROADCAST);
                intent.putExtra("data","Dynamic Broadcast Parameter");//通过intent传参
                sendBroadcast(intent);//发送广播消息
                break;
            case R.id.btn_static_broadcast_send_message:
                Intent staticIntent = new Intent("android.intent.action.STATIC_BROADCAST");
                staticIntent.putExtra("data","Static Broadcast Parameter");//通过intent传参
                sendBroadcast(staticIntent);//发送广播消息
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("MainActivity onDestroy","销毁广播");
        unregisterReceiver(dynamicBroadcast);
    }
}
