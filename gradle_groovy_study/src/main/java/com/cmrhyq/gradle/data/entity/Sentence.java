package com.cmrhyq.gradle.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @classname Sentence.java
 * @project gradle_groovy_study
 * @package com.cmrhyq.gradle.data.entity
 * @date 2023/7/13 23:33
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
@Data
@Accessors(chain = true)
public class Sentence {

    private Integer id;

    private Integer userId;

    private String titleSentence;

    private String color;

    private String colorEn;

    private Date gmtCreate;

    private Date gmtModified;
}