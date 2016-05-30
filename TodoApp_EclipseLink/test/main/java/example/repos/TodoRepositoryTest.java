package main.java.example.repos;

import main.java.example.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class TodoRepositoryTest {

  @Autowired
  TodoRepository todoRepository;

  @Test
  public void testFindByDescription() throws Exception {
    todoRepository.findByDescription("desc");

  }

  @Test
  public void testFindByUser_Id() throws Exception {
    todoRepository.findByUser_Id(5);
  }
}