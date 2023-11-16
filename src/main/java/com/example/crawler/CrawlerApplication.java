package com.example.crawler;

import com.example.crawler.application.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrawlerApplication.class, args);
    MemberService.ofListingLanguages();
  }
}
