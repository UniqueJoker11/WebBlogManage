package colin.core.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import sun.tools.java.ClassPath;
import sun.util.resources.CalendarData_mt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/12/29.
 */
public class CommonTools {
    /**
     * 检测传递的URL是否是合法的URL格式
     */

    public static boolean valdiateURLAddress(String url) {
        String urlFormat = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlFormat);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    /**
     * 读取属性文件，返回相应的属性值
     */

    public static String getProeprties(String proeprtyName) {
        ClassPathResource resource=new ClassPathResource("properties/common.properties");
        Properties properties=new Properties();
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(proeprtyName);
    }
   /**
    * 获取唯一的文件名
    * */
   public static String getUniqueFileName(String prefixName){
       Calendar calendar=Calendar.getInstance();
       SimpleDateFormat dateFormat=new SimpleDateFormat("YYYYMMDDmmhhss");
       String timeVal=dateFormat.format(calendar.getTime());
       Random random= new Random();
       int randomNum=random.nextInt(300);
       return timeVal.concat(String.valueOf(randomNum).concat("_"+prefixName));
   }
     public static void main(String[] args){
        CommonTools tools=new CommonTools();
        System.out.println(CommonTools.getProeprties("storeDir"));
       /* SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=1;i<31;i++){
            Calendar calendar= Calendar.getInstance();
            calendar.add(Calendar.DATE,(-30+i));
            System.out.println(dateFormat.format(calendar.getTime()));
        }*/
    }
}
