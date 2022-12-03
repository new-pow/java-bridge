package bridge.exception;

public enum Exception {
    NOT_VAILD_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_NUMBER("숫자를 입력해 주세요.");

    private final String message;
    private final String tag = "[ERROR] ";

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return tag + message;
    }
}
