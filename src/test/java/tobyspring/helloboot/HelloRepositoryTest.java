package tobyspring.helloboot;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void findHelloFailed() throws Exception {
        //given

        //when

        //then

        assertThat(helloRepository.findHello("Toby")).isNull();
    }

    @Test
    public void increaseCount() throws Exception {
        //given
        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);


        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
        //when

        //then

    }
}
