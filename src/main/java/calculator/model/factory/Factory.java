package calculator.model.factory;

import calculator.model.core.StringCalculator;

/**
 * {@link StringCalculator} 객체를 생성하는 팩토리 클래스이다.
 * <p>
 * 확장 가능한 클래스에 대해서 객체 생성을 위임한다.
 * (계산기는 현재 문자열 계산기만 있지만, 추후 불리언 계산기, 비트 계산기 등의
 * 확장이 가능하기 때문이다.)
 */
public class Factory {
    /**
     * {@link StringCalculator} 객체를 생성한다.
     *
     * @return 객체 생성 결과
     */
    public StringCalculator create() {
        return new StringCalculator();
    }
}
