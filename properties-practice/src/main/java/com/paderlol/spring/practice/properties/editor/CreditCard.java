package com.paderlol.spring.practice.properties.editor;

import lombok.Builder;
import lombok.Data;

/**
 * 信用卡
 * @author pader
 */
@Data
@Builder
public class CreditCard {
 
    private String rawCardNumber;
    private Integer bankIdNo;
    private Integer accountNo;
    private Integer checkCode;

}