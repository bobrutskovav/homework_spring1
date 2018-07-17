package ru.otus.config;

import ru.otus.dao.QuestionDao;
import ru.otus.dao.QuestionDaoUnivocityImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.service.QuestionReaderService;
import ru.otus.service.QuestionReaderServiceImpl;


@SpringBootConfiguration
public class ConfigurationDefault {

    @Bean
    public ApplicationSettings applicationSettings() {
        return new ApplicationSettings();
    }


    @Bean
    public QuestionDao questionDao(
            ApplicationSettings applicationSettings) {

        return new QuestionDaoUnivocityImpl(
                "questions_" + applicationSettings.getLocale() +".csv");
    }

    @Bean
    public QuestionReaderService questionReaderService(QuestionDao questionDao) {
        return new QuestionReaderServiceImpl(questionDao);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/l10n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }


}
