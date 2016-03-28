package com.sudocode.image.processor.service;

import android.os.Bundle;

import com.sudocode.processor.constants.ImageConstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ace on 3/5/16.
 */
public interface ImageProcessorService extends ImageConstants {

    /**
     * @param mBundle
     * @return Bundle
     */
    Bundle processImage(Bundle mBundle) throws IOException;


    /**
     * @param mBundle
     * @return File {@link File}
     */
    File findMatch(Bundle mBundle) throws IOException;
}
