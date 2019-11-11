package br.com.lancer.tests.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionAspect {

    @Around("execution(* *(..)) && within(br.com.lancer.tests..*) && !within(ExecutionAspect) && !within(AspectConfig) && !within(Application)")
    public Object logDuration(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(getOperation(pjp));
        return pjp.proceed();
    }

    private static final String getOperation(ProceedingJoinPoint pjp) {
        return String.format("%s#%s", pjp.getSignature().getDeclaringType().getCanonicalName(), pjp.getSignature().getName());
    }

}
