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
        String[] nameAndStyle = new String[3];
        nameAndStyle[0] = "Unknown";
        nameAndStyle[1] = "Unknown";
        nameAndStyle[2] = "en";

        if (path == "/system/fonts/Roboto-Regular.ttf")     {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Regualr";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-Bold.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-Italic.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-BoldItalic.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Bold Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-Light.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Light";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-LightItalic.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Light Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-Thin.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Thin";
            return nameAndStyle;
        } else if (path == "/system/fonts/Roboto-ThinItalic.ttf") {
            nameAndStyle[0] = "Roboto";
            nameAndStyle[1] = "Thin Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/RobotoCondensed-Regular.ttf") {
            nameAndStyle[0] = "Roboto Condensed";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/RobotoCondensed-Bold.ttf") {
            nameAndStyle[0] = "Roboto Condensed";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/RobotoCondensed-Italic.ttf") {
            nameAndStyle[0] = "Roboto Condensed";
            nameAndStyle[1] = "Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/RobotoCondensed-BoldItalic.ttf") {
            nameAndStyle[0] = "Roboto Condensed";
            nameAndStyle[1] = "Bold Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSerif-Regular.ttf") {
            nameAndStyle[0] = "Droid Serif";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSerif-Bold.ttf") {
            nameAndStyle[0] = "Droid Serif";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSerif-Italic.ttf") {
            nameAndStyle[0] = "Droid Serif";
            nameAndStyle[1] = "Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSerif-BoldItalic.ttf") {
            nameAndStyle[0] = "Droid Serif";
            nameAndStyle[1] = "Bold Italic";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSans.ttf") {
            nameAndStyle[0] = "Droid Sans";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSans-Bold.ttf") {
            nameAndStyle[0] = "Droid Sans";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansMono.ttf") {
            nameAndStyle[0] = "Droid Sans Mono";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/.SSTVietnamese-Roman.ttf") {
            nameAndStyle[0] = "SST Vietnamese";
            nameAndStyle[1] = "Roman";
            return nameAndStyle;
        } else if (path == "/system/fonts/.SSTVietnamese-Bold.ttf") {
            nameAndStyle[0] = "SST Vietnamese";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/SoMCSans-Regular.ttf") {
            nameAndStyle[0] = "SoMC Sans Regular";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/Padauk.ttf") {
            nameAndStyle[0] = "Padauk";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidNaskh-Regular.ttf") {
            nameAndStyle[0] = "Droid Arabic Naskh";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidNaskhUI-Regular.ttf") {
            nameAndStyle[0] = "Droid Naskh Shift Alt";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansEthiopic-Regular.ttf") {
            nameAndStyle[0] = "Droid Sans Ethiopic";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansHebrew-Regular.ttf") {
            nameAndStyle[0] = "Droid Sans Hebrew";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansHebrew-Bold.ttf") {
            nameAndStyle[0] = "Droid Sans Hebrew";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansThai-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Thai";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansThai-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans Thai";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansThaiUI-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Thai UI";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansThaiUI-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans Thai UI";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansArmenian.ttf") {
            nameAndStyle[0] = "Droid Sans Armenian";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansGeorgian.ttf") {
            nameAndStyle[0] = "Droid Sans Georgian";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansDevanagari-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Devanagari";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansDevanagari-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans Devanagari";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        //Missing around another 10.......
        } else if (path == "/system/fonts/NotoSansKhmer-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansKhmer-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansKhmerUI-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansKhmerUI-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansLao-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Lao";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansLao-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans Lao";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansLaoUI-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Lao UI";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansLaoUI-Bold.ttf") {
            nameAndStyle[0] = "Noto Sans Lao UI";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NanumGothic.ttf") {
            nameAndStyle[0] = "NanumGothic";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/Padauk-book.ttf") {
            nameAndStyle[0] = "Padauk Book";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/Padauk-bookbold.ttf") {
            nameAndStyle[0] = "Padauk Book";
            nameAndStyle[1] = "Bold";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoSansSymbols-Regular.ttf") {
            nameAndStyle[0] = "Noto Sans Symbols";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/AndroidEmoji.ttf") {
            nameAndStyle[0] = "Android Emoji";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/NotoColorEmoji.ttf") {
            nameAndStyle[0] = "Noto Color Emoji";
            nameAndStyle[1] = "Medium";
            return nameAndStyle;
        } else if (path == "/system/fonts/DroidSansFallback.ttf") {
            nameAndStyle[0] = "Droid Sans Fallback";
            nameAndStyle[1] = "Regular";
            return nameAndStyle;
        } else if (path == "/system/fonts/MTLmr3m.ttf") {
            nameAndStyle[0] = "MotoyaLMaru";
            nameAndStyle[1] = "W3 mono";
            return nameAndStyle;
        } else {
            nameAndStyle[0] = "Unknown";
            nameAndStyle[1] = "Unknown";
            return nameAndStyle;
        }
    }

}
