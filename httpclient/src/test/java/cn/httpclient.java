package cn;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class httpclient {
    @Test
    public static  void  http(){
        CloseableHttpClient httpCilent2 = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://mixer.video.iqiyi.com/mixin/resource/219170612");
        try {
            HttpResponse httpResponse = httpCilent2.execute(httpGet);
            /*** 获取返回对象*/
            HttpEntity entity = httpResponse.getEntity();
            /*** 通过EntityUitls获取返回内容*/
            String result = EntityUtils.toString(entity,"UTF-8");
            /*** 转换成json,根据合法性返回json或者字符串*/
            try{
                JSONObject jsonObject = JSONObject.parseObject(result);
                /**内容带有中括号[]，所以要转化为JSONArray类型的对象**/
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for (int i = 0; i < jsonArray.size(); i++) {//循环json数组
                    JSONObject ob = (JSONObject) jsonArray.get(i);//得到json对象
                    String url = ob.getString("pageUrl");//获取json对象中key为pageurl的值
                    System.out.println(url);
                    }
                    /** 单一读取
                     JSONObject erMsg1 =  (JSONObject) jsonArray.get(0);
                     String url =  erMsg1.getString("pageUrl") ;
                     System.out.println(url);
                     **/
                    }catch (Exception e){
                System.out.println("zade");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
