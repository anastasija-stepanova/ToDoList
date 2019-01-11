package com.javacourse2018;

import com.javacourse2018.Controller.ApplicationController;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    ApplicationController applicationController = new ApplicationController();
    applicationController.printManual();
    applicationController.process(System.in);
  }
}
