package main.java.example.repos;

import main.java.example.AppConfig;
import main.java.example.model.Todo;
import main.java.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void testFindByTodoSummary() throws Exception {
    List<Todo> byTodoSummary = userRepository.findByTodoSummary("This is a test");
    assertNotNull(byTodoSummary);
    assertTrue(byTodoSummary.size() > 1 );

  }

  @Test
  public void testFindByName() throws Exception {
    User user = userRepository.findUserByName("elia");
    assertNotNull(user);

  }

}