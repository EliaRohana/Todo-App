/*
 *  Copyright 2016 ADVA Optical Networking SE. All rights reserved.
 *
 *  Owner: erohana
 *
 *  $Id: $
 */
package main.java.example.repos;

import main.java.example.model.Todo;
import main.java.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "select todo from User user inner join user.todoList as todo where todo.summary =:summary")
  List<Todo> findByTodoSummary(@Param("summary") String summary);

  User findUserByName(String name);


}
