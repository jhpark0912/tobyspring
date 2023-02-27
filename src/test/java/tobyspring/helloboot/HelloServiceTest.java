package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {
}


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HelloServiceTest {
    @UnitTest
    void simpleHelloService () {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    public void helloDecorator() throws Exception {
        //given
        HelloDecorator decorator = new HelloDecorator(name -> name);
        //when
        String ret = decorator.sayHello("Test");
        //then
        assertThat(ret).isEqualTo("*Test*");

    }

}