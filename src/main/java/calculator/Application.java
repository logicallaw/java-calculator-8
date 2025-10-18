package calculator;

import calculator.controller.CalculatorController;
import calculator.model.factory.Factory;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Factory factory = new Factory();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(factory, inputView, outputView);
        calculatorController.execute();
    }
}