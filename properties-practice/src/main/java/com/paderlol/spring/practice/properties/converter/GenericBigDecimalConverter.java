package com.paderlol.spring.practice.properties.converter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

/**
 * @author pader
 */
public class GenericBigDecimalConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        ConvertiblePair[] pairs = new ConvertiblePair[]{
                new ConvertiblePair(Number.class, BigDecimal.class),
                new ConvertiblePair(String.class, BigDecimal.class) };
        return Arrays.stream(pairs).collect(Collectors.toSet());
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (sourceType.getType() == BigDecimal.class) {
            return source;
        }

        if (sourceType.getType() == String.class) {
            String number = (String) source;
            return new BigDecimal(number);
        } else {
            Number number = Number.class.cast(source);
            BigDecimal converted = new BigDecimal(number.doubleValue());
            return converted.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
