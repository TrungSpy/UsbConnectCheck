package vn.co.example.phanvantrung.usbconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Phan Van Trung on 2015/07/19.
 */
public class UsbConnnectReceiver  extends BroadcastReceiver {
    Context mContext;
    Intent mIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext =context;
        mIntent = intent;

        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            Log.d(UsbConnnectReceiver.class.getSimpleName(), "電源接続：ON");
            Toast.makeText(context,"電源接続：ON",Toast.LENGTH_LONG).show();
            addAdsBanner();
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())){
            Log.d(UsbConnnectReceiver.class.getSimpleName(), "電源接続：OFF");
            Toast.makeText(context, "電源接続：OFF", Toast.LENGTH_LONG).show();
            addAdsBanner();
        }
    }
    private  void addAdsBanner(){
       Intent intent = new Intent(mContext,AdsView.class);
        intent.putExtras(mIntent);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
