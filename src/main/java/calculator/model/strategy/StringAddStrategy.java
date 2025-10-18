package calculator.model.strategy;

public class StringAddStrategy {
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CLEANED_STRING_START_INDEX = 5;
    private static final String NEGATIVE_ERROR = "음수가 포함된 잘못된 문자열입니다.";
    private static final String NUMERIC_DELIMITER_ERROR = "커스텀 구분자로 숫자는 사용 불가능합니다.";

    /**
     * 문자열 배열을 순회하면서 양수들의 합을 반환한다.
     *
     * @param numbers 순회할 문자열 배열
     * @return 양수들의 합 (덧셈 결과)
     * @throws IllegalArgumentException 음수가 포함된 문자열인 경우, 에러를 발생
     */
    private int addStringNumbers(final String[] numbers) throws IllegalArgumentException {
        int result = 0;

        for (String number : numbers) {
            int integerNumber = Integer.parseInt(number);

            // 문제의 기능 요구 사항에 따라서 음수는 잘못된 값임
            if (integerNumber < 0) throw new IllegalArgumentException(NEGATIVE_ERROR);

            result += Integer.parseInt(number);
        }

        return result;
    }
}
