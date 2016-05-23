package main.java.example.repos;

import main.java.example.AppConfig;
import main.java.example.model.Todo;
import main.java.example.model.User;
import main.java.example.model.UserToTodoDesc;
import main.java.example.services.Service;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        UserRepositoryTest.class})
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserRepositoryTest extends AbstractTestExecutionListener {

  @Autowired
  UserRepository userRepository;



  @Override
  public void beforeTestClass(TestContext testContext) {
    Service service = (Service) testContext.getApplicationContext().getBean("service");
    service.createDummyData();
  }

  @Test
  public void testFindByTodoSummary() throws Exception {
    List<Todo> byTodoSummary = userRepository.findByTodoSummary("This is a test");
    assertNotNull(byTodoSummary);
    assertTrue(byTodoSummary.size() > 0 );

  }

  @Test
  public void testFindByName() throws Exception {
    User user = userRepository.findUserByName("elia");
    assertNotNull(user);
  }

  @Test
  public void testFindUserTodos() throws Exception {
    List<UserToTodoDesc> userTodos = userRepository.findUserTodos();
    userTodos.forEach(ut->assertTrue(ut.getUserName().equals("elia")));

  }
}