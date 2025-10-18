package calculator.view;

/**
 * 계산된 결과를 화면(console)에 출력 역할을 담당하는 클래스
 */
public class OutputView {
    public static final String CALCULATED_RESULT = "결과 : ";

    /**
     * 계산된 결과를 출력
     *
     * @param number 계산된 결과
     */
    public void printResult(final int number) {
        System.out.println(CALCULATED_RESULT + number);
    }
}
