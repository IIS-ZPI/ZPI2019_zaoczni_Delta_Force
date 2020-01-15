package com.example.financialappnbp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGetSender {

    private final OkHttpClient httpClient = new OkHttpClient();

    public String sendGet(String url) throws Exception {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } finally {
            if (response != null) {
                response.close();
            }
        }

    }

}
