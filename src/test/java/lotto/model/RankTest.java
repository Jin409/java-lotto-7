package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("조건에 따라 적절한 순위 객체가 반환된다.")
    void returnRightRankAccordingToConditions() {
        // given
        int matchingCount = 5;
        boolean bonusNumberMatched = true;

        // when
        Rank rank = Rank.findRank(matchingCount, bonusNumberMatched);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("아무 조건에도 부합하지 않는 경우 DEFAULT 를 반환한다.")
    void returnDefaultWhenNoRankConditionsMet() {
        // given
        int matchingCount = 0;
        boolean bonusNumberMatched = false;

        // when
        Rank rank = Rank.findRank(matchingCount, bonusNumberMatched);

        // then
        assertThat(rank).isEqualTo(Rank.DEFAULT);
    }
}
