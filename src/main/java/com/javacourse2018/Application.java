package com.javacourse2018;

import com.javacourse2018.Controller.ApplicationController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
  public static void main(String[] args) throws IOException {
    ApplicationController applicationController = new ApplicationController();
    applicationController.printManual();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String commandLine;
    while ((commandLine = br.readLine()) != null) {
      try {
        applicationController.nextCommand(commandLine);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    }

  }
}
