package wafflejuice.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.xmlunit.validation.ValidationProblem;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototyopeBean.class);
        System.out.println("find prototypeBean1");
        PrototyopeBean prototypeBean1 = ac.getBean(PrototyopeBean.class);
        System.out.println("find prototypeBean2");
        PrototyopeBean prototypeBean2 = ac.getBean(PrototyopeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototyopeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototyopeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototyopeBean.destroy");
        }
    }

}
