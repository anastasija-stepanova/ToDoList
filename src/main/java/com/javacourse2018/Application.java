package com.javacourse2018;

import com.javacourse2018.controller.ApplicationController;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    ApplicationController applicationController = new ApplicationController();
    applicationController.process(System.in);
  }
}
