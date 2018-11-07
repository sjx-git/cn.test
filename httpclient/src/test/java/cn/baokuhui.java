package cn;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class baokuhui {

    @Test
    public  static  void zhuhu(){
        //set url
        HttpGet httpGet1 = new HttpGet("https://api-treasurecollect.51kupai.com/treasure/v1/user/info");
        //set 必传的参数 token和appid
        httpGet1.addHeader("Authorization","1v05eee7041eb15ec295426c17f3977e3e649a3f43d7d9172b7782d98874451db255ac770e4a3c892dbcdc8732ad512e36");
        httpGet1.addHeader("x-app-id","10013");
        //初始化httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //发送请求并获取到返回值
            HttpResponse response =  httpClient.execute(httpGet1);
            // 获得响应的实体对象
            HttpEntity httpEntity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            String res = EntityUtils.toString(httpEntity,"UTF-8");
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
