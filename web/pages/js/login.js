/**
 * Created by Administrator on 2015/1/13.
 */
$(function(){
    //绑定表单内容
    $("#userLoginForm").on("submit",function(e){
       //检测用户名是否为空
        var loginUsername=$("#loginUsername");
        if(!isEmptyForm(loginUsername)){
            $.UIkit.notify({
                message : '用户名不能为空！',
                status  : 'danger',
                timeout : 2000,
                pos     : 'top-center'
            });
        }else{
            var params=new Object();
            params.loginUsername
            //检测用户名是否存在！
            .$.ajax({
                url:'',
                method:'post',
                data:params
            })
        }
       //检测密码是否为空
    });
    function isEmptyForm(inputObj){
        if($.trim(inputObj.val())==""){
            return false;
        }else{
            return true;
        }
    }
})
