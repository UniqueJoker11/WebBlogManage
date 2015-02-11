package colin.app.action;

import colin.app.service.UserInfoManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/29.
 * 对用户信息的增删改查，一个controlelr来控制所有的请求，专门来控制有关用户信息的Controller
 */
@Controller
public class UserInfoManageAction extends MultiActionController{
    @Resource
    private UserInfoManageService userInfoManageService;
    @RequestMapping(value = "/validateUserLogin.do",method = RequestMethod.POST)
    public Map<String,Object> validateUserValid(String username){
return null;
    }
}
