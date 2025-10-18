package calculator.model.strategy;

public class StringAddStrategy {
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CLEANED_STRING_START_INDEX = 5;
    private static final String NEGATIVE_ERROR = "음수가 포함된 잘못된 문자열입니다.";
    private static final String NUMERIC_DELIMITER_ERROR = "커스텀 구분자로 숫자는 사용 불가능합니다.";
}
