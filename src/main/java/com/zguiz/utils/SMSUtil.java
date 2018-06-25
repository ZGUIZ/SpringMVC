package com.zguiz.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SMSUtil {
    private static final String url="http://v.juhe.cn/sms/send";
    private static final String tplId="84291";
    private static final String key="7e2093da26183f68d4c6b44cc142b593";
    public static String sendSMS(String mobile){
        String result=null;
        int code=getRandomValue();
        try{
            Map params=new HashMap();
            params.put("mobile",mobile);
            params.put("tpl_id",tplId);
            params.put("tpl_value","#code#="+code);
            params.put("key",key);
            params.put("dtype","");
            result=net(url,params,"GET");
            JSONObject object=JSONObject.parseObject(result);
            System.out.println(result);
            if(object.getInteger("error_code")==0){
                System.out.println("发送成功");
            }
            else{
                System.out.println("发送失败");
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return String.valueOf(code);
    }

    //生成随机验证码
    private static int getRandomValue(){
        int min=1000;
        int max=9999;
        Random random=new Random();
        return random.nextInt(max)%(max-min+1)+min;
    }

    //发送请求
    private static String net(String strUrl,Map params,String method) throws Exception{
        HttpURLConnection conn=null;
        BufferedReader reader=null;
        String rs=null;
        try{
            StringBuffer sb=new StringBuffer();
            if(method==null||method.equals("GET")){
                strUrl=strUrl+"?"+urlencode(params);
            }
            URL url=new URL(strUrl);
            conn=(HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if(params!=null && method.equals("POST")){
                try{
                    DataOutputStream out=new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            InputStream is=conn.getInputStream();
            reader=new BufferedReader(new InputStreamReader(is));
            String strRead=null;
            while ((strRead=reader.readLine())!=null){
                sb.append(strRead);
            }
            rs=sb.toString();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(reader!=null){
                reader.close();
            }
            if(conn!=null){
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
