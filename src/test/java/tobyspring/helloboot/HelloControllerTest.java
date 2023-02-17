package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

    @Test
    public void helloController() throws Exception {
        //given
        HelloController helloController = new HelloController(name -> name);

        //when
        String ret = helloController.hello("Test");

        //then
        assertThat(ret).isEqualTo("Test");
    }

    @Test
    public void failsHelloController() throws Exception {
        //given
        HelloController helloController = new HelloController(name -> name);
        //when
        //then

        assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
