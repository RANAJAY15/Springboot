package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) context.getBean("st");
        s.internshipProgram();
        SpringBoot f =(SpringBoot) context.getBean("fun");
        f.hello("hello");
        System.out.println("Student: " + s);
    }
}
