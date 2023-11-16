package com.example.crawler.application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class FilePrinter {
  public static void printUsers(final String name, final Map<String, AtomicInteger> languageMap) {

    try {
      String filename = "Languages.txt";
      FileWriter fw = new FileWriter(filename, true);
      fw.write("\n" + name + "\n");

      for (String lang : languageMap.keySet()) {
        fw.write("      " + lang + " " + languageMap.get(lang) + "\n");
      }

      fw.close();
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }
}
