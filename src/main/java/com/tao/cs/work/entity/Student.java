package com.tao.cs.work.entity;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 学号
     */
    private String card;

    private String name;

    private String sex;

    private String phone;


}
