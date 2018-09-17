package com.paderlol.spring.practice.properties.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;

/**
 * @author pader
 * 卡转换
 */
public class CreditCardEditor extends PropertyEditorSupport {

    public static final int CARD_LENGTH = 16;

    @Override
    public String getAsText() {
        CreditCard creditCard = (CreditCard) getValue();
         
        return creditCard == null ? "" : creditCard.getRawCardNumber();
    }
     
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            CreditCard creditCard = CreditCard.builder().rawCardNumber(text).build();
             
            String cardNo = text.replaceAll("-", "");
            if (cardNo.length() != CARD_LENGTH) {
                throw new IllegalArgumentException(
                        "Credit card format should be xxxx-xxxx-xxxx-xxxx");
            }
             
            try {
                creditCard.setBankIdNo( Integer.valueOf(cardNo.substring(0, 6)) );
                creditCard.setAccountNo( Integer.valueOf(
                  cardNo.substring(6, cardNo.length() - 1)) );
                creditCard.setCheckCode( Integer.valueOf(
                  cardNo.substring(cardNo.length() - 1)) );
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException(nfe);
            }
             
            setValue(creditCard);
        }
    }
}