package domain;

import fixture.PositionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    private static Stream<Arguments> rooks() {
        return Stream.of(
                Arguments.arguments(File.B, Rank.FOUR),
                Arguments.arguments(File.F, Rank.FOUR),
                Arguments.arguments(File.D, Rank.TWO),
                Arguments.arguments(File.D, Rank.SIX)
        );
    }

    @DisplayName("룩은 수직 또는 수평 방향으로 임의의 칸 수만큼 움직인다.")
    @ParameterizedTest
    @MethodSource("rooks")
    void canMoveTest(File targetFile, Rank targetRank) {
        Rook rook = new Rook(Side.BLACK);

        Position current = PositionFixture.d4();
        Position target = new Position(targetFile, targetRank);

        boolean actual = rook.canMove(current, target);

        assertThat(actual).isTrue();
    }
}
