package cn;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import org.apache.http.client.*;
public class httpclient {
    @Test
    public static  void  http(){
        HttpGet get = new HttpGet("http://www.baidu.com");
        System.out.println(get.getRequestLine());
    }
}
