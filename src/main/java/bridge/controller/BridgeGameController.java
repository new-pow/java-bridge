package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.util.Printer;
import bridge.view.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
     * 게임 생성
     * */
    public void initGame () {
        Printer.print(GameMessage.START_MESSAGE.getMessage());
        int size = inputView.readBridgeSize();
        bridgeMaker.makeBridge(size);
    }

    /**
     * 게임 시작
     * */

    /**
     * 라운드 플레이
     * */
}
