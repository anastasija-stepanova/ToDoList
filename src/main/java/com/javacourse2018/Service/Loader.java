package com.javacourse2018.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacourse2018.Entity.DealList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Loader implements LoaderInterface {

  public void save(String path, List<DealList> dealLists) {
    //into json file

    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.writeValue(new File(path), dealLists);
    } catch (IOException ex) {
      System.out.println("Error while writing file");
    }

    System.out.println("file created!");
  }

  public void load(String path, List<DealList> dealLists) {
    //from json file


  }
}
