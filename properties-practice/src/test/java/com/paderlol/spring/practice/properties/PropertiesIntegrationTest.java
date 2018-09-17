package com.paderlol.spring.practice.properties;

import static org.assertj.core.api.Assertions.assertThat;

import com.paderlol.spring.practice.PropertiesPracticeApplication;
import com.paderlol.spring.practice.properties.pojo.AcmeProperties;
import com.paderlol.spring.practice.properties.pojo.AcmeProperties.Security;
import com.paderlol.spring.practice.properties.pojo.CollectionProperties;
import com.paderlol.spring.practice.properties.pojo.MapProperties;
import com.paderlol.spring.practice.properties.pojo.Movie;
import com.paderlol.spring.practice.properties.pojo.Person;
import com.paderlol.spring.practice.properties.pojo.ThirdComponent;
import com.paderlol.spring.practice.properties.service.LanguageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesPracticeApplication.class)
public class PropertiesIntegrationTest {

    @Autowired ThirdComponent thirdComponent;

    @Autowired MapProperties mapProperties;

    @Autowired AcmeProperties acmeProperties;

    @Autowired LanguageService languageService;

    @Autowired CollectionProperties collectionProperties;

    @Test
    public void thirdComponentTest() {
        ThirdComponent actualThirdComponent = new ThirdComponent();
        actualThirdComponent.setEnable(true);
        actualThirdComponent.setPort(9990);
        actualThirdComponent.setUrl("test.com");

        assertThat(thirdComponent).isEqualToComparingFieldByField(actualThirdComponent);
    }

    @Test
    public void mapPropertiesTest() {
        MapProperties actualMapProperties = new MapProperties();
        actualMapProperties.getStringMap().put("key", "value-dev");
        actualMapProperties.getEntityMap()
                .put("key2", Person.builder().name("name-dev-test-1").age(10).build());
        actualMapProperties.getEntityMap()
                .put("key3", Person.builder().name("name-dev-test-2").age(100).build());
        actualMapProperties.getMovieMap()
                .put("key4", Movie.builder().name("COLD LIKE A KILLER").seat(200).build());

        assertThat(mapProperties).isEqualToComparingFieldByField(actualMapProperties);
    }

    //    acme:
//    enabled: true
//    security:
//    password: "1234567"
//    roles:
//            - "USER"
//            - "ADMIN"
//
    @Test
    public void nestedBeanPropertiesTest() {
        AcmeProperties actualAcmeProperties = new AcmeProperties();
        actualAcmeProperties.setEnabled(false);
        AcmeProperties.Security security = new Security();
        security.setPassword("1234567");
        security.getRoles().add("ADMIN");
        actualAcmeProperties.setSecurity(security);

        assertThat(acmeProperties).isEqualToComparingFieldByFieldRecursively(actualAcmeProperties);
    }


    @Test
    public void profileServiceTest() {

        assertThat(languageService.getLanguage()).isEqualTo("Chinese");
    }

    @Test
    public void collectionPropertiesTest() {
        CollectionProperties actualCollectionProperties = new CollectionProperties();
        actualCollectionProperties.getEntityList()
                .add(Person.builder().name("Jack-dev-test").age(20).build());
        actualCollectionProperties.getEntityList()
                .add(Person.builder().name("Tom-dev-test").age(23).build());
        actualCollectionProperties.getStringList().add("value-list-1-dev-test");
        actualCollectionProperties.getStringList().add("value-list-2-dev-test");

        assertThat(collectionProperties).isEqualToComparingFieldByField(actualCollectionProperties);
    }


}
