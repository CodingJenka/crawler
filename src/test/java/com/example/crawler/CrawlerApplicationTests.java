package com.example.crawler;

import com.example.crawler.application.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlerApplicationTests {

  @Test
  void contextLoads() {
    MemberService.ofListingLanguages();
  }
}
