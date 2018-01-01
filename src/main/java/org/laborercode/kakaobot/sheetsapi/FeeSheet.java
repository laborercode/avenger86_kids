package org.laborercode.kakaobot.sheetsapi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FeeSheet {
    private static final String url = "https://sheets.googleapis.com/v4/spreadsheets";
    private static final String spreadsheetId = "1OEzu4Yka025McPjHP0t_TZxfgxZch4ukwtk568jbZV4";
    private static final String range = "'2018 회비'";
    private static final String key = "AIzaSyA_Xd9S5EC0ioX2p5j1cMKgGfde2q0yvr0";

    public static synchronized Object getSheetData() {
        byte[] jsonBytes = getJsonData();
        // TODO
        return null;
    }

    private static byte[] getJsonData() {
        OkHttpClient client = new OkHttpClient();
        Request httpRequest = new Request.Builder().url(
                url + "/" + spreadsheetId + "/values/" + range +
                "?key=" + key).build();

        Response httpResponse = null;
        try {
            httpResponse = client.newCall(httpRequest).execute();
            return httpResponse.body().bytes();
        } catch (IOException e) {
            return null;
        } finally {
            if(httpResponse != null) {
                httpResponse.close();
            }
        }
    }
}
