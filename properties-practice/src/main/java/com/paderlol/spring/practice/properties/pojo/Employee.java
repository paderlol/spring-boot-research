package com.paderlol.spring.practice.properties.pojo;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/**
 * @author pader
 */
@Data
@Builder
public class Employee {

    private String empNo;
    private BigDecimal salary;
}
