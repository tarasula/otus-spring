package ru.otus.spring3springboot.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.Shell;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.commands.Quit;
import ru.otus.spring3springboot.service.QuestionService;
import ru.otus.spring3springboot.service.UserInteractiveService;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationShellCommands implements Quit.Command{

    private final QuestionService questionService;
    private final UserInteractiveService userInteractiveService;
    private String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }

    @ShellMethod(value = "Publish event command", key = {"p", "print"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void print() {
        userInteractiveService.printQuestion(questionService.getQuestionFromCsvFile());
    }

    @ShellMethod(value="Exit the shell.", key={"quit","exit"})
    public void quit(){
        System.exit(0);
    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null ? Availability.unavailable("Сначала залогиньтесь") : Availability.available();
    }
}
