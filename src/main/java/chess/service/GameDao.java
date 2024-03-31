package chess.service;

public interface GameDao {

    record BoardData(String pieces, String status) {
    }

    void save(String board, String boardStatus);

    BoardData find();
}
