package com.paderlol.spring.practice.properties.validator;

import com.paderlol.spring.practice.properties.pojo.CustomValidatorProperties;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 验证SampleProperties 属性是否为空
 * 验证SampleProperties host 格式是否正确
 * @author pader
 */
public class SamplePropertiesValidator implements Validator {

    final Pattern pattern = Pattern.compile("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");

    @Override
    public boolean supports(Class<?> type) {
        return type == CustomValidatorProperties.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "host", "host.empty");
        ValidationUtils.rejectIfEmpty(errors, "port", "port.empty");
        CustomValidatorProperties properties = (CustomValidatorProperties) o;
        if (properties.getHost() != null
                && !this.pattern.matcher(properties.getHost()).matches()) {
            errors.rejectValue("host", "Invalid host");
        }
    }

}