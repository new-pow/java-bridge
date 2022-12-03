package bridge.view;

import bridge.domain.UserMoveCommand;
import bridge.exception.Exception;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest{
    @Test
    void readIntTest() {
        String input = "5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        inputView.readBridgeSize();
    }

    @Test
    void askMoveCommand_Test() {
        String input = "U";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        String s = inputView.readMoving();

        assertThat(s).isEqualTo(input);
    }

    @Test
    void askMoveCommand_Test_잘못된입력() {
        String input = "E";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        List<String> rightCommand = UserMoveCommand.getCommads();

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.NOT_VAILD_MOVE_COMMAND.getMessage(rightCommand));
    }
}