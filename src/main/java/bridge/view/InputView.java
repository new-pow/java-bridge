package bridge.view;

import bridge.domain.UserGameCommand;
import bridge.domain.UserMoveCommand;
import bridge.exception.Exception;
import bridge.util.Printer;

import java.util.List;
import java.util.regex.Pattern;

import static bridge.exception.Exception.*;
import static bridge.view.GameMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String INT_PATTERN = "^[0-9]+$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Printer.print(GameMessage.ASK_BRIDGE_SIZE.getMessage());
        return readInt();
    }

    private int readInt() {
        try {
            String s = readLine();
            isVaildNumberFormat(s);
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            Printer.print(e.getMessage());
            return readBridgeSize();
        }
    }

    private void isVaildNumberFormat(String s) {
        if (!s.matches(INT_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Printer.print(ASK_MOVE_COMMAND.getMessage());
        return getMoveCommand();
    }

    private String getMoveCommand() {
        try {
            String input = readLine();
            isValidMove(input);
            return input;
        } catch (IllegalArgumentException e) {
            Printer.print(e.getMessage());
            return readMoving();
        }
    }

    private void isValidMove(String input) {
        List<String> rightCommands = UserMoveCommand.getCommads();

        if (!rightCommands.contains(input)) {
            throw new IllegalArgumentException(NOT_VAILD_COMMAND.getMessage(rightCommands));
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Printer.print(ASK_GAME_COMMAND.getMessage());
        return getGameCommand();
    }

    private String getGameCommand() {
        try {
            String input = readLine();
            isValidGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            Printer.print(e.getMessage());
            return readGameCommand();
        }
    }

    private void isValidGameCommand(String input) {
        List<String> rightCommands = UserGameCommand.getCommads();

        if (!rightCommands.contains(input)) {
            throw new IllegalArgumentException(NOT_VAILD_COMMAND.getMessage(rightCommands));
        }
    }


}
