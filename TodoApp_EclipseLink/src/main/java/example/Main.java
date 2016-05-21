package main.java.example;

import main.java.example.model.Todo;
import main.java.example.services.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.NamingException;
import java.util.List;


//JPA tutorial using Spring Data
public class Main {

  public static void main(String[] args) throws NamingException {
    //option 1 : create spring context using Class annotations
//      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//      context.register(AppConfig.class);
//      context.refresh();


    //option2: create spring context using xml file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Service service = (Service) context.getBean("service");
//


    service.createDummyData();

    List<Todo> todoList = service.getTodoList();
    for (Todo td : todoList) {
      System.out.println(td);
//        System.out.println(todo.getUser());
    }
    System.out.println("Size: " + todoList.size());
    }

}