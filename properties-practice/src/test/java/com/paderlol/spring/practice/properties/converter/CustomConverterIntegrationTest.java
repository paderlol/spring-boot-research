package com.paderlol.spring.practice.properties.converter;


import static org.assertj.core.api.Assertions.assertThat;

import com.paderlol.spring.practice.PropertiesPracticeApplication;
import com.paderlol.spring.practice.properties.pojo.Modes;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesPracticeApplication.class)
public class CustomConverterIntegrationTest {

    @Autowired ConversionService conversionService;

    @Test
    public void whenConvertStringToEnum_thenSuccess() {
        assertThat(conversionService.convert("ALPHA", Modes.class)).isEqualTo(Modes.ALPHA);
    }

    @Test
    public void whenConvertingToBigDecimalUsingGenericConverter_thenSuccess() {
        assertThat(conversionService
                .convert(Integer.valueOf(11), BigDecimal.class))
                .isEqualTo(BigDecimal.valueOf(11.00)
                        .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        assertThat(conversionService
                .convert(Double.valueOf(25.23), BigDecimal.class))
                .isEqualByComparingTo(BigDecimal.valueOf(Double.valueOf(25.23)));
        assertThat(conversionService.convert("2.32", BigDecimal.class))
                .isEqualTo(BigDecimal.valueOf(2.32));
    }


}
