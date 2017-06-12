package com.drore.ipcwithoutaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

/**
 * Email: suoyiman@163.coom
 */

public class CalcService extends Service {
    private static final String TAG = "server";
    private static final String DESCRIPTOR = "CalcPlusService";
    public void onCreate()
    {
        Toast.makeText(getApplicationContext(),"CalcService oncreate", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate");
    }

    public IBinder onBind(Intent t)
    {
        Log.e(TAG, "onBind");
        return mBinder;
    }

    public void onDestroy()
    {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent)
    {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent)
    {
        Log.e(TAG, "onRebind");
        super.onRebind(intent);
    }

    Binder mBinder = new Binder(){
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code)
            {
                case 0x110:
                {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = _arg0 + _arg1;
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 0x111:
                {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = _arg0 - _arg1;
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    };

}
