package com.cmrhyq.gradle.controller;

import com.cmrhyq.gradle.data.entity.Sentence;
import com.cmrhyq.gradle.data.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestController.java
 * @project gradle_groovy_study
 * @package com.cmrhyq.gradle.controller
 * @date 2023/7/13 23:26
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestService testService;


    @PostMapping("/querySentence")
    public Sentence querySentence() {
        return testService.querySentence();
    }


}
