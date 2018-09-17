package com.paderlol.spring.practice.properties.editor;

import com.paderlol.spring.practice.properties.pojo.ExoticType;
import java.beans.PropertyEditorSupport;

/**
 * @author pader
 * PropertyEditor 在不同的包下面
 */
public class CustomExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        ExoticType exoticType = (ExoticType) getValue();
        return exoticType == null ? "" : exoticType.getName();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ExoticType exoticType = ExoticType.builder().name(text.toUpperCase()).build();

        setValue(exoticType);
    }


}