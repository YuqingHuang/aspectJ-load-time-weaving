package ltw.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DateTimeToStringAspect {

    public static final String TO_STRING_RESULT = "test";

//    public String toString(String var1)
    @Pointcut("execution(* org.joda.time.base.AbstractDateTime.toString())")
    public void dateTimeToString() {
    }

    @Around("dateTimeToString()")
    public Object toLowerCase(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ignoredToStringResult = joinPoint.proceed();
        System.out.println("DateTime#toString() has been invoked: " + ignoredToStringResult);
        return TO_STRING_RESULT;
    }

    @Before("execution(* org.joda.time.base.AbstractDateTime.toString(..)) && " +
            "args(var1)")
    public void beforeToStringWithArg(String var1) {
        System.out.println("beforeToStringWithArg: " + var1);
    }

}
