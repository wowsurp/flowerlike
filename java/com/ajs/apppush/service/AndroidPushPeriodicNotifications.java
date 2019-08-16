package com.ajs.apppush.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

	public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"ExponentPushToken[G0zUCjNJQbpNSR-ClT4kwa]"};

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }
        
//        body.put("registration_ids", array);
        body.put("to", "ExponentPushToken[G0zUCjNJQbpNSR-ClT4kwa]");
        
        JSONObject notification = new JSONObject();
        notification.put("title","hello!");
        notification.put("body","Today is "+localDate.getDayOfWeek().name()+"!");

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}
