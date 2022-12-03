package bridge;

import bridge.exception.Exception;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    private static BridgeMaker bm;

    @BeforeAll
    static void beforeAll() {
        bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
   public void 다리생성_기능테스트() {
       int testSize = 5;

       List<String> bridge = bm.makeBridge(testSize);

       System.out.println(bridge.toString());
       assertThat(bridge).hasSize(testSize);
   }

    @Test
    public void 다리생성_기능_0입력시() {
        int testSize = 0;

        assertThatThrownBy(() -> bm.makeBridge(testSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.NOT_VAILD_SIZE.getMessage());
    }


}