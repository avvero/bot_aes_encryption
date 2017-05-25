package com.avvero.bot_aes_encryption.utils;

import org.jsoup.Jsoup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Avvero on 25.05.2017.
 */
public class Utils {

    public static final Pattern pattern = Pattern.compile("<a>(.+?)</a>");

    public static String extract(String s) {
        return Jsoup.parse(s).text();
    }

}
