package com.example.wcl.jwc;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.example.wcl.classhelp20.main_fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wcl on 2016/8/8.
 */
public class secretCode {
    private static Map<Bitmap, String> trainMap = null;

    public static int isBlue(int colorInt) {
        int red = (colorInt & 0xff0000) >> 16;
        int green = (colorInt & 0x00ff00) >> 8;
        int blue = (colorInt & 0x0000ff);
        int rgb = red + green + blue;
        if (rgb == 153) {
            return 1;
        }
        return 0;
    }

    public static int isBlack(int colorInt) {
        int red = (colorInt & 0xff0000) >> 16;
        int green = (colorInt & 0x00ff00) >> 8;
        int blue = (colorInt & 0x0000ff);
        if (red + green + blue <= 100) {
            return 1;
        }
        return 0;
    }

    public static Bitmap removeBackgroud(String picFile) throws Exception {
        Bitmap img=null;
        File file = new File(picFile);
        if(file.exists())
        {
            img = BitmapFactory.decodeFile(picFile);
        }
        img=Bitmap.createBitmap(img, 5, 1, img.getWidth() - 5, img.getHeight() - 2);
        img=Bitmap.createBitmap(img, 0, 0, 50, img.getHeight());
        int width = img.getWidth();
        int height = img.getHeight();

        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                if(isBlue(img.getPixel(x, y)) == 1){
                    img.setPixel(x, y, Color.BLACK);
                }else{
                    img.setPixel(x, y, Color.WHITE);
                }
            }
        }
        return img;
    }

    public static List<Bitmap> splitImage(Bitmap img)
            throws Exception {
        List<Bitmap> subImgs = new ArrayList<Bitmap>();
        int width = img.getWidth()/4;
        int height = img.getHeight();
        subImgs.add(Bitmap.createBitmap(img,0, 0, width, height));
        subImgs.add(Bitmap.createBitmap(img,width, 0, width, height));
        subImgs.add(Bitmap.createBitmap(img,width * 2, 0, width, height));
        subImgs.add(Bitmap.createBitmap(img,width * 3, 0, width, height));
        return subImgs;
    }

    public static Map<Bitmap, String> loadTrainData(Context context) throws Exception {
        if (trainMap == null) {
            Map<Bitmap, String> map = new HashMap<Bitmap, String>();

            String[] PicNames = context.getResources().getAssets().list("trainimg");
            for(int i=0;i<PicNames.length;i++){
                map.put(BitmapFactory.decodeStream(context.getResources().getAssets().open("trainimg/"+PicNames[i])), PicNames[i].charAt(0) + "");
            }

            trainMap =map;
        }
        return trainMap;
    }

    public static String getSingleCharOcr(Bitmap img,
                                          Map<Bitmap, String> map) {
        String result = "#";
        int width = img.getWidth();
        int height = img.getHeight();
        int min = width * height;
        for (Bitmap bi : map.keySet()) {
            int count = 0;
            if (Math.abs(bi.getWidth()-width) > 2)
                continue;
            int widthmin = width < bi.getWidth() ? width : bi.getWidth();
            int heightmin = height < bi.getHeight() ? height : bi.getHeight();
            Label1: for (int x = 0; x < widthmin; ++x) {
                for (int y = 0; y < heightmin; ++y) {
                    if (isBlack(img.getPixel(x, y)) != isBlack(bi.getPixel(x, y))) {
                        count++;
                        if (count >= min)
                            break Label1;
                    }
                }
            }
            if (count < min) {
                min = count;
                result = map.get(bi);
            }
        }
        return result;
    }

    public static String getAllOcr(String file,Context context) throws Exception {
        Bitmap img = removeBackgroud(file);
        List<Bitmap> listImg = splitImage(img);
        Map<Bitmap, String> map = loadTrainData(context );
        String result = "";
        for (Bitmap bi : listImg) {
            result += getSingleCharOcr(bi, map);

        }
        return result;
    }

}
