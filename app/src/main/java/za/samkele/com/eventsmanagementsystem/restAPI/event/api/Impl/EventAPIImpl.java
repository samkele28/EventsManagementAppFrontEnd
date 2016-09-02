package za.samkele.com.eventsmanagementsystem.restAPI.event.api.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;
import za.samkele.com.eventsmanagementsystem.config.util.AppUtil;
import za.samkele.com.eventsmanagementsystem.restAPI.event.api.EventAPI;
import za.samkele.com.eventsmanagementsystem.restAPI.event.resources.EventResource;

/**
 * Created by Samkele on 9/1/2016.
 */
public class EventAPIImpl implements EventAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/events/";

    @Override
    public Set<EventResource> getEvents(String name) throws IOException{
        final String paramsURL = url + name;
        Request request = new Request.Builder()
                .url(paramsURL)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        Type resultType = new TypeToken<Set<EventResource>>(){
        }.getType();
        String value = response.body().string();
        return new Gson().fromJson(value, resultType);
    }
}
