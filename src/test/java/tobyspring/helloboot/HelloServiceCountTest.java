package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    public void sayHelloIncreaseCount() throws Exception {
        //given
        IntStream.rangeClosed(1, 10).forEach( count -> {
            helloService.sayHello("Toby");
            //when

            //then
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
        });

    }
}
