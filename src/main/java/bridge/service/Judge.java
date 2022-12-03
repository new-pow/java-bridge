package bridge.service;

import java.util.List;

public class Judge {
    List<String> answerBridge;

    public Judge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }


    public boolean checkStep(int step, String move) {
        if (answerBridge.get(step).equals(move)) {
            return true;
        }
        return false;
    }
}
