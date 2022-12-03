package bridge.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgePrinterTest {
    
    @Test
    public void 기능테스트() throws Exception{
        String bridgeBlock = BridgePrinter.getBridgeBlock(true);
        String expectation = "[ O ]";

        System.out.println(bridgeBlock);
        assertThat(bridgeBlock).isEqualTo(expectation);
    }

    @Test
    public void 기능테스트_X() throws Exception{
        String bridgeBlock = BridgePrinter.getBridgeBlock(false);
        String expectation = "[ X ]";

        System.out.println(bridgeBlock);
        assertThat(bridgeBlock).isEqualTo(expectation);
    }
}