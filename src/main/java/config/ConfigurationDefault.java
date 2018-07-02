package config;

import dao.QuestionDao;
import dao.QuestionDaoUnivocityImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import service.QuestionReaderService;
import service.QuestionReaderServiceImpl;


@PropertySource("classpath:config.properties")
@Configuration
public class ConfigurationDefault {

    @Bean
    public QuestionDao questionDao(@Value("${questions.filename}") String csvname) {
        return new QuestionDaoUnivocityImpl(csvname);
    }

    @Bean
    public QuestionReaderService questionReaderService (QuestionDao questionDao) {
        return new QuestionReaderServiceImpl(questionDao);
    }


}
