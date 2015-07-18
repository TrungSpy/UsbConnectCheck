package jp.co.phanvantrung.usbconnect;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class UsbConnectReceiver extends BroadcastReceiver  {

    public  void  onReceive (final Context context,Intent intent){
     if(Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
         showDialog(context,Intent.ACTION_POWER_CONNECTED);
     } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())){
         showDialog(context,Intent.ACTION_POWER_DISCONNECTED);
     }

    }
    private void showDialog (final Context mContext, final String isConnected) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle("電源接続");
        dialog.setIcon(R.drawable.abc_ic_clear_mtrl_alpha);
        dialog.setMessage("電源ケーブルが接続されました。。。。。");
        dialog.setNegativeButton("いいえ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(mContext, "電源接続：" + isConnected, Toast.LENGTH_LONG);
                Log.d(UsbConnectReceiver.class.getSimpleName(), "電源接続：" + isConnected);
            }
        });
        dialog.setPositiveButton("はい", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(mContext, "電源接続：" + isConnected, Toast.LENGTH_LONG);
                Log.d(UsbConnectReceiver.class.getSimpleName(),"電源接続："+isConnected);
            }
        });
        dialog.show();
    }

}
