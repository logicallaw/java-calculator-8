package calculator.model.core;

import calculator.model.strategy.StringAddStrategy;

/**
 * 계산기의 기본 동작을 정의하는 추상 클래스
 */
abstract class BaseCalculator {
    protected static final String CUSTOM_DELIMITER_FIRST = "//";
    protected static final String CUSTOM_DELIMITER_SECOND = "\\n";
    protected static final int INITIAL_SUM = 0;

    protected StringAddStrategy stringAddStrategy;

    /**
     * 문자열 덧셈 결과를 반환한다.
     *
     * @param userInput 사용자에게 입력 받은 문자열
     * @return 문자열에 대한 덧셈 결과
     */
    public abstract int execute(final String userInput);
}
