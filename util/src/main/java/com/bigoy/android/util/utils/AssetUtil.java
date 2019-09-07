package com.bigoy.android.util.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings({"WeakerAccess", "unused"})
public class AssetUtil {

    @SuppressWarnings("SpellCheckingInspection")
    public static String readStringFromAsset(Context context, String fileName) {
        if (null == context) {
            return null;
        }

        try {
            InputStream is = readInputStreamFromAsset(context, fileName);

            if (is != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int length;
                byte[] buffer = new byte[1024];

                while ((length = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }

                is.close();
                baos.close();

                return baos.toString();
            }
        } catch (IOException e) {
            return null;
        }

        return null;
    }

    public static InputStream readInputStreamFromAsset(Context context, String fileName) {
        InputStream is = null;
        if (null == context) {
            return null;
        }

        AssetManager am = context.getAssets();

        if (am != null) {
            try {
                is = am.open(fileName);
            } catch (IOException e) {
                return null;
            }
        }

        return is;
    }
}
