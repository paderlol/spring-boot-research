package com.paderlol.spring.practice.properties.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.paderlol.spring.practice.PropertiesPracticeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = PropertiesPracticeApplication.class)
@AutoConfigureMockMvc
public class StringToCreditCardEditorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void parseCreditCardNumberTest() throws Exception {
        mockMvc.perform(get("/credit-card/1234-1234-1111-0011")).andDo(print())
                .andExpect(jsonPath("$.rawCardNumber", is("1234-1234-1111-0011")))
                .andExpect(jsonPath("$.bankIdNo", is(123412)))
                .andExpect(jsonPath("$.accountNo", is(341111001)))
                .andExpect(jsonPath("$.checkCode", is(1)))
                .andExpect(status().isOk());
    }
}
