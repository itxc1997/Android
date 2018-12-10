package com.example.myone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    private EditText editText1, editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            test2();

    }
    public void test2() {
        btn=(Button) findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText1.getText().toString();
                String input2=editText2.getText().toString();
                if(input.equals("admin") && input2.equals("admin")){
                    Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                    intent.putExtra("username",input);
                    intent.putExtra("password",input2);
                    textView.setText("");
                    startActivity(intent);
                }else if(input.equals("nini")&&input2.equals("nini")){
                    Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                    intent.putExtra("username",input);
                    intent.putExtra("password",input2);
                    textView.setText("");
                    startActivity(intent);
                }else{
                    AlertDialogs();
                    textView.setText("登录失败,用户名或密码错误！");
                    editText2.setText("");
                }
            }
        });

    }
    //用于提示登录失败时弹出提示框不能直接写在上面的方法里
    public void AlertDialogs(){
        new  AlertDialog.Builder(this)

                .setTitle("系统提示" )//设置标题

                .setMessage("登录失败,用户名或密码错误！" )//设置提示信息

                .setPositiveButton("确定" ,  null )//设置button按钮显示的值

                .show();
    }
}

