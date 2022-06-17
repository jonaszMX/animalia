package com.mx.animalia.application.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtileriasHelper {
    public String convertObjectToJson(Object object) {
        String json = "";
        GsonBuilder builder = new GsonBuilder().serializeNulls();
        builder.disableHtmlEscaping();
        Gson gson = builder.create();
        try {
            json = gson.toJson(object);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json;
    }
}
