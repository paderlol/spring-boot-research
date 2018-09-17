package com.paderlol.spring.practice.properties.editor;

import com.paderlol.spring.practice.properties.pojo.Movie;
import java.beans.PropertyEditorSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author pader PropertyEditor 在不同的包下面
 */
@Slf4j
public class CustomMovieEditor extends PropertyEditorSupport implements PropertyEditorRegistrar {

    @Override
    public String getAsText() {
        Movie movie = (Movie) getValue();
        return movie == null ? "" : movie.getName();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        log.info("继承[PropertyEditorSupport]类,转换数据={}", text);
        String[] data = text.split("-");
        Movie movie = Movie.builder().name(data[0].toUpperCase()).seat(Integer.parseInt(data[1]))
                .build();
        setValue(movie);
    }


    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Movie.class,this);
    }
}