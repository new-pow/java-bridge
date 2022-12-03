package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public enum UserMoveCommand {
    UP("U"), DOWN("D");

    private final String COMMAND;

    UserMoveCommand(String command) {
        COMMAND = command;
    }

    public String getCommand() {
        return COMMAND;
    }

    public static List<String> getCommads() {
        List<String> commands = new ArrayList<>();
        for (UserMoveCommand value : values()) {
            commands.add(value.getCommand());
        }
        return commands;
    }
}
