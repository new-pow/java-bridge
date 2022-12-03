package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.util.Printer;
import bridge.view.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
     * 게임 생성
     * */
    public void startGame () {
        Printer.print(GameMessage.START_MESSAGE.getMessage());
        initGame();

        while (!bridgeGame.isGoal()) {
            goForward();
        }
    }


    /**
     * 게임 시작
     * */
    private void initGame() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }


    /**
     * 라운드 플레이
     * */
    private void goForward() {
        String move = inputView.readMoving();
        boolean checkStep =  bridgeGame.move(move);
        outputView.printMap(bridgeGame.getPlayBridge(), checkStep);
        if (!checkStep) {
            failGame();
        }
    }

    private void failGame() {
        Printer.print();
    }

}
