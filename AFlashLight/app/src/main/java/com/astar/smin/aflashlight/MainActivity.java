package com.astar.smin.aflashlight;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    public static Camera cam = null;// has to be static, otherwise onDestroy() destroys it
    private ImageButton light_switch;
    private boolean isFlashOn;
    private boolean hasFlash;
    Parameters p;
    static final String TAG="MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light_switch=(ImageButton)this.findViewById(R.id.btnSwitch);
           /*
            * First check if device is supporting flashlight or not
            */
        hasFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!hasFlash) {
            // device doesn't support flash
            // Show alert message and close the application
            AlertDialog alert = new AlertDialog.Builder(MainActivity.this)
                    .create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, your device doesn't support flash light!");
            alert.setButton(RESULT_OK, ALARM_SERVICE, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                }
            });
            alert.show();
            return;
        }


        light_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFlashOn) {
                    // turn off flash
                    flashLightOff();
                    //            light_switch.setText("Turn on");
                } else {
                    // turn on flash
                    //            light_switch.setText("Turn off");
                    flashLightOn();
                }
            }
        });


    }
    public void flashLightOn() {
        Log.v(TAG, "ON");
        try {
            getcamera();
            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
            cam.setParameters(p);
            cam.startPreview();
            isFlashOn=true;

            toggleButtonImage();
        } catch (Exception e) {
            e.printStackTrace();
//            Toast.makeText(getBaseContext(), "Exception flashLightOn()",Toast.LENGTH_SHORT).show();
        }
    }
    public void getcamera(){
        if (cam==null){
            try{
                Log.v(TAG, "CAMERA CONFIG");
                cam = Camera.open();
                p = cam.getParameters();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void flashLightOff() {
        Log.v(TAG, "OFF");
        if (cam!=null) try {
            cam.stopPreview();
            cam.release();
            cam = null;
            isFlashOn=false;

            toggleButtonImage();
        } catch (Exception e) {
            e.printStackTrace();
//            Toast.makeText(getBaseContext(), "Exception flashLightOff",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        getcamera();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(hasFlash)
            flashLightOn();
    }
    /*
    @Override
    protected void onPause() {
        super.onPause();
        // on pause turn off the flash
        flashLightOff();
    }
    */
    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(cam != null) {
            cam.release();
            cam = null;
        }
    }



    /*
     * Toggle switch button images
     * changing image states to on / off
     * */


    private void toggleButtonImage() {
        if (isFlashOn) {
            light_switch.setImageResource(R.drawable.btn_switch_on);
        } else {
            light_switch.setImageResource(R.drawable.btn_switch_off);
        }
    }


}//MainClass