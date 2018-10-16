package com.example.wcl.DB_Connection;

import com.alibaba.fastjson.JSONArray;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcl on 2016/8/16.
 */

public class DB_Mac_Get {
    public static List<Address> Get(String username) throws IOException {
        List<Address> address=null;
        String result="";

        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));

        HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/mac_get.php");

        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

        HttpResponse response = new DefaultHttpClient().execute(httpPost);

        HttpEntity entity = response.getEntity();

        result= EntityUtils.toString(entity, HTTP.UTF_8);

        result="["+result+"]";
        address=new ArrayList<Address>(JSONArray.parseArray(result, Address.class));


        return address;
    }


}
