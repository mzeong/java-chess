package chess.domain.position;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("가장 높은 순서 값을 찾는다.")
    @Test
    void maxTest() {
        assertThat(Rank.max()).isEqualTo(8);
    }

    @DisplayName("source order가 작을 때 source 위치와 target 위치 사이의 Rank 리스트를 찾는다.")
    @Test
    void findBetweenAscTest() {
        Rank sourceRank = Rank.ONE;
        Rank targetRank = Rank.FOUR;

        List<Rank> ranks = sourceRank.findBetween(targetRank);

        assertThat(ranks).containsExactly(Rank.TWO, Rank.THREE);
    }

    @DisplayName("source order가 클 때 source 위치와 target 위치 사이의 Rank 리스트를 찾는다.")
    @Test
    void findBetweenDescTest() {
        Rank sourceRank = Rank.FOUR;
        Rank targetRank = Rank.ONE;

        List<Rank> ranks = sourceRank.findBetween(targetRank);

        assertThat(ranks).containsExactly(Rank.THREE, Rank.TWO);
    }
}
