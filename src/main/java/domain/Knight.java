package domain;

import domain.piece.Piece;
import java.util.Map;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public boolean isKnight() {
        return true;
    }

    @Override
    public boolean hasFollowedRule(Position current, Position target, MovePath movePath) {
        return false;
    }

//    @Override
//    public boolean isRuleBroken(Position current, Position target, Map<Position, Piece> pieces) {
//        checkBlockingPiece(target, pieces);
//        return (current.hasTwoFileGap(target) && current.hasOneRankGap(target)) ||
//                (current.hasOneFileGap(target) && current.hasTwoRankGap(target));
//    }
}
