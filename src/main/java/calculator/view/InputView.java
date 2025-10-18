package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DEFAULT_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 문자열 입력 받는다.
     */
    public String getUserInput() {
        System.out.println(DEFAULT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
