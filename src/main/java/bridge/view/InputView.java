package bridge.view;

import bridge.exception.Exception;
import bridge.util.Printer;

import java.util.regex.Pattern;

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
            throw new IllegalArgumentException(Exception.NOT_NUMBER.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


}
