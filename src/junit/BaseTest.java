package junit;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/1/8.
 */
public class BaseTest {
    //制作一个post请求，然后对该请求进行
    public void testVirtualPostRequest(String address){
        HttpRequest request=new HttpRequest();
        Map<String,String> params=new HashMap<String,String>();
        params.put("appName","pcenteradmin");
        params.put("appSecret","trshaierqd");
        params.put("accessMode","NOTAPP");
        params.put("secretKey","trshaierqd");
        params.put("serviceName","pcenterHaierRequestJson");
        //HttpResponse response=request.method("post").protocol("http").post("http://heretest.haier.com/").path("/hjson/testhj.hjson").query(params).send();
        HttpResponse response = HttpRequest
                .post(address)
                .query(params)
                .send();
        System.out.println(response.bodyText());
    }
    //制作一个post请求，然后对该请求进行
    public void testVirtualGetRequest(String address){
        HttpRequest request=new HttpRequest();
        Map<String,String> params=new HashMap<String,String>();
        params.put("appName","wx_wash_bbs");
        params.put("appSecret","6b984b771");
        params.put("accessMode","NOTAPP");
        params.put("secretKey","6b984b771");
        params.put("serviceName","pcenterHaierRequestJson");
        //HttpResponse response=request.method("post").protocol("http").post("http://heretest.haier.com/").path("/hjson/testhj.hjson").query(params).send();
        HttpResponse response = HttpRequest
                .get(address)
                .query(params)
                .send();
        System.out.println(response.bodyText());
    }
    public static void main(String[] args){
        BaseTest test=new BaseTest();
        //test.testVirtualPostRequest("http://heretest.haier.com/hjson/testhj.hjson");
        System.out.println("-------------华丽的分割线-------------");
        test.testVirtualGetRequest("http://test.haier.com/cn/consumer/cooling/dkmbx/201409/t20140909_163773_appHjson.hjson");
        String content="/cn/consumer/cooling/dkmbx/201409/t20140909_163773_appHjson.hjson";
        //System.out.println(content.lastIndexOf("/"));
    }
}
