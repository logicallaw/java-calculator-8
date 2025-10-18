package calculator.model.core;

public class StringCalculator extends BaseCalculator {
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "잘못된 입력입니다.";

    private static boolean isEmptyString(String userInput) {
        return userInput.isEmpty();
    }

    private static boolean isDefaultDelimiter(String userInput) {
        return !userInput.contains(CUSTOM_DELIMITER);
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.contains(CUSTOM_DELIMITER);
    }

    @Override
    public int execute(final String userInput) throws IllegalArgumentException {
        return 0;
    }
}