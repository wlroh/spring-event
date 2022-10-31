package kitckenpos.members.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class AgeTest {

    @DisplayName("나이를 등록한다.")
    @Nested
    class CreateTest {

        @DisplayName("성공")
        @Test
        void success() {
            final Age age = new Age(1);

            assertAll(
                    () -> assertThat(age).isEqualTo(new Age(1)),
                    () -> assertThat(age.toInt()).isEqualTo(1)
            );
        }

        @DisplayName("나이는 양수만 가능하다.")
        @ParameterizedTest(name = "age={0}")
        @ValueSource(ints = {-1, 0})
        void error(final int value) {
            assertThatThrownBy(() -> new Age(value)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
