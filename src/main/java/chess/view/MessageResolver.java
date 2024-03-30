package chess.view;

import chess.domain.game.Score;
import chess.domain.piece.Piece;
import chess.domain.piece.Side;
import chess.domain.position.File;
import chess.domain.position.Rank;
import chess.view.mapper.PieceMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MessageResolver {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String resolveBoardMessage(List<Piece> pieces) {
        return Arrays.stream(Rank.values())
                .map(rank -> rankPieces(rank, pieces))
                .map(this::resolvePiecesMessage)
                .collect(Collectors.joining(LINE_SEPARATOR, "", LINE_SEPARATOR));
    }

    private List<Piece> rankPieces(Rank rank, List<Piece> pieces) {
        int fromIndex = rank.ordinal() * File.length();
        int toIndex = fromIndex + File.length();
        return pieces.subList(fromIndex, toIndex);
    }

    private String resolvePiecesMessage(List<Piece> pieces) {
        return pieces.stream()
                .map(PieceMapper::toText)
                .collect(Collectors.joining(""));
    }

    public String resolveScoreMessage(Score score) {
        String message = String.format("검은색: %.1f, 흰색: %.1f, 이긴 진영: %s", score.blackScore(), score.whiteScore(),
                resolveWinSideMessage(score.winSide()));
        return String.join("", message, LINE_SEPARATOR);
    }

    private String resolveWinSideMessage(Side side) {
        if (side.isBlack()) {
            return "검은색";
        }
        if (side.isWhite()) {
            return "흰색";
        }
        return "없음";
    }
}
