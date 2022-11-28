package com.example.fristdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "HelloWorldActivity";   //logt
    private Button btn_toast,btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        Log.d(TAG, "onCreate: ");

        btn_toast = findViewById(R.id.btn_toast);
        btn_second = findViewById(R.id.btn_second);
        btn_toast.setOnClickListener(this);
        btn_second.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:
                showToast("This is Toast`s button");
                finish();  //销毁当前活动
                break;
            case R.id.btn_second:
                //显示启动
                //showStart(SecondActivity.class);
                //隐式启动
                //implicitStart();
                //隐式启动2
                implicitStart2();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //重新定义菜单文件
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //重写菜单中的功能
        switch (item.getItemId()){
            case R.id.add_item:
                showToast("Add item");
                break;
            case R.id.remove_item:
                showToast("Remove item");
                break;
            default:
                break;
        }
        return true;
    }

    private void showToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    //显示启动
    private void showStart(Class<?> cls) {
        Intent intent = new Intent(HelloWorldActivity.this,cls);
        startActivity(intent);
    }

    //隐式启动
    private void implicitStart() {
        Intent intent = new Intent("com.example.fristdemo.ACTION_START");
        intent.addCategory("com.example.fristdemo.MY_CATEGORY");
        startActivity(intent);
    }

    //隐式启动2
    private void implicitStart2() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://translate.google.com/"));
        startActivity(intent);
    }

}