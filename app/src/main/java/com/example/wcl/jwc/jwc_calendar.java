package com.example.wcl.jwc;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wcl on 2016/10/3.
 */

public class jwc_calendar {
    public static int current_week_get() throws ParseException {
        InputStream is=null;
        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet("http://jwc.njupt.edu.cn/s/24/t/923/5a/df/info88799.htm");

            HttpResponse response=httpClient.execute(httpGet);

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
        int start_index=result.indexOf("new Date().getWeeks(");
        result=result.substring(start_index+21);
        int end_index=result.indexOf("')");
        result=result.substring(0,end_index);
        String[] date = result.split("/");
        String start_date=date[2]+"-"+date[0]+"-"+date[1];

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        String current_date=df.format(new Date());// new Date()为获取当前系统时间
        java.util.Date start_date_final= df.parse(start_date);
        java.util.Date mydate= df.parse(current_date);
        long day=(mydate.getTime()-start_date_final.getTime())/(24*60*60*1000);

        int week= (int) Math.ceil(day/7)+1;

        return week;
    }


}
