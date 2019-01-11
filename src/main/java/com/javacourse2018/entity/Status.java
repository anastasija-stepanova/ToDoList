package com.javacourse2018.entity;

import java.util.HashMap;
import java.util.Map;

public enum Status {
  DONE("done"),
  CANCEL("cancel"),
  IN_PROGRESS("in_progress");

  private final String name;

  Status(final String name) {
    this.name = name;
  }

  private static Map<String, Status> getStatusName() {
    HashMap<String, Status> stringToStatus = new HashMap<>();
    stringToStatus.put(DONE.name, DONE);
    stringToStatus.put(CANCEL.name, CANCEL);
    stringToStatus.put(IN_PROGRESS.name, IN_PROGRESS);
    return stringToStatus;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public static Status fromString(String status) {
    return getStatusName().get(status);
  }

}
