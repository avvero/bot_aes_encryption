package com.avvero.bot_aes_encryption.utils;

import org.jsoup.Jsoup;

/**
 * Created by Avvero on 25.05.2017.
 */
public class Utils {

    public static String extractTextOnly(String s) {
        return Jsoup.parse(s).text();
    }

}
