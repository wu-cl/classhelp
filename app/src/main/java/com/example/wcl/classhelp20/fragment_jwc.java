package com.example.wcl.classhelp20;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wcl.jwc.jwc_Login;
import com.example.wcl.jwc.jwc_pass_set;
import com.example.wcl.other_activities.login;

import org.apache.http.util.EncodingUtils;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class fragment_jwc extends Fragment {

    private static boolean success_login=false;
    Runnable jwc_runnable;
    Runnable jwc_reload_runnable;
    WebView wView;
    private static String jwc_password=null;
    String cookie=null;

    Handler webviewChange =new Handler(){
        @Override
        public void handleMessage(Message msg){
            wView.setVisibility(View.VISIBLE);
        }
    };



    @Override
    public void onHiddenChanged(boolean hidden){

        if (hidden) {

        }else{
            main_fragment.text_main_title.setText("教务处");
        }

    }

    class Login_test {
        @JavascriptInterface
        public void show(String data) { //这里的data就webview加载的内容，即使页面跳转页都可以获取到，这样就可以做自己的处理了
            int index=data.indexOf("看不清换一张");
            if(index!=-1&&!success_login){
               new Thread(jwc_reload_runnable).start();
           }else{

                success_login=true;
                Message msg = new Message();
                webviewChange.sendMessage(msg);

            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main_fragment.text_main_title.setText("教务处");
    }








    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_jwc, container, false);

        Typeface font1 = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/MFYUEYUAN_NONCOMMERCIAL-REGULAR.OTF");
        TextView jwc_processBar=(TextView)view.findViewById(R.id.jwc_progressBar_text);
        jwc_processBar.setTypeface(font1);

        wView= (WebView)view.findViewById(R.id.web_jwc);
        //wView.loadUrl("http://jwxt.njupt.edu.cn");
        wView.addJavascriptInterface(new Login_test(), "handler");
        wView.requestFocusFromTouch();
        final WebSettings wSet = wView.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setBuiltInZoomControls(true); // 显示放大缩小 controler
        wSet.setSupportZoom(true); // 可以缩放
        wSet.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);// 默认缩放模式
        wSet.setUseWideViewPort(true);
        wSet.setCacheMode(WebSettings.LOAD_NO_CACHE);
        wSet.setAllowFileAccess(true);
        wSet.setAppCacheEnabled(true);
        wSet.setJavaScriptCanOpenWindowsAutomatically(true);
        wSet.setDomStorageEnabled(true);
        wSet.setDatabaseEnabled(true);
        wView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        wView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:window.handler.show(document.body.innerHTML);");
                super.onPageFinished(view, url);
            }
        });



        final jwc_Login jwc_test=new jwc_Login(this.getActivity().getApplicationContext());
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // TODO
                String result = cookie;
                try {
                    Map<String,String> extraHeaders = new HashMap<String, String>();
                    extraHeaders.put("Cookie", result);
                    extraHeaders.put("Referer", "http://jwxt.njupt.edu.cn/default2.aspx");
                    extraHeaders.put("Content-Type", "application/x-www-form-urlencoded");
                    extraHeaders.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 1.7; .NET CLR 1.1.4322; CIBA; .NET CLR 2.0.50727)");

                    //String postdata="Cookie="+result+"&Referer=http://jwxt.njupt.edu.cn/default2.aspx&Content-Type=application/x-www-form-urlencoded&User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 1.7; .NET CLR 1.1.4322; CIBA; .NET CLR 2.0.50727)";

                    CookieSyncManager.createInstance(view.getContext());
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    cookieManager.removeSessionCookie();//移除
                    cookieManager.setCookie("http://jwxt.njupt.edu.cn/xs_main.aspx?xh=" + login.username, cookie);//cookies是在HttpClient中获得的cookie
                    CookieSyncManager.getInstance().sync();
                    Thread.sleep(1000);

                    //wView.loadUrl("http://jwxt.njupt.edu.cn/xs_main.aspx?xh=" + login.username, extraHeaders);
                    wView.loadUrl("http://jwxt.njupt.edu.cn/xs_main.aspx?xh=" + login.username);
                    //wView.postUrl("http://jwxt.njupt.edu.cn/xs_main.aspx?xh=" + login.username, EncodingUtils.getBytes(postdata, "BASE64"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // UI界面的更新等相关操作
            }
        };
        jwc_reload_runnable=new Runnable(){

            @Override
            public void run() {
                handler.sendMessage(new Message());
            }
        };
       jwc_runnable =new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                Bundle data = new Bundle();
                jwc_password = jwc_pass_set.Get(login.username);
                if(jwc_password.equals("")){
                    fragment_mine_jwc_password.switch_from=main_fragment.mContent;
                    main_fragment.ReplaceSwitchContent(main_fragment.mContent,main_fragment.mine_jwc_password);
                }else {
                    try {


                        jwc_test.login(login.username, jwc_password);
                        String result = jwc_test.GetMainPage();
                        data.putString("value", result);
                        cookie=result;


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    msg.setData(data);
                    handler.sendMessage(msg);
                }
            }
        };

        new Thread(jwc_runnable).start();



        return view;
    }
}


