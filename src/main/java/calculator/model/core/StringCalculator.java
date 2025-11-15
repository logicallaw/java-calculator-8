package calculator.model.core;

import calculator.model.strategy.StringCalculation;

/**
 * 문자열 입력을 분석하여 적절한 덧셈 전략을 선택하고 계산하는 클래스이다.
 */
public class StringCalculator extends BaseCalculator {
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "잘못된 입력입니다.";

    private static boolean isEmptyString(String userInput) {
        return userInput.isEmpty();
    }

    private static boolean isDefaultDelimiter(String userInput) {
        return !userInput.contains(CUSTOM_DELIMITER_FIRST);
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.contains(CUSTOM_DELIMITER_FIRST) && userInput.contains(CUSTOM_DELIMITER_SECOND);
    }

    /**
     * 기본 생성자를 정의한다.
     */
    public StringCalculator() {
        this.setCalculation(new StringCalculation());
    }

    /**
     * 사용자 입력 문자열을 해석하여 덧셈 결과를 반환한다.
     *
     * @param userInput 사용자 입력 문자열
     * @return 계산된 합계
     * @throws IllegalArgumentException 잘못된 입력 형식일 경우
     */
    @Override
    public int execute(final String userInput) throws IllegalArgumentException {
        if (isEmptyString(userInput)) {
            return INITIAL_SUM;
        }

        if (isDefaultDelimiter(userInput)) {
            return this.calculation.executeDefaultAddition(userInput);
        }

        if (isCustomDelimiter(userInput)) {
            return this.calculation.executeCustomAddition(userInput);
        }

        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE + userInput);
    }
}