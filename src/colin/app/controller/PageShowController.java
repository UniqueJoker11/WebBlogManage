package colin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2014/12/25.
 */
@Controller
public class PageShowController{

    @RequestMapping(value ="/page/*_show.html" ,method= RequestMethod.GET)
    public String  commonPageRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String requestStr=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        System.out.println("no sign "+requestStr);
        return requestStr.split("_")[0];
    }
}
