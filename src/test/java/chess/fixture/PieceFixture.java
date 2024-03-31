package chess.fixture;

import chess.domain.piece.Bishop;
import chess.domain.piece.BlackPawn;
import chess.domain.piece.Empty;
import chess.domain.piece.King;
import chess.domain.piece.Knight;
import chess.domain.piece.Queen;
import chess.domain.piece.Rook;
import chess.domain.piece.Side;
import chess.domain.piece.WhitePawn;

public class PieceFixture {

    public static final Rook BLACK_ROOK = new Rook(Side.BLACK);
    public static final Knight BLACK_KNIGHT = new Knight(Side.BLACK);
    public static final Bishop BLACK_BISHOP = new Bishop(Side.BLACK);
    public static final Queen BLACK_QUEEN = new Queen(Side.BLACK);
    public static final King BLACK_KING = new King(Side.BLACK);
    public static final BlackPawn BLACK_PAWN = new BlackPawn();

    public static final Rook WHITE_ROOK = new Rook(Side.WHITE);
    public static final Knight WHITE_KNIGHT = new Knight(Side.WHITE);
    public static final Bishop WHITE_BISHOP = new Bishop(Side.WHITE);
    public static final Queen WHITE_QUEEN = new Queen(Side.WHITE);
    public static final King WHITE_KING = new King(Side.WHITE);
    public static final WhitePawn WHITE_PAWN = new WhitePawn();

    public static final Empty EMPTY = Empty.instance();

}
