package com.example.fanfanls.phone_dial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText et_number;
    private  Button  bt_dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_number = (EditText)this.findViewById(R.id.et_number);
        bt_dial = (Button)this.findViewById(R.id.dial);
        bt_dial.setOnClickListener(new MyListener());
    }
    public class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            String number =et_number.getText().toString().trim();
            if(TextUtils.isEmpty(number)) {
                Toast toast = Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                MainActivity.this.startActivity(intent);

        }
    }
}

