package com.cmrhyq.gradle.data.dao;

import com.cmrhyq.gradle.data.entity.Sentence;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname TestMapper.java
 * @project gradle_groovy_study
 * @package com.cmrhyq.gradle.data.dao
 * @date 2023/7/13 23:32
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Component
@Mapper
public interface TestMapper {
    /**
     * 随机返回一条语句信息
     *
     * @return Sentence
     */
    Sentence querySentenceInfo();
}
