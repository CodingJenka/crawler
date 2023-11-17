package com.example.crawler.infrastructure;

import com.example.crawler.domain.Employee;
import java.util.function.Consumer;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class Client {

  protected static final String BASE_URL = "https://api.github.com";
  protected static final String MEMBERS_URI = "/orgs/codecentric/members";
  protected static final String REPO_URI = "/users/%s/repos";
  protected static final String LANGUAGE_URI = "/repos/%s/%s/languages";
  protected final Consumer<HttpHeaders> AUTH_HEADER = httpHeaders -> {
    httpHeaders.set("Authorization", "Bearer <token>");
  };

  protected final WebClient client = WebClient.builder()
      .baseUrl(BASE_URL)
      .build();

  public abstract Employee[] callMembers();

  public abstract Employee.Repos[] callReposFor(final String name);

  public abstract String callLanguagesFor(String... data);
}
