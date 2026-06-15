package org.example;

import org.example.config.AppConfig;
import org.example.service.ArticleService;
import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.example.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 260615 2장 스프링 IoC/DI 실습
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // *********************************
        // 기존 전통적인 객체 생성 방식
        // *********************************
        Hello hello = new Hello();
        hello.show();

        Welcome welcome = new Welcome();
        welcome.show();

        Greeting greeting = new Greeting();
        greeting.show();

        // *********************************
        // IoC/DI 방식 (제어의 역전)
        // *********************************

        // 스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 주입하기
        Hello helloBean = context.getBean(Hello.class);
        helloBean.show();

        Welcome welcomeBean = (Welcome) context.getBean("w"); // 빈 name 값으로 가져오기
        welcomeBean.show();

        Greeting greetingBean = (Greeting) context.getBean("g");
        greetingBean.show();

        // *********************************
        // IoC/DI 종합실습
        // *********************************
        Computer dell = (Computer) context.getBean("dell");
        dell.show();

        // *********************************
        // AOP 실습
        // *********************************
        ArticleService service = context.getBean(ArticleService.class);

        System.out.println("----------------------------------");
        service.register();
        System.out.println("----------------------------------");

        System.out.println("----------------------------------");
        service.getArticleAll();
        System.out.println("----------------------------------");

        System.out.println("----------------------------------");
        service.getArticle(null);
        System.out.println("----------------------------------");
    }
}
