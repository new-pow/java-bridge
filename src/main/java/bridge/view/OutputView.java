package bridge.view;

import bridge.domain.Bridge;
import bridge.util.Printer;

import java.util.List;

import static bridge.view.BridgePrinter.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuilder upPath = new StringBuilder();
    private StringBuilder downPath = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, boolean check) {
        addToAllPath(BridgePrinter.getStart());
        for (int i=0; i<bridge.size()-1; i++) {
            addBlock(bridge.get(i), true);
        }
        addBlock(bridge.get(bridge.size()-1), check);
        addToAllPath(BridgePrinter.getEnd());
        Printer.print(upPath.toString()+"\n"+downPath.toString());
        initAllPath();
    }

    private void initAllPath() {
        upPath.setLength(0);
        downPath.setLength(0);
    }

    private void addToAllPath(String string) {
        if (upPath.length()>2) {
            upPath.deleteCharAt(upPath.length()-1);
            downPath.deleteCharAt(downPath.length()-1);
        }

        upPath.append(string);
        downPath.append(string);
    }

    private void addBlock(String path, Boolean check) {
        String block = checkBlock(check);
        if (path.equals(Bridge.PATH_UP.getCommand())) {
            upPath.append(block);
            downPath.append(NULL.getBridgeBlock());
        }
        if (path.equals(Bridge.PATH_DOWN.getCommand())) {
            upPath.append(NULL.getBridgeBlock());
            downPath.append(block);
        }
    }

    private String checkBlock(Boolean check) {
        if (check==null) {
            return NULL.getBridgeBlock();
        }
        if (check) {
            return PASS.getBridgeBlock();
        }
        return FAIL.getBridgeBlock();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
