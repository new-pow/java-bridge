package bridge.domain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

public enum Bridge {
    PATH_UP(0, "U"),
    PATH_DOWN(1,"D");

    private final int number;
    private final String command;

    Bridge(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public int getNumber() {
        return number;
    }

    public String getCommand() {
        return command;
    }

    public static String getPathCommand(int index) {
        Bridge any = Arrays.stream(values())
                .filter(bridge -> index == bridge.getNumber())
                .findFirst().get();
        return any.getCommand();
    }
}
