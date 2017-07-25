package info.arimateia.overwatchpocket.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import info.arimateia.overwatchpocket.vo.Photo;

/**
 * Created by felipets on 7/24/17.
 */

public class OverwatchUtils {


    private static final String TAG = OverwatchUtils.class.getSimpleName();

    public static List<Photo> readHerosPhotos(Context context) {
        String json = getAssetsJson(context, "heros.json");
        return convertToPhotos(json);
    }

    public static List<Photo> readMapsPhotos(Context context) {
        String json = getAssetsJson(context, "maps.json");
        return convertToPhotos(json);
    }


    private static List<Photo> convertToPhotos(String json) {
        if (TextUtils.isEmpty(json)) {
            return Collections.EMPTY_LIST;
        }

        Gson gson = new Gson();
        return  gson.fromJson(json, new TypeToken<List<Photo>>(){}.getType());
    }

    private static String getAssetsJson(Context context, @NonNull String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");

        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return null;
    }
}
