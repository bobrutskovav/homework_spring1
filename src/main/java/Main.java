import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import service.ConsoleHandlerService;


@SpringBootApplication
@ComponentScan(basePackages = {"dao", "service", "config"})
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Main.class);
        ConsoleHandlerService consoleHandlerService = configurableApplicationContext
                .getBean(ConsoleHandlerService.class);
        consoleHandlerService.startService();
    }

}
