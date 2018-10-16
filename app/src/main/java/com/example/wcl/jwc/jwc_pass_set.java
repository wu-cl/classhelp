package com.example.wcl.jwc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcl on 2016/8/13.
 */
public class jwc_pass_set {

    public static void Set(String username,String password){
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));
        nameValuePair.add(new BasicNameValuePair("password", password));

        //Http post
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/jwc_pass_set.php");

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

            httpClient.execute(httpPost);

        } catch (Exception e) {
            // TODO Auto-generated catch block

        }



    }
    public static String Get(String username){
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));
        InputStream is=null;
        //Http post
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/jwc_pass_get.php");

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

            HttpResponse response=httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            is = entity.getContent();

        } catch (Exception e) {
            // TODO Auto-generated catch block

        }
        String result=null;
        try {
            result = IOUtils.getHtml(is, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;


    }
}
