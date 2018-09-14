package com.paderlol.spring.practice.properties.format;

import com.paderlol.spring.practice.properties.pojo.Employee;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

/**
 * @author pader
 */
@Slf4j
public class EmployeeFormatter implements Formatter<Employee> {

    @Override
    public Employee parse(String text, Locale locale) throws ParseException {
        log.info("使用[Formatter]接口,转换数据={}", text);
        String[] data = text.split(",");
        return Employee.builder().empNo(data[0]).salary(new BigDecimal(data[1])).build();
    }

    @Override
    public String print(Employee employee, Locale locale) {
        log.info("使用[Formatter]接口,转换数据={}", employee.toString());
        return employee.toString();
    }
}
