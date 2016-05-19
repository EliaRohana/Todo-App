package main.java.example;

import main.java.example.model.Todo;
import main.java.example.model.User;
import main.java.example.services.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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


      Todo todo = new Todo();
      User user = new User();
      user.setName("elia");
      todo.setUser(user);
      user.addTodo(todo);


      todo.setUser(user);
      todo.setSummary("This is a test");
      todo.setDescription("This is a test");
//
      service.save(todo);

    List<Todo> todoList = service.getTodoList();
    for (Todo td : todoList) {
      System.out.println(td);
//        System.out.println(todo.getUser());
    }
    System.out.println("Size: " + todoList.size());
    }

}