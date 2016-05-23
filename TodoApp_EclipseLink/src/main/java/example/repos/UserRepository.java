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
import main.java.example.model.UserToTodoDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "select todo from User user inner join user.todoList as todo where todo.summary =:summary")
  List<Todo> findByTodoSummary(@Param("summary") String summary);

  User findUserByName(String name);

  /**
   *
   * @return  all users details in a list of UserToTodoDesc
   * @see UserToTodoDesc
   * @see <a href="http://google.com">http://docs.oracle.com/javaee/7/api/javax/persistence/SqlResultSetMapping.html</a>
   * @see <a href="http://google.com">https://eclipse.org/eclipselink/api/2.1/javax/persistence/SqlResultSetMapping.html</a>
   */
  //this is an example of using SqlResultSetMapping a JPA 2.1 feature
  @Query(name = "userTodoDetailQuery", nativeQuery = true)
  List<UserToTodoDesc> findUserTodos();


}
