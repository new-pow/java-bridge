package bridge.controller;

import bridge.exception.Exception;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameControllerTest {
    private static BridgeGameController bridgeGameController;

   @BeforeEach
   private void Befor() {
       bridgeGameController = new BridgeGameController();
   }

    @Test
    void 게임생성테스트_숫자아닐때() {
        String input = "%";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> bridgeGameController.startGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.NOT_NUMBER.getMessage());
    }
}