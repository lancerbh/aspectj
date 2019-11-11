package br.com.lancer.tests.controller;

import java.util.Random;

public abstract class TestsControllerBase implements ITestsController {

    protected void aspectSuperProtected() {
        aspectSuperPrivateMethod();
    }

    private Integer aspectSuperPrivateMethod() {
        return aspectSuperProtectedMethod();
    }

    protected Integer aspectSuperProtectedMethod() {
        return aspectSuperPrivateStaticFinalMethod();
    }

    private static final Integer aspectSuperPrivateStaticFinalMethod() {
        return aspectSuperPublicStaticMethod();
    }

    public static Integer aspectSuperPublicStaticMethod() {
        return new Random().nextInt();
    }

}
