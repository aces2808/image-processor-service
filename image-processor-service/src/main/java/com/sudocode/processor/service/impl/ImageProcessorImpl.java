package com.sudocode.processor.service.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;;

import com.sudocode.image.processor.service.ImageProcessorService;
import com.sudocode.processor.utils.Logger;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;

/**
 * Created by ace on 3/5/16.
 */
public class ImageProcessorImpl implements ImageProcessorService {

    private static final Logger logger = Logger.getLogger(ImageProcessorImpl.class);
    private CvCameraViewFrame inputFrame;
    private Mat gradx,grady,absgradx,absgrady;
    private Mat mSource;
    //private Mat mDest;
    private Bitmap mBitmap;
    private static ImageProcessorService instance;

    public static ImageProcessorService getInstance() {
        return instance;
    }

   public ImageProcessorImpl() {
        if (!OpenCVLoader.initDebug()) {
        } else {
        }
   }

    public static void init() {
        if (instance == null) {
            instance = new ImageProcessorImpl();
        }
    }

    @Override
    public Bundle processImage(File mFile) throws IOException {

        InputStream mInputStream = new FileInputStream(mFile);
        mBitmap = BitmapFactory.decodeStream(mInputStream);

        mBitmap = Bitmap.createScaledBitmap(mBitmap, 100, 100, true);
        mSource = new Mat();

        Utils.bitmapToMat(mBitmap, mSource);

        Imgproc.cvtColor(mSource, mSource, Imgproc.COLOR_RGBA2GRAY);
        mSource.convertTo(mSource, CvType.CV_32F);
        Core.transpose(mSource, mSource);
        Core.flip(mSource, mSource, 1);

        logger.debug("image-processor : get path : " + mFile.getCanonicalPath());

        Imgcodecs.imwrite(mFile.getAbsolutePath(), mSource);

        //InputStream mInputStream2 = new FileInputStream(ResourcesCompat.getDrawable(R.drawable.fungal));


        //Bitmap mBitmap2 = BitmapFactory.decodeResource(Resources.getSystem().getDrawable())

        // Get file reference
        // Follow codes above and add logic to check if file is already processed.
        // Compare 2 image

//        InputStream mInputStream2 = new FileInputStream(new File(<file location>));
//        mBitmap2 = BitmapFactory.decodeStream(mInputStream);
//
//        mBitmap2 = Bitmap.createScaledBitmap(mBitmap2, 100, 100, true);
//        mSource2 = new Mat();
//
//        Utils.bitmapToMat(mBitmap2, mSource2);
//
//        Imgproc.cvtColor(mSource2, mSource2, Imgproc.COLOR_RGBA2GRAY);
//        mSource.convertTo(mSource, CvType.CV_32F);

        return null;
    }

    @Override
    public void loadImageProc() {
        if (!OpenCVLoader.initDebug()) {
            logger.debug("image-processor : cannot load OpenCV");
        } else {
            logger.debug("image-processor : loaded OpenCV");
        }
    }
}
