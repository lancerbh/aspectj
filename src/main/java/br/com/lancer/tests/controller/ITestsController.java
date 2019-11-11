package br.com.lancer.tests.controller;

import java.util.Random;

public interface ITestsController {

    default Integer aspectInterfaceDefaultMethod() {
        return new Random().nextInt();
    }

}
