package com.drore.allinone;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ICalcAIDL mICalcAIDL;
    private ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mICalcAIDL = ICalcAIDL.Stub.asInterface(service);
            Toast.makeText(MainActivity.this, "绑定成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mICalcAIDL = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        startService(new Intent(MainActivity.this,CalcService.class));
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.chris.aild.calc");
                intent.setPackage(getPackageName());
//                ComponentName componentName = new ComponentName(
//                        "com.drore.allinone","com.drore.allinone.CalcService");
//                intent.setComponent(componentName);
                bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    add_ipc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    min_ipc();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mServiceConn);
                Toast.makeText(MainActivity.this, "解绑", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void add_ipc() throws Exception
    {
        if (mICalcAIDL != null)
        {
            int addRes = mICalcAIDL.add(12, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
        }
    }
    public void min_ipc() throws RemoteException {
        if(mICalcAIDL !=null){
            int minRes = mICalcAIDL.min(12,4);
            Toast.makeText(this, minRes + "", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "服务端未绑定或被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }
    }
}
