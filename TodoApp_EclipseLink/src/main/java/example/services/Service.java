/*
 *  Copyright 2016 ADVA Optical Networking SE. All rights reserved.
 *
 *  Owner: erohana
 *
 *  $Id: $
 */
package main.java.example.services;

import main.java.example.model.Todo;
import main.java.example.model.User;
import main.java.example.repos.TodoRepository;
import main.java.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service(value = "service")
public class Service {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Todo> getTodoList(){
    ArrayList<Todo> todos = new ArrayList<>();
    todoRepository.findAll().iterator().forEachRemaining(todo->todos.add(todo));
    return todos;
  }

  public void save(Todo todo){
    todoRepository.save(todo);
  }

  public void save(User user){
    userRepository.save(user);
  }
}
