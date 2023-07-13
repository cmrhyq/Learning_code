package com.cmrhyq.gradle.data.service.impl;

import com.cmrhyq.gradle.data.dao.TestMapper;
import com.cmrhyq.gradle.data.entity.Sentence;
import com.cmrhyq.gradle.data.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestServiceImpl.java
 * @project gradle_groovy_study
 * @package com.cmrhyq.gradle.data.service.impl
 * @date 2023/7/13 23:36
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 查询语句信息
     *
     * @return Result
     */
    @Override
    public Sentence querySentence() {
        return testMapper.querySentenceInfo();
    }
}
