package colin.app.service;

import colin.core.common.CommonTools;
import com.sun.jnlp.FileContentsImpl;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.log4j.Logger;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/29.
 */
@Component
public class URLAddressSpiderService {
    private static  Logger logger= Logger.getLogger(URLAddressSpiderService.class);
    /*
    * 通过传入的URL地址，开始调用url解析程序，并存储成HTML文件，并返回该文件的地址，予以显示
    * */
    public Map<String,Object> parseURLAddressAndStore(Map<String, String> params) {
        //返回对象初始化
        Map<String,Object> resultMap=new HashMap<String,Object>();
        //获取ＵＲＬ地址
        String urlAddress = params.get("url");
        if (CommonTools.valdiateURLAddress(urlAddress)) {
            HttpRequest httpRequest = HttpRequest.get(urlAddress).acceptEncoding("utf-8");
            HttpResponse response = httpRequest.send();
            response.acceptEncoding("UTF-8");
            if (response.statusCode() == 200) {
                //存储成HTML文件，若网页名称已存在，则直接覆盖。保持网页内容为最新版本
                String filename=CommonTools.getUniqueFileName(urlAddress.substring((urlAddress.lastIndexOf("/")+1),urlAddress.lastIndexOf(".")));
                System.out.println(response.bodyText());
                if (this.stroeFile(filename,response.bodyText())){
                    String fileStorePath=CommonTools.getProeprties("storeDir")+"/"+filename;
                    resultMap.put("isSuccess",true);
                    resultMap.put("result",fileStorePath);
               }else{
                    resultMap.put("isSuccess",false);
                }

            } else {
                System.out.println("返回响应码是 " + response.statusCode() + ",返回的是" + response.bodyText());
                resultMap.put("isSuccess",false);
            }
        } else {
            System.out.println("invalid");
            resultMap.put("isSuccess",false);
        }
        return resultMap;
    }

    //存放文件的方法
    public boolean stroeFile(String fileName, String content) {
         File storeDir = new File(CommonTools.getProeprties("storeDir"));
        if (!storeDir.exists()) {
            storeDir.mkdirs();
        }
        System.out.println(storeDir.getPath());
        File storeFile = new File(storeDir.getPath().concat(java.io.File.separator).concat(fileName)+".html");
        System.out.println("文件路径是"+storeFile.getPath()+"---"+java.io.File.separator);
        try {
            if (!storeFile.exists()) {
                storeFile.createNewFile();
            }
            logger.info("file isExists"+storeFile.exists());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(storeFile),"UTF-8"));
            String htmlContnet=new String(content.getBytes(Charset.forName("UTF-8")),"UTF-8");
            writer.write(htmlContnet);
            writer.flush();
            writer.close();
            logger.info("存储文件"+fileName+"完毕！");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
