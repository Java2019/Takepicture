package com.samples.camera.takepicture;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.PictureCallback;

public class CameraPreviewActivity extends AppCompatActivity
        implements View.OnClickListener, SurfaceHolder.Callback{

    private Camera camera;
    private SurfaceView surView;
    private ImageButton bStart;
    private ImageButton bStop;
    private ImageButton bTake;
    private SurfaceHolder holder;
    private boolean isCameraPreview = false;

    private ShutterCallback shutter = new ShutterCallback(){
        @Override
        public void onShutter() { }
    };
    private Camera.PictureCallback raw = new PictureCallback(){
        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) { }
    };
    private PictureCallback jpg = new PictureCallback(){
        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) {
            Bitmap bitmapPicture
                    = BitmapFactory.decodeByteArray(arg0, 0, arg0.length);
            camera.stopPreview();
            camera.release();
            isCameraPreview = false;
            bStart.setEnabled(!isCameraPreview);
            bStop.setEnabled(isCameraPreview);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        surView = (SurfaceView)findViewById(R.id.surView);
        bStart = (ImageButton)findViewById(R.id.bStart);
        bStop = (ImageButton)findViewById(R.id.bStop);
        bTake = (ImageButton)findViewById(R.id.bTake);

        holder = Camera.Cal
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bStart:
                try {
                    camera = Camera.open();
                    camera.setPreviewDisplay(holder);

                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bStop:

                break;
            case R.id.bTake:

                break;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
