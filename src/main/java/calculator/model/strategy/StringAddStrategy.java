package calculator.model.strategy;

/**
 * 구분자와 양수가 포함된 문자열을 덧셈 가능한 숫자로 변환하고 합계를 계산하는 전략 클래스이다.
 * <p>
 * 기본 구분자(',', ':') 또는 커스텀 구분자(e.g, "//;\n")를 포함한 문자열 입력을 파싱하여
 * 각 숫자의 합을 반환한다.
 * <p>
 * 음수가 포함된 입력은 {@link IllegalArgumentException}을 발생시킨다.
 */
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
            if (number.isEmpty()) continue;

            int integerNumber = Integer.parseInt(number);

            // 문제의 기능 요구 사항에 따라서 음수는 잘못된 값임
            if (integerNumber < 0) throw new IllegalArgumentException(NEGATIVE_ERROR);

            result += integerNumber;
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

    /**
     * 커스텀 구분자를 포함하는 입력 문자열을 덧셈한 결과를 반환한다.
     *
     * @param userInput 커스텀 구분자를 포함하는 입력 문자열
     * @return 해당 문자열의 덧셈 결과
     */
    public int executeCustomAddition(final String userInput) {
        // 커스텀 구분자의 문자를 저장
        char customDelimiterChar = userInput.charAt(CUSTOM_DELIMITER_INDEX);

        if (Character.isDigit(customDelimiterChar)) {
            throw new IllegalArgumentException(NUMERIC_DELIMITER_ERROR);
        }

        // splitStrings 함수의 입력을 위해, char에서 String으로 형변환
        String customDelimiterString = String.valueOf(customDelimiterChar);

        // 커스텀 구분자 접두어를 제거하여 전처리된 문자열을 저장
        String cleanedUserInput = userInput.substring(CLEANED_STRING_START_INDEX);

        String[] numbers = splitStrings(cleanedUserInput, customDelimiterString);

        return addStringNumbers(numbers);
    }
}
