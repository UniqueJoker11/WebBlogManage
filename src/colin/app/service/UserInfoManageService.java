package colin.app.service;

import colin.app.dao.UserInfoManageDao;
import colin.core.pojo.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2015/1/14.
 */
@Component
public class UserInfoManageService {
    @Resource
    private UserInfoManageDao userInfoManageDao;
    /**
     * 验证用户名是否存在,存在返回true否则返回false;
     * */
    public boolean validateUserInfoExists(Map<String,Object> params){
        UserEntity userEntity= userInfoManageDao.selectUniqueObject(UserEntity.class,params);
        if (userEntity!=null){
            return true;
        }else{
            return false;
        }
    }
 }
