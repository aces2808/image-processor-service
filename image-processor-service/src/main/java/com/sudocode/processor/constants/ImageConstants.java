package com.sudocode.processor.constants;

import org.opencv.core.CvType;

/**
 * Created by ace on 3/20/16.
 */
public interface ImageConstants {

    String IMAGE_SRC = "image-source";

    String IMAGE_DEST = "image-dest";

    String IMAGE_DEPTH = "image-depth";

    int IMAGE_DEPTH_32 = CvType.CV_32F;

    int IMAGE_DEPTH_08 = CvType.CV_8U;

    int IMAGE_DEPTH_16 = CvType.CV_16U;
}
