package com.company;


import org.json.JSONException;
import org.json.JSONObject;
public class Main {

    //测试发送GET和POST请求
    public static void main(String[] args) throws Exception {
        //企业id
        String corpid = "ww226ac420227ca99f";
        //应用的凭证密钥
        String corpsecret = "ofSnN2DGGfTnwe7VE9W7_sU1yE2e-1yJSbnsnZzRKpo";
        //发送GET请求
        //获取企业微信token
        String json = HttpRequest.sendGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken", "corpid=" + corpid + "&corpsecret=" + corpsecret);
        System.out.print(json);
        JSONObject jsonObj = new JSONObject(json);
        int errcode = (int) jsonObj.get("errcode");
        if (errcode == 0) {
            String access_token = (String) jsonObj.get("access_token");
            json=HttpRequest.sendGet("https://qyapi.weixin.qq.com/cgi-bin/department/list","access_token="+access_token+"&id=");
            System.out.print(json);
        }


        //发送POST请求
        //String s1 = HttpRequest.sendPost("http://localhost:8080/addComment", "questionId=1&content=美丽人生");
        //System.out.println(s1);
    }
}
