package com.javacourse2018.Controller;

import com.javacourse2018.Entity.Status;
import org.junit.Assert;
import org.junit.Test;


public class ApplicationControllerTest {
  @Test
  public void print() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.print());
  }

  @Test
  public void add() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.add("list 1"));
  }

  @Test
  public void addDeal() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.addDeal("list 1", "deal 1"));

  }

  @Test
  public void printListTitles() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.printListTitles());
  }



  @Test
  public void printList() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.printList("list 1"));
  }


  @Test
  public void updateDeal() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.updateDeal("list 1","deal 1", "deal 2", Status.DONE));
  }


  @Test
  public void removeDeal() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.removeDeal("list 1", "deal 1"));
  }



  @Test
  public void remove() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.remove("list 1"));
  }

  @Test
  public void save() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.save("test.json"));
  }

  @Test
  public void load() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.load("test.json"));
  }

  @Test
  public void printManual() {
    ApplicationController applicationController = new ApplicationController();
    Assert.assertTrue(applicationController.printManual());
  }
}