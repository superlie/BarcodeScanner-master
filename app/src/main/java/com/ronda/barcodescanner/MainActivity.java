package com.ronda.barcodescanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private BarcodeScannerResolver mBarcodeScannerResolver;
    private EditText barcodeEdit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeEdit = (EditText)findViewById(R.id.UserName);
    }



    /**
     * 点击开始扫码监听按钮
     *
     * @param view
     */
    public void startScanListen(View view) {
        mBarcodeScannerResolver = new BarcodeScannerResolver();
        mBarcodeScannerResolver.setScanSuccessListener(new BarcodeScannerResolver.OnScanSuccessListener() {
            @Override
            public void onScanSuccess(String barcode) {
                Log.w(TAG, "barcode: " + barcode);
                if(barcode.length()>0){
                    //String result = barcode.substring(0,barcode.length()-1)+"%";

                    barcodeEdit.setText(barcode);
                    Toast.makeText(MainActivity.this, "barcode: " + barcode, Toast.LENGTH_SHORT).show();
                }

            }

        });
    }


    /**
     * 点击移除扫码监听按钮
     *
     * @param view
     */
    public void removeScanListen(View view) {
        mBarcodeScannerResolver.removeScanSuccessListener();
        mBarcodeScannerResolver = null;
    }


    /**
     * 扫码枪是输入设备，检测是否有外接输入设备.(这样判断其实并不严格)
     *
     * @return
     */
    private boolean hasLineScanGun() {
        Log.i(TAG, "hasScanGun");
        Configuration cfg = getResources().getConfiguration();

        return cfg.keyboard != Configuration.KEYBOARD_NOKEYS;
        //return true;
    }

    private boolean hasScanGun() {
        //Configuration cfg = getResources().getConfiguration();
        //return cfg.keyboard != Configuration.KEYBOARD_NOKEYS;
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> blueDevices = btAdapter.getBondedDevices();

        if (blueDevices == null || blueDevices.size() <= 0) {
            return false;
        }

        for (Iterator<BluetoothDevice> iterator = blueDevices.iterator(); iterator.hasNext(); ) {
            BluetoothDevice bluetoothDevice = iterator.next();

            if (bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.PERIPHERAL) {
                return isInputDeviceUsed(bluetoothDevice.getName());
            }

        }

        return false;
    }

    private boolean isInputDeviceUsed(String deviceName) {

        int[] deviceIds = InputDevice.getDeviceIds();

        for (int id : deviceIds) {
            if (InputDevice.getDevice(id).getName().equals(deviceName)) {
                return true;
            }
        }

        return false;

    }


//

    /**
     * Activity截获按键事件.发给 BarcodeScannerResolver
     * dispatchKeyEvent() 和 onKeyDown() 方法均可
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
       Log.i(TAG, "dispatchKeyEvent");
       /*当前解决方案获取设备名称不等于-1的即为外界键盘输入，但是必须特殊处理鼠标的右键返回，-1代表系统虚拟键盘
       * 在这种解决方案下不区分外接设备的种类，默认为扫码枪输入，所以不能接实体键盘
       * */
        int keyCode = event.getKeyCode();
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if(keyCode==KeyEvent.KEYCODE_BACK){
                finish();
                return true;

            }
        }
        int DeviceId = event.getDeviceId();
        Toast.makeText(MainActivity.this, "DeviceId: " + DeviceId, Toast.LENGTH_SHORT).show();
        if ( DeviceId== -1) {
            return super.dispatchKeyEvent(event);
        }else{
            mBarcodeScannerResolver.resolveKeyEvent(event);
            return true;
        }/*
        if (hasLineScanGun()||hasScanGun()) {
            mBarcodeScannerResolver.resolveKeyEvent(event);
            return true;
        }else if(DeviceId == 1){
            return super.dispatchKeyEvent(event);
        }else if(DeviceId == 5){
            return super.dispatchKeyEvent(event);
        }
        return super.dispatchKeyEvent(event);*/
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (mBarcodeScannerResolver != null) {
//            mBarcodeScannerResolver.resolveKeyEvent(event);
//        }

        return super.onKeyDown(keyCode, event);
    }
}
