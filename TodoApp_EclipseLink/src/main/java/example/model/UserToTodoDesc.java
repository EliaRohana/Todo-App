/*
 *  Copyright 2016 ADVA Optical Networking SE. All rights reserved.
 *
 *  Owner: erohana
 *
 *  $Id: $
 */
package main.java.example.model;

public class UserToTodoDesc {

  private String userName;
  private String todoDesc;
  private String todoSummary;

  public UserToTodoDesc(String userName, String todoDesc, String todoSummary) {
    this.userName = userName;
    this.todoDesc = todoDesc;
    this.todoSummary = todoSummary;
  }

  public String getUserName() {
    return userName;
  }

  public String getTodoDesc() {
    return todoDesc;
  }

  public String getTodoSummary() {
    return todoSummary;
  }
}
