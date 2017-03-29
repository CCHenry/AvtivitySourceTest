package com.example.henryzheng.avtivitysourcetest.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.util.List;

public class CustomCameraActivity extends AppCompatActivity {
    private Camera mCamera;
    private PreView mPreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPreView=new PreView(this);
        setContentView(mPreView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCamera = Camera.open();
        mPreView.setCamera(mCamera);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
            mPreView.setCamera(null);

        }
    }


    class PreView extends ViewGroup implements SurfaceHolder.Callback {
        SurfaceView mSurfaceView;
        SurfaceHolder mHolder;
        Camera.Size mPreviewSize;
        List<Camera.Size> mSupportPreviewSizes;
        Camera mCamera;
        Context mContext;

        public PreView(Context context) {
            super(context, null);

        }

        public PreView(Context context, AttributeSet attrs) {
            super(context, attrs, 0);
        }

        public PreView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            mContext = context;
            mSurfaceView = new SurfaceView(context);
            addView(mSurfaceView);
            mHolder =mSurfaceView.getHolder();
            mHolder.addCallback(this);
        }

        private void setCamera(Camera camera){
            mCamera=camera;
            if (mCamera!=null){
                mSupportPreviewSizes=mCamera.getParameters().getSupportedPictureSizes();
                requestLayout();
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
                if (mCamera!=null)
                {
                    try {
                        mCamera.setPreviewDisplay(holder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Camera.Parameters parameters=mCamera.getParameters();
            parameters.setPreviewSize(mPreviewSize.width,mPreviewSize.height);
            mCamera.setParameters(parameters);
            mCamera.startPreview();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
                if (mCamera!=null){
                    mCamera.stopPreview();
                }
        }

        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            if (changed&&getChildCount()>0){
                final View child=getChildAt(0);
                int width=r-l;
                int height=b-t;
                int preViewWidth=width;
                int preViewHeight=height;
                if (mPreviewSize!=null){
                    preViewWidth=mPreviewSize.width;
                    preViewHeight=mPreviewSize.height;
                }
                //实际手机屏幕的宽高比大于采集的宽高比
                if (width*preViewHeight>height*preViewHeight){
                    final int scaledChildWidth=preViewWidth*height/preViewHeight;
                    child.layout((width-scaledChildWidth)/2,0,(width+scaledChildWidth)/2,height);
                }else
                {
                    final int scaledChildHeight=preViewHeight*width/preViewWidth;
                    child.layout(0,(height-scaledChildHeight)/2,width,(height+scaledChildHeight)/2);
                }

            }
        }
        private Camera.Size getOptimalPreViewSize(List<Camera.Size> sizes,int w,int h){
            double ASPECT_TOLERANCE=0.1;
            double targetRatio=(double)w/h;
            if (sizes==null)
            {
                return null;
            }
            Camera.Size optimalSize=null;
            double minDiff=Double.MAX_VALUE;
            int targetHeight=h;
            for (Camera.Size size:sizes){
                double ratio=size.width/size.height;
                if (Math.abs(ratio-targetRatio)>ASPECT_TOLERANCE){
                    continue;
                }
                if (Math.abs(size.height-targetHeight)<minDiff){
                    optimalSize=size;
                    minDiff=Math.abs(size.height-size.width);
                }
            }
            if (optimalSize==null){
                minDiff=Double.MAX_VALUE;
                for (Camera.Size size:sizes){
                    double ratio=size.width/size.height;
                    if (Math.abs(size.height-targetHeight)<minDiff){
                        optimalSize=size;
                        minDiff=Math.abs(size.height-size.width);
                    }
                }
            }
            return  optimalSize;
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int w=resolveSize(getSuggestedMinimumWidth(),widthMeasureSpec);
            int h=resolveSize(getSuggestedMinimumHeight(),heightMeasureSpec);
            setMeasuredDimension(w,h);
            if (mSupportPreviewSizes!=null){
                mPreviewSize=getOptimalPreViewSize(mSupportPreviewSizes,w,h);
            }
        }
    }

}
