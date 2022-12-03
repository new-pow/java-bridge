package bridge.view;

import java.util.Arrays;

public enum BridgePrinter {

    PASS("O",true),
    FAIL("X", false),
    NULL(" ", null);

    private String symbol;
    private Boolean check;
    private static final String START = "[";
    private static final String BLOCK = " %s |";
    private static final String END = "]";

    BridgePrinter(String symbol, Boolean check) {
        this.symbol = symbol;
        this.check = check;
    }

    public static String getStart() {
        return START;
    }
    public static String getEnd() {
        return END;
    }

    public String getBridgeBlock () {
        return String.format(BLOCK, symbol);
    }

    public static String getBridgeBlock (Boolean check) {
        BridgePrinter block = Arrays.stream(values())
                                    .filter(v -> v.check == check)
                                    .findFirst().get();
        return String.format(BLOCK, block.symbol);
    }
}
