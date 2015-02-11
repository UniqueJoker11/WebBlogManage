package colin.core.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志管理类
 */
@Aspect
@Component
public class LoggerManageAspect {
    // 指定切入点匹配表达式，注意它是以方法的形式进行声明的。
    //即切点集合是：aop.annotation包下所有类所有方法
    //第一个* 代表返回值类型
//如果要设置多个切点可以使用 || 拼接
/*    @Pointcut("execution(* colin.app.action.URLAddressSpiderAction.*(..))")
    public void anyMethod() {
        System.out.println("hehejnj");
    }*/
    //前置通知
    //在切点方法集合执行前，执行前置通知
    @Before("execution(* colin.app.action.URLAddressSpiderAction.*(..)))")
    public void addLogBeforeInvoke(JoinPoint jp){
        System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");
        System.out.print(jp.getSignature().getName() + "方法进行对 '");
        System.out.print(jp.getArgs()[0] + "'进行删除！\n\n");
        System.out.println(jp.getTarget().getClass().getName());
        System.out.println("要进入切入点方法了 \n");

    }
    //在切点方法集合执行前，执行前置通知
    @Before("execution(* colin.app.service.URLAddressSpiderService.*(..)))")
    public void  addLogBeforeInvokeService(JoinPoint jp){
        System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");
        System.out.print(jp.getSignature().getName() + "方法进行对 '");
        System.out.print(jp.getArgs()[0] + "'进行删除！\n\n");
        System.out.println(jp.getTarget().getClass().getName());
        System.out.println("要进入切入点方法了 \n");

    }
}
