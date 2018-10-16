package com.example.wcl.DB_Connection;

import com.example.wcl.jwc.IOUtils;

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
 * Created by wcl on 2016/8/11.
 */
public class DB_Login_Connection {
    public static String CheckPassword(String username,String password){

        InputStream is=null;

        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));
        nameValuePair.add(new BasicNameValuePair("password", password));

        //Http post
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/login.php");

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            is = entity.getContent();
        } catch (Exception e) {
            // TODO Auto-generated catch block

            return "ConnectionError";
        }
        String result=null;
        try {
            result = IOUtils.getHtml(is, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
    public static String GetName(String username){

        InputStream is=null;

        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));


        //Http post
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/login_name.php");

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            is = entity.getContent();
        } catch (Exception e) {
            // TODO Auto-generated catch block

            return "ConnectionError";
        }
        String result=null;
        try {
            result = IOUtils.getHtml(is, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
    public static String GetJwcPassword(String username){

        InputStream is=null;

        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

        nameValuePair.add(new BasicNameValuePair("username", username));


        //Http post
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://115.28.167.2/classAssistant/android_connection/login_name.php");

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            is = entity.getContent();
        } catch (Exception e) {
            // TODO Auto-generated catch block

            return "ConnectionError";
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
