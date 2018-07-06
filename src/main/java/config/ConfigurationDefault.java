package config;

import dao.QuestionDao;
import dao.QuestionDaoUnivocityImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import service.QuestionReaderService;
import service.QuestionReaderServiceImpl;


@PropertySource("classpath:config.properties")
@Configuration
public class ConfigurationDefault {

    @Bean
    public QuestionDao questionDao(
            @Value("#{ '${locale.default}' == 'ru_RU' ? 'questions.csv' : 'questions_eng.csv' }") String csvname) {
        return new QuestionDaoUnivocityImpl(csvname);
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
