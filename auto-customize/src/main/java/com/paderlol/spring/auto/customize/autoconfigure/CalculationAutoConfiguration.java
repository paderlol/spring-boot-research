package com.paderlol.spring.auto.customize.autoconfigure;

import com.paderlol.spring.auto.customize.annotation.EnableCalculation;
import com.paderlol.spring.auto.customize.autoconfigure.condition.ConditionalOnSystemProperty;

@ConditionalOnSystemProperty(name = "jdkVersion")
@EnableCalculation
public class CalculationAutoConfiguration {




}
