package com.example.crawler.application;

import static com.example.crawler.application.FilePrinter.printUsers;
import static com.example.crawler.domain.Employee.collectAndCount;

import com.example.crawler.domain.Employee;
import com.example.crawler.infrastructure.GitHubClient;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private static GitHubClient client = new GitHubClient();

  public static void ofListingLanguages() {
    final Employee[] members = client.callMembers();

    for (int i = 0; i < members.length; ++i) {
      final String name = members[i].getName();
      final Map<String, AtomicInteger> languageMap = collectLanguagesFor(name);
      printUsers(name, languageMap);
    }
  }

  private static Map<String, AtomicInteger> collectLanguagesFor(final String name) {
    final Employee.Repos[] repos = client.callReposFor(name);
    Map<String, AtomicInteger> languageMap = new HashMap<>();

    for (int j = 0; j < repos.length; ++j) {
      final String repo = repos[j].getName();
      final String languages = client.callLanguagesFor(name, repo);
      languageMap = collectAndCount(languages, languageMap);
    }
    return languageMap;
  }
}
