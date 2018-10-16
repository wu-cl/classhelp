package com.example.wcl.jwc;

import android.content.Context;

import com.example.wcl.classhelp20.main_fragment;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wcl on 2016/8/7.
 */
public class jwc_Login {
    public Context context;

    private String stuNumber = "";
    private String stuName = "";
    private String Cookie = "";
    String secretCodeUrl="http://jwxt.njupt.edu.cn/CheckCode.aspx";
    String indexUrl="http://jwxt.njupt.edu.cn";
    String loginUrl="http://jwxt.njupt.edu.cn/default2.aspx";
    String identityStu="学生";
    String mainUrl="http://jwxt.njupt.edu.cn/xs_main.aspx?xh=";
    HttpClient httpclient=null;

    public jwc_Login(Context context){
        this.context=context;
    }
    public String login(String stuNumber, String password) throws Exception {
        this.stuNumber = stuNumber;
        // 获取验证码
        int password_test=0;

        do {
            stuName="";
            httpclient=new DefaultHttpClient();
            HttpGet secretCodeGet = new HttpGet(secretCodeUrl);
            HttpResponse response=httpclient.execute(secretCodeGet);
            // 获取返回的Cookie
            Cookie = response.getFirstHeader("Set-Cookie").getValue();

            String viewState = IOUtils.getViewState(indexUrl, "", "");
            // 将验证码下载

            IOUtils.getSecret(response.getEntity().getContent(), "secretCode.png", main_fragment.GetCachePath());


            String secret = secretCode.getAllOcr(main_fragment.GetCachePath() + "/secretCode.png", context);

            HttpPost loginPost = new HttpPost(loginUrl);// 创建登录的Post请求
            loginPost.setHeader("Cookie", Cookie);// 带上第一次请求的Cookie
            loginPost.setHeader("Content-Type","application/x-www-form-urlencoded");
            loginPost.setHeader("Referer", "http://jwxt.njupt.edu.cn/default2.aspx");
            List<NameValuePair> nameValuePairLogin = new ArrayList<NameValuePair>();// 封装Post提交参数
            nameValuePairLogin
                    .add(new BasicNameValuePair("__VIEWSTATE", viewState));// 隐藏表单值
            nameValuePairLogin
                    .add(new BasicNameValuePair("txtUserName", stuNumber));// 学号
            nameValuePairLogin.add(new BasicNameValuePair("TextBox2", password));// 密码
            nameValuePairLogin.add(new BasicNameValuePair("txtSecretCode", secret));// 验证码
            nameValuePairLogin.add(new BasicNameValuePair("RadioButtonList1",
                    identityStu));// 身份,默认学生
            nameValuePairLogin.add(new BasicNameValuePair("Button1", ""));
            nameValuePairLogin.add(new BasicNameValuePair("lbLanguage", ""));
            nameValuePairLogin.add(new BasicNameValuePair("hidPdrs", ""));
            nameValuePairLogin.add(new BasicNameValuePair("hidsc", ""));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairLogin, "utf-8");
            loginPost.setEntity(entity);
            HttpResponse responseLogin = httpclient.execute(loginPost);

            InputStream in=responseLogin.getEntity().getContent();
            String result = IOUtils.getHtml(in, "GB2312");


            password_test=result.indexOf("密码错误！！");

            if(password_test!=-1){
                break;
            }

            int NameIndex=result.indexOf("xhxm");
            if(NameIndex!=-1) {
                int NameEndIndex=result.indexOf("同学");
                stuName = result.substring(NameIndex+6,NameEndIndex);
            }







        }while(stuName.equals(""));

        if(password_test!=-1){
            return "WrongPassword";
        }else {
            return "success";
        }

    }
    public String GetTable()throws Exception{
        String result=null;
        HttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet("http://jwxt.njupt.edu.cn/xskbcx.aspx?xh="+stuNumber+"&xm="+stuName+"&gnmkdm=N121603");
        httpGet.setHeader("Cookie", Cookie);// 带上第一次请求的Cookie
        httpGet.setHeader("Content-Type","application/x-www-form-urlencoded");
        httpGet.setHeader("Referer", "http://jwxt.njupt.edu.cn/xs_main.aspx?xh="+stuNumber);
        HttpResponse responseLogin = httpclient.execute(httpGet);

        InputStream in=responseLogin.getEntity().getContent();
        result = IOUtils.getHtml(in, "GB2312");



        return result;
    }
    public String GetMainPage()throws Exception{

/*

        HttpGet mainGet = new HttpGet(mainUrl + stuNumber);
        mainGet.setHeader("Cookie", Cookie);
        mainGet.setHeader("Referer", loginUrl);
        mainGet.setHeader("Content-Type","application/x-www-form-urlencoded");
        mainGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 1.7; .NET CLR 1.1.4322; CIBA; .NET CLR 2.0.50727)");
        HttpResponse responseMain = httpclient.execute(mainGet);
        InputStream is = responseMain.getEntity().getContent();
        String html = "";
        try {
            html = IOUtils.getHtml(is, "GB2312");
        } catch (Exception e) {
            e.printStackTrace();
        }

*/
        return Cookie;
    }
}
