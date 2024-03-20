package domain;

import java.util.List;
import java.util.function.Function;

public enum InitPosition {

    ROOK(List.of(File.A, File.H), majorPieceVertical()),
    KNIGHT(List.of(File.B, File.G), majorPieceVertical()),
    BISHOP(List.of(File.C, File.F), majorPieceVertical()),
    QUEEN(List.of(File.D), majorPieceVertical()),
    KING(List.of(File.E), majorPieceVertical()),
    PAWN(List.of(File.values()), pawnVertical()),
    ;

    private final List<File> files;
    private final Function<Side, Rank> vertical;

    InitPosition(List<File> files, Function<Side, Rank> vertical) {
        this.files = files;
        this.vertical = vertical;
    }

    private static Function<Side, Rank> majorPieceVertical() {
        return side -> {
            if (side.isBlack()) {
                return Rank.EIGHT;
            }
            return Rank.ONE;
        };
    }

    private static Function<Side, Rank> pawnVertical() {
        return side -> {
            if (side.isBlack()) {
                return Rank.SEVEN;
            }
            return Rank.TWO;
        };
    }

    public Rank vertical(Side side) {
        return vertical.apply(side);
    }

    public List<File> getHorizontals() {
        return files;
    }
}