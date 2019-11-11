package br.com.lancer.tests.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestsController extends TestsControllerBase {

    @GetMapping
    public ResponseEntity<Integer> test() {
        aspectSuperProtected();
        aspectInterfaceDefaultMethod();
        return ResponseEntity.ok(aspectPrivateMethod());
    }

    private Integer aspectPrivateMethod() {
        return aspectProtectedMethod();
    }

    protected Integer aspectProtectedMethod() {
        return aspectPrivateStaticFinalMethod();
    }

    private static final Integer aspectPrivateStaticFinalMethod() {
        return aspectPublicStaticMethod();
    }

    public static Integer aspectPublicStaticMethod() {
        StringUtils.isNotBlank("");
        return new Random().nextInt();
    }

}
