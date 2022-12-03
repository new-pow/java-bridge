package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.util.Printer;
import bridge.view.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.UserGameCommand.QUIT;

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
            if (!bridgeGame.isFail()) {
                failGame();
                break;
            }
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
    }

    private void failGame() {
        Printer.print(String.format(GameMessage.GAME_RESULT.getMessage(),"실패"));
        String command = inputView.readGameCommand();
        if (command.equals(QUIT.getCommand())) {
            Printer.print(GameMessage.GAME_END.getMessage());
        }
        initGame();
    }

}
