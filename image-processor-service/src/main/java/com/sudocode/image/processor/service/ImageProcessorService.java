package com.sudocode.image.processor.service;

import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ace on 3/5/16.
 */
public interface ImageProcessorService {

    /**
     * @param mFile
     * @return Bundle
     */
    Bundle processImage(File mFile) throws IOException;

    /**
     *
     *
     * */
    void loadImageProc();
}
