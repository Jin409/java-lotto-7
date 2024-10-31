package lotto.model;

import static lotto.model.ErrorMessages.Lotto.DUPLICATED;
import static lotto.model.ErrorMessages.Lotto.INVALID_RANGE;
import static lotto.model.ErrorMessages.Lotto.INVALID_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final int VALID_SIZE = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        numbers.forEach(LottoValidator::validateRange);
        validateNoDuplicate(numbers);
    }

    private static void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private static void validateRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            System.out.println("number = " + number);
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != VALID_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }
}