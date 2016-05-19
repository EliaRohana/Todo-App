package main.java.example;

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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        ServiceTest.class})
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ServiceTest extends AbstractTestExecutionListener {

  @Autowired
  Service service;


  @Override
  public void beforeTestClass(TestContext testContext) {
    Service service = (Service) testContext.getApplicationContext().getBean("service");
    service.createDummyData();
  }

//  @Override
//  public void afterTestClass(TestContext testContext) {
//  }

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