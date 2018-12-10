package com.example.myone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Admin extends AppCompatActivity {

    private Button butn,butn2;
    private TextView tiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        butn=(Button)findViewById(R.id.button4);

        //以下注释是自动退出时间自己设定
        //就如打开程序时出现的页面
       /* Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                   show();
            }
        };
        timer.schedule(timerTask,3000);*/
       show();
      /*  butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Admin.this.finish();
            }
        });
        //以下代码是延时操作
        try {
            Thread.currentThread().sleep(3000);//阻断2秒
            show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
      tiao();
    }

    public void show(){
        new AlertDialog.Builder(this)

                .setTitle("系统提示")

                .setMessage("您正在使用后台管理，请谨慎操作")

                .setPositiveButton("确定",null)

                .show();
    }
    //跳转添加备忘录页面
    public void tiao(){
        butn2=(Button)findViewById(R.id.button5);
        butn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin.this,AddBeiwang.class);
                startActivity(intent);
            }
        });
    }
    //获取备忘录信息并显示
    public void showbei(){
        Intent intent=getIntent();
        String bei=intent.getBooleanArrayExtra("beiwang").toString();
        tiv.setText(bei);
    }
}
