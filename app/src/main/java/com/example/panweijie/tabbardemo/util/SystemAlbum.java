package com.example.panweijie.tabbardemo.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.example.panweijie.tabbardemo.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panweijie on 16/3/23.
 */
public class SystemAlbum {

    private static class systemTonBuilder {
        private static SystemAlbum systemAlbum = new SystemAlbum();
    }

    public static SystemAlbum getInstance() {
        return systemTonBuilder.systemAlbum;
    }


    //查询本地图片
    public String recentPhoto(Context resolver){
        List<String> img_path=new ArrayList<String>();

        // 获取SDcard卡的路径
        String sdcardPath = Environment.getExternalStorageDirectory().toString();

        ContentResolver mContentResolver = resolver.getContentResolver();
        Cursor mCursor = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA},
                MediaStore.Images.Media.MIME_TYPE + "=? OR " + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media._ID + " DESC"); // 按图片ID降序排列

        while (mCursor.moveToNext()) {
            // 打印LOG查看照片ID的值
            long id = mCursor.getLong(mCursor.getColumnIndex(MediaStore.Images.Media._ID));
//            Log.e("MediaStore.Images.Media_ID=", id + "");

            // 过滤掉不需要的图片，只获取拍照后存储照片的相册里的图片
            String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
            if (path.startsWith(sdcardPath + "/DCIM/100MEDIA") || path.startsWith(sdcardPath + "/DCIM/Camera/")
                    || path.startsWith(sdcardPath + "DCIM/100Andro")) {
//                Log.i("image path=", path);
                    img_path.add("file://" + path);
            }
        }
        mCursor.close();
        return img_path.get(0);
    }

}
