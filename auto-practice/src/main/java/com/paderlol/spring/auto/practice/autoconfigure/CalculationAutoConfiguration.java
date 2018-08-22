package com.paderlol.spring.auto.practice.autoconfigure;

import com.paderlol.spring.auto.practice.annotation.EnableCalculation;
import com.paderlol.spring.auto.practice.autoconfigure.condition.ConditionalOnSystemProperty;

@ConditionalOnSystemProperty(name = "jdkVersion")
@EnableCalculation
public class CalculationAutoConfiguration {




}
