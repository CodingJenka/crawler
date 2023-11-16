package com.example.crawler.infrastructure;

import com.example.crawler.domain.Employee;
import org.springframework.stereotype.Component;

@Component
public class GitHubClient extends Client {

  @Override
  public Employee[] callMembers() {
    return client.get()
        .uri(MEMBERS_URI)
        .headers(AUTH_HEADER)
        .retrieve()
        .bodyToMono(Employee[].class).block();
  }

  @Override
  public Employee.Repos[] callReposFor(final String name) {
    return client.get().uri(String.format(REPO_URI, name))
        .headers(AUTH_HEADER)
        .retrieve()
        .bodyToMono(Employee.Repos[].class).block();

  }

  @Override
  public String callLanguagesFor(final String... data) {
    return client.get().uri(String.format(LANGUAGE_URI, data[0], data[1]))
        .headers(AUTH_HEADER)
        .retrieve()
        .bodyToMono(String.class).block();
  }
}