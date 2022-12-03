package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public enum UserGameCommand{

    RESTART("R"), QUIT("Q");

    private final String COMMAND;

    UserGameCommand(String command) {
        this.COMMAND = command;
    }

    public String getCommand() {
        return COMMAND;
    }

    public List<String> getCommads() {
        List<String> commands = new ArrayList<>();
        for (UserGameCommand value : values()) {
            commands.add(value.getCommand());
        }
        return commands;
    }
}
