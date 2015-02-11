package colin.app.action;

import colin.app.service.URLAddressSpiderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/26.
 * 根据前台传过来的url地址进行爬取，并返回相应的爬取内容
 */
@Controller
public class URLAddressSpiderAction {

    @Resource
    private URLAddressSpiderService urlAddressSpiderService;
    @RequestMapping(value = "/action/urlContentParse.do",params = {"urlAddress"},method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> parseURLRequest(@RequestParam(required = true) String urlAddress){
        Map<String,String> params=new HashMap<String,String>();
        params.put("url",urlAddress);
        //调用爬取程序开始处理爬取链接
       Map<String,Object> result=urlAddressSpiderService.parseURLAddressAndStore(params);
        //初始化返回结果
        Map<String,Object> resultMap=new HashMap<String, Object>();
        if (result.equals("storeFailed")||result.equals("accessError")||result.equals("invalid")){
            resultMap.put("isSuccess",false);
        }else{
            resultMap.put("isSuccess",true);
            resultMap.put("result",result);
            resultMap.put("url",urlAddress);
        }


        return resultMap;
    }
}
