import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ConsoleHandlerService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        ConsoleHandlerService consoleHandlerService = context.getBean(ConsoleHandlerService.class);
        consoleHandlerService.startService();
    }

}
