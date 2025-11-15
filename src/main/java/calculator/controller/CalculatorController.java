package calculator.controller;

import calculator.model.core.StringCalculator;
import calculator.model.factory.Factory;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 계산기의 실행 흐름을 제어하는 컨트롤러 클래스이다.
 *
 * @param factory    객체 생성 담당 클래스
 * @param inputView  사용자 입력 담당 클래스
 * @param outputView 화면 출력 담당 클래스
 */
public record CalculatorController(Factory factory, InputView inputView, OutputView outputView) {
    /**
     * 계산기의 실행 흐름이 시작된다.
     * <p>
     * 사용자 입력 -> 계산 -> 화면 출력
     */
    public void execute() {
        StringCalculator stringCalculator = factory.create();
        String stringInput = this.inputView.getUserInput();
        this.outputView.printResult(stringCalculator.execute(stringInput));
    }
}
