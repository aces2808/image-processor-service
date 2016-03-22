package com.sudocode.processor.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by ace on 2/9/16.
 */
public final class Logger {


    private String TAG = Logger.class.getSimpleName();

    public static boolean DEBUGGABLE = true;

    private boolean debuggable = true;

    /**
     * Creates new instance of logging.
     *
     * @param classType Class {@inheritDoc}
     */
    public <T> Logger(final Class<T> classType) {
        this(classType.getSimpleName());
    }

    /**
     * Creates new instance of TAG, uses default TAG if empty.
     */
    private Logger(final String TAG) {
        if (!TextUtils.isEmpty(TAG) && TAG.length() > 0) {
            this.TAG = TAG;
        }
    }

    /**
     * Synchronized central logging facility
     *
     * @param classType Class {@inheritDoc}
     * @return New instance of the logger.
     */
    public static synchronized <T> Logger getLogger(Class<T> classType) {
        return new Logger(classType);
    }

    /**
     * Prints debug-level logs
     *
     * @param message Describes the debug message
     */
    public void debug(final String message) {
        Log.d(TAG, message);
    }

    /**
     * Prints debug-level logs
     *
     * @param TAG     Uses specified TAG otherwise default class
     * @param message Describes the debug message
     */
    public void debug(final String TAG, String message) {
        if (this.debuggable && DEBUGGABLE) {
            if (!TextUtils.isEmpty(TAG)) {
                Log.d(TAG, message);
            } else {
                debug(message);
            }
        }
    }

    /**
     * Prints info-level logs
     *
     * @param message Describes the info message
     */
    public void info(final String message) {
        Log.i(TAG, message);
    }

    /**
     * Prints info-level logs
     *
     * @param TAG     Uses specified TAG otherwise default class
     * @param message Describes the info message
     */
    public void info(final String TAG, String message) {
        if (this.debuggable && DEBUGGABLE) {
            if (!TextUtils.isEmpty(TAG)) {
                Log.i(TAG, message);
            } else {
                debug(message);
            }
        }
    }

    /**
     * Prints warning-level logs
     *
     * @param message Describes the warning message
     */
    public void warn(final String message) {
        Log.w(TAG, message);
    }

    /**
     * Prints warning-level logs
     *
     * @param TAG     Uses specified TAG otherwise default class
     * @param message Describes the warning message
     */
    public void warn(final String TAG, String message) {
        if (this.debuggable && DEBUGGABLE) {
            if (!TextUtils.isEmpty(TAG)) {
                Log.w(TAG, message);
            } else {
                warn(message);
            }
        }
    }

    /**
     * Prints verbose-level logs
     *
     * @param message Describes the verbose message
     */
    public void verbose(final String message) {
        Log.v(TAG, message);
    }

    /**
     * Prints verbose-level logs
     *
     * @param TAG     Uses specified TAG otherwise default class
     * @param message Describes the vrbose message
     */
    public void verbose(final String TAG, String message) {
        if (this.debuggable && DEBUGGABLE) {
            if (!TextUtils.isEmpty(TAG)) {
                Log.v(TAG, message);
            } else {
                debug(message);
            }
        }
    }

    /**
     * Prints error-level logs
     *
     * @param message Describes the error message
     * @param e       Throws error message.
     */
    public void error(final String message, final Throwable e) {
        Log.e(TAG, message, e);
    }

    /**
     * Prints error-level logs
     *
     * @param TAG     Uses specified TAG otherwise default class
     * @param message Describes the error message
     * @param e       Throws error message.
     */
    public void error(final String TAG, String message, Throwable e) {
        if (this.debuggable && DEBUGGABLE) {
            if (!TextUtils.isEmpty(TAG)) {
                Log.e(TAG, message, e);
            } else {
                error(message, e);
            }
        }
    }

    /**
     * Returns the current status of the logger, true if enable otherwise false.
     *
     * @return True if debuggable else false.
     */
    public boolean isDebuggable() {
        return debuggable;
    }

    /**
     * Sets the status for enabling printing of logs.
     *
     * @param debuggable {@link Boolean}
     */
    public void setDebuggable(boolean debuggable) {
        this.debuggable = debuggable;
    }
}
