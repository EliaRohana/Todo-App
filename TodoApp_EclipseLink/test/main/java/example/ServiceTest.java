package main.java.example;

import main.java.example.services.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ServiceTest {

  @Autowired
  Service service;

  @Test
  public void testGetTodoList() throws Exception {
    assertNotNull(service.getTodoList());

  }

  @Test
  public void testSave() throws Exception {

  }

  @Test
  public void testSave1() throws Exception {

  }
}