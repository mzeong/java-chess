package chess.domain;

public enum Command {

    START,
    END,
    MOVE,
    ;

    public boolean isStart() {
        return this == START;
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isMove() {
        return this == MOVE;
    }
    // public enum인데, command == Command.Move과 command.isMove()에는 어떤 차이가 있나요?
}
