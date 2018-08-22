package com.paderlol.spring.auto.practice.autoconfigure.condition;

import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 模仿OnPropertyCondition实现一个根据系统属性条件是否满足
 * @author pader
 * @see org.springframework.boot.autoconfigure.condition.OnPropertyCondition
 * @see Condition
 */
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata
                .getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = annotationAttributes.get("name").toString();

        return Optional.ofNullable(System.getProperty(name)).isPresent();
    }

}
