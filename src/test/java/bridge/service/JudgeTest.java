package bridge.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @Test
    void 기능테스트_맞을때() {
        List<String> bridge = Arrays.asList("U","D","U");
        Judge judge = new Judge(bridge);

        int step = 0;
        String move = "U";

        assertThat(judge.checkStep(step,move)).isTrue();
    }

    @Test
    void 기능테스트_틀릴때() {
        List<String> bridge = Arrays.asList("U","D","U");
        Judge judge = new Judge(bridge);

        int step = 2;
        String move = "D";

        assertThat(judge.checkStep(step,move)).isFalse();
    }
}