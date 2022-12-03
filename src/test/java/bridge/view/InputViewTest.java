package bridge.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
}