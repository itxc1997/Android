package com.example.myone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddBeiwang extends AppCompatActivity {
    private TextView tev;
    private Button butn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beiwang);
        huoqu();
    }
    //获取数据
    public void huoqu(){
        butn=(Button)findViewById(R.id.button6);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bei=tev.getText().toString();
                Intent intent=new Intent(AddBeiwang.this,Admin.class);
                intent.putExtra("berwang",bei);
                startActivity(intent);
            }
        });

    }
}
