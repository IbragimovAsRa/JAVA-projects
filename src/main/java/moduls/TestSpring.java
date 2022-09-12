package moduls;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
             TestBean testBean = context.getBean("testBean", TestBean.class);
             System.out.print(testBean.getName());
             context.close();
    }
}
