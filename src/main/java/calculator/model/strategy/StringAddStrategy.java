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

    /**
     * 입력 문자열을 구분자로 나누어 문자열 배열을 반환한다.
     *
     * @param inputString 입력 문자열
     * @param delimiter   구분자
     * @return 문자열 배열
     */
    private String[] splitStrings(final String inputString, final String delimiter) {
        return inputString.split(delimiter);
    }

    /**
     * 기본 구분자를 포함하는 입력 문자열을 덧셈한 결과를 반환한다.
     *
     * @param userInput 기본 구분자를 포함하는 입력 문자열
     * @return 해당 문자열의 덧셈 결과
     */
    public int executeDefaultAddition(final String userInput) {
        String[] numbers = userInput.split(DEFAULT_DELIMITER_PATTERN);

        return addStringNumbers(numbers);
    }
}
