package com.example.myone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView textView,textView2;
    private Switch sw;
    private Button btn;
    private ImageSpan span;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        test();
        tiaozhuan();
    }

    public void test() {
               textView=(TextView) findViewById(R.id.textView11);
               Intent intent=getIntent();
               String username = intent.getStringExtra("username");
               textView.setText("登录成功"+username+"欢迎使用本程序！");

               btn=(Button)findViewById(R.id.button11);
               btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       tuichutishi();
                   }
               });
               sw=(Switch)findViewById(R.id.switch1);
               //如果是普通用户就隐藏switch控件，但是不行，以后解决
               /* if(intent.equals("nini")){
                    sw.setVisibility(sw.INVISIBLE);
                }*/
               textView2=(TextView)findViewById(R.id.textView2);
               textView2.setVisibility(View.INVISIBLE);
               sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                       if (isChecked){
                           textView2.setVisibility(View.VISIBLE);
                          // textView2.
                       }else {
                           textView2.setVisibility(View.INVISIBLE);
                       }
                   }
               });
    }
    //提示框
    public void tuichutishi(){
        new AlertDialog.Builder(this)
                .setTitle("系统提示")

                .setMessage("你确定要退出吗？")

                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Main3Activity.this.finish();
                    }
                })

                .setNegativeButton("取消",null)

                .show();
    }
    //点击登录管理界面提示
    public void showguanli(){
        new AlertDialog.Builder(this)

                .setTitle("系统提示")

                .setMessage("你将进入管理员界面是否继续？")

                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //跳转页面（直接在后面写参数）
                        Intent intent=new Intent(Main3Activity.this,Admin.class);
                        startActivity(intent);
                    }
                })

                .setNegativeButton("取消",null)

                .show();
    }
    //点击Textivew跳转页面
    public void tiaozhuan(){

        textView2=(TextView)findViewById(R.id.textView2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showguanli();
            }
        });

    }
}
