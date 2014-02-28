package com.apf.androidfontlist;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static final String FAMILYNAME  = "familyname";
    public static final String STYLLE = "style";


    final static String SYSTEM_FILE_PATH= "/system/fonts/";

    // This is a MOC method which should be put in framework
    public static List<String> getAllSystemFontFiles() {
        List<String> fontFiles = new ArrayList<String>();
        Log.e("test", "file name: ");

        /*

        File[] files = new File(SYSTEM_FILE_PATH).listFiles();

        for (int i = 0; i < files.length; i++)
        {
            File f = files[i];
            Log.e("test", "file name: " + f.getPath());
            if (f.isFile() && isSupportedFontFile(f))
                fontFiles.add(f.getPath());
        }
        */
        fontFiles.add("/system/fonts/Roboto-Regular.ttf");
        fontFiles.add("/system/fonts/Roboto-Bold.ttf");
        fontFiles.add("/system/fonts/Roboto-Italic.ttf");
        fontFiles.add("/system/fonts/Roboto-BoldItalic.ttf");
        fontFiles.add("/system/fonts/Roboto-Light.ttf");
        fontFiles.add("/system/fonts/Roboto-LightItalic.ttf");
        fontFiles.add("/system/fonts/Roboto-Thin.ttf");
        fontFiles.add("/system/fonts/Roboto-ThinItalic.ttf");
        fontFiles.add("/system/fonts/RobotoCondensed-Regular.ttf");
        fontFiles.add("/system/fonts/RobotoCondensed-Bold.ttf");
        fontFiles.add("/system/fonts/RobotoCondensed-Italic.ttf");
        fontFiles.add("/system/fonts/RobotoCondensed-BoldItalic.ttf");
        fontFiles.add("/system/fonts/DroidSerif-Regular.ttf");
        fontFiles.add("/system/fonts/DroidSerif-Bold.ttf");
        fontFiles.add("/system/fonts/DroidSerif-Italic.ttf");
        fontFiles.add("/system/fonts/DroidSerif-BoldItalic.ttf");
        fontFiles.add("/system/fonts/DroidSans.ttf");
        fontFiles.add("/system/fonts/DroidSans-Bold.ttf");
        fontFiles.add("/system/fonts/DroidSansMono.ttf");
        fontFiles.add("/system/fonts/.SSTVietnamese-Roman.ttf");
        fontFiles.add("/system/fonts/.SSTVietnamese-Bold.ttf");
        fontFiles.add("/system/fonts/SoMCSans-Regular.ttf");
        fontFiles.add("/system/fonts/Padauk.ttf");
        fontFiles.add("/system/fonts/DroidNaskh-Regular.ttf");
        fontFiles.add("/system/fonts/DroidNaskhUI-Regular.ttf");
        fontFiles.add("/system/fonts/DroidSansEthiopic-Regular.ttf");
        fontFiles.add("/system/fonts/DroidSansHebrew-Regular.ttf");
        fontFiles.add("/system/fonts/DroidSansHebrew-Bold.ttf");
        fontFiles.add("/system/fonts/NotoSansThai-Regular.ttf");
        fontFiles.add("/system/fonts/NotoSansThai-Bold.ttf");
        fontFiles.add("/system/fonts/NotoSansThaiUI-Regular.ttf");
        fontFiles.add("/system/fonts/NotoSansThaiUI-Bold.ttf");
        // There are more font files like these
        fontFiles.add("/system/fonts/AndroidEmoji.ttf");
        fontFiles.add("/system/fonts/NotoColorEmoji.ttf");
        fontFiles.add("/system/fonts/DroidSansFallback.ttf");
        fontFiles.add("/system/fonts/MTLmr3m.ttf");

        return fontFiles;
    }

    private static boolean isSupportedFontFile(File f){
        // TO-DO should add more according to http://www.fileinfo.com/filetypes/font and capability of Android
        String[] fontExtension = {"ttf", "otf", "ttc"};
        String extension = f.getPath().substring(f.getPath().length() - fontExtension[0].length());
        for (int i = 0; i < 3; i++) {
            if (extension == fontExtension[i])
                return true;
        }
        return false;

    }

    public static String[] getNameAndStyle(String path){
        String[] nameAndStyle = new String[2];

        if (path == "/system/fonts/Roboto-Regular.ttf")     {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Regualr";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-Bold.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else {
            nameAndStyle[0] = "Unknown";
            nameAndStyle[1] = "Unknown";
            return nameAndStyle;
        }
    }

}
