package dao;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import domain.Question;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class QuestionDaoUnivocityImpl implements QuestionDao {

    private final String csvName;

    public QuestionDaoUnivocityImpl(String csvName) {
        this.csvName = csvName;
    }

    public List<Question> getAllQuestions() {
        return parseCsv();
    }


    private List<Question> parseCsv() {
        BeanListProcessor<Question> rowProcessor = new BeanListProcessor<>(Question.class);

        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);
        try {
            parser.parse(new FileReader(getClass().getClassLoader().getResource(csvName).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return rowProcessor.getBeans();
    }

}
