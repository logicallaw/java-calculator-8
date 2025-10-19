package calculator.model.strategy;

/**
 * 계산기의 기능을 담당하는 인터페이스 클래스이다.
 */
public interface Calculation {
    /**
     * 기본 계산기 동작을 담당한다.
     *
     * @param userInput 사용자의 입력
     * @return 덧셈 결과
     */
    int executeDefaultAddition(String userInput);

    /**
     * 커스텀 계산기 동작을 담당한다.
     *
     * @param userInput 사용자의 입력
     * @return 덧셈 결과
     */
    int executeCustomAddition(String userInput);
}
