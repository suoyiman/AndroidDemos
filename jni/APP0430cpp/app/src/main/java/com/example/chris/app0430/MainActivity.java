package com.example.chris.app0430;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //	AlertDialog dialog;
    ProgressDialog dialog;

    static{
        System.loadLibrary("native-lib");
    }

    EditText et_username;
    EditText et_password;
    EditText et_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_money = (EditText) findViewById(R.id.et_money);
    }

    public void showDialog(final String msg){
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
				/*
				AlertDialog.Builder builder = new Builder(MainActivity.this);
				builder.setTitle("提醒");
				builder.setMessage(msg);
				 */

                dialog = new ProgressDialog(MainActivity.this);
                dialog.setTitle("提醒");
                dialog.setMessage(msg);
                dialog.show();
            }
        });
    }

    public void dismissDialog(){
        dialog.dismiss();
    }

    /**
     * 本地安全支付
     *
     * @param username
     * @param password
     * @param money
     *
     *            return 200支付成功;404用户名或密码错误;403余额不足
     *
     */
    public native int safePay(String username, String password, float money);

    public void pay(View view) {

        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        String str_money = et_money.getText().toString().trim();
        final float money = Float.parseFloat(str_money);

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(str_money)) {
            Toast.makeText(this, "帐号密码或金额不能为空", Toast.LENGTH_SHORT).show();
        }

        new Thread(){
            public void run() {
                int result = safePay(username, password, money);
                switch (result) {
                    case 200:
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                Toast.makeText(MainActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;
                    case 403:
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                Toast.makeText(MainActivity.this, "支付失败，余额不足", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 404:
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                Toast.makeText(MainActivity.this, "支付失败，用户名或者密码错误", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    default:
                        break;
                }
            };
        }.start();


    }
}
