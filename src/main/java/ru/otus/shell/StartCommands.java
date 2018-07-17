package ru.otus.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.service.ConsoleHandlerService;

@ShellComponent
public class StartCommands {

    private final ConsoleHandlerService consoleHandlerService;

    @Autowired
    public StartCommands(ConsoleHandlerService consoleHandlerService) {
        this.consoleHandlerService = consoleHandlerService;
    }

    @ShellMethod(value = "Start test", key = "start")
    public void start(@ShellOption String username) {
        consoleHandlerService.startService(username);
    }
}
