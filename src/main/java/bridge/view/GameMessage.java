package bridge.view;

public enum GameMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),

    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_MOVE_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    GAME_RESULT_TITTLE("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s"),
    GAME_TRY_COUNT("총 시도한 횟수: %d");


    private final String MESSAGE;

    GameMessage(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
