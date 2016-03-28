package com.sudocode.processor.service.impl;

import android.os.Bundle;

import com.sudocode.image.processor.service.ImageProcessorService;
import com.sudocode.processor.utils.Logger;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;

;

/**
 * Created by ace on 3/5/16.
 */
public class ImageProcessorImpl implements ImageProcessorService {

    private static final Logger logger = Logger.getLogger(ImageProcessorImpl.class);
    private Mat mSource;
    private Mat mDest;
    private static ImageProcessorService instance;

    public static ImageProcessorService getInstance() {
        return instance;
    }

    public ImageProcessorImpl() {
        if (!OpenCVLoader.initDebug()) {
            logger.debug("image-processor : cannot load processor");
        } else {
            logger.debug("image-processor : loaded processor");
        }
    }

    public static void init() {
        if (instance == null) {
            instance = new ImageProcessorImpl();
        }
    }

    @Override
    public Bundle processImage(Bundle mBundle) throws IOException {

        Bundle mUpdatedBundle = new Bundle();

        File mFile = (File) mBundle.getSerializable(IMAGE_SRC);
        int mDepth = mBundle.getInt(IMAGE_DEPTH, IMAGE_DEPTH_08);

        mSource = Imgcodecs.imread(mFile.getAbsolutePath(), Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        mDest = new Mat(mSource.rows(), mSource.cols(), mSource.type());

        Imgproc.Sobel(mSource, mDest, mDepth, 1, 1);
        Core.convertScaleAbs(mDest, mDest, 10, 0);
        Imgproc.cvtColor(mDest, mDest, Imgproc.COLOR_GRAY2BGRA, 4);
        Imgcodecs.imwrite(mFile.getAbsolutePath(), mDest);

        mUpdatedBundle.putSerializable(IMAGE_DEST, mFile);

        return mUpdatedBundle;
    }

    @Override
    public File findMatch(Bundle mBundle) throws IOException {

        return null;
    }

}
