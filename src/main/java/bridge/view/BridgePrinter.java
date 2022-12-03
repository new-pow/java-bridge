package bridge.view;

import java.util.Arrays;
import java.util.List;

public enum BridgePrinter {

    PASS("O",true),
    FAIL("X", false);

    private String symbol;
    private boolean check;
    private static final String BLOCK = "[ %s ]";
    private static final String SEPARATOR = "|";

    BridgePrinter(String symbol, boolean check) {
        this.symbol = symbol;
        this.check = check;
    }

    public static String getBridgeBlock (boolean check) {
        BridgePrinter block = Arrays.stream(values())
                                    .filter(v -> v.check == check)
                                    .findFirst().get();
        return String.format(BLOCK, block.symbol);
    }
}
