package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 올바른_기본_구분자는_통과한다() {
        assertSimpleTest(() -> {
            run("3,5:9,");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 잘못된_구분자가_포함되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3[4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자없이_구분자만_입력되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,;[]"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자자_숫자면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//9\\n29893"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_잘못된_형식이면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:2:3:4:5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
