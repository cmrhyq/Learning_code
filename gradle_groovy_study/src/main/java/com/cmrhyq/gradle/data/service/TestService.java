package com.cmrhyq.gradle.data.service;

import com.cmrhyq.gradle.data.entity.Sentence;

import java.util.List;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestService.java
 * @project gradle_groovy_study
 * @package com.cmrhyq.gradle.data.service
 * @date 2023/7/13 23:35
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public interface TestService {

    /**
     * 查询语句信息
     *
     * @return Result
     */
    Sentence querySentence();
}
