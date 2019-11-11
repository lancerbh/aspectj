package br.com.lancer.tests.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecutionAspect {

    @Pointcut("execution(* *(..))")
    public void anyExecution() {
    }

    @Pointcut("execution(* br.com.lancer..*(..))")
    public void scopedExecution() {
    }

    // @formatter:off
    @Pointcut("!within(*..*ExecutionAspect*) " +
            "&& !within(*..*TestsApplication*)")
    // @formatter:on
    public void ignoresExecution() {
    }

    @Around("scopedExecution() && ignoresExecution()")
    public Object logDuration(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(getOperation(pjp));
        return pjp.proceed();
    }

    @Around("anyExecution() && !scopedExecution()")
    public Object logTest(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(String.format("out --> %s", getOperation(pjp)));
        return pjp.proceed();
    }

    private static final String getOperation(ProceedingJoinPoint pjp) {
        return String.format("%s#%s", pjp.getSignature().getDeclaringType().getCanonicalName(), pjp.getSignature().getName());
    }

}
