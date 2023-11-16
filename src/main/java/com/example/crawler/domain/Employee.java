package com.example.crawler.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;
import org.json.JSONObject;

@Data
public class Employee {

  @JsonProperty("login")
  private String name;

  public String getName() {
    return name;
  }

  public static Map<String, AtomicInteger> collectAndCount(final String languages,
      final Map<String, AtomicInteger> languageMap) {

    final JSONObject jsnobject = new JSONObject(languages);
    final List<String> languageList = new ArrayList<>(jsnobject.keySet());

    for (final String lang : languageList) {
      if (Objects.isNull(languageMap.get(lang))) {
        languageMap.put(lang, new AtomicInteger(0));
      }
      languageMap.get(lang).getAndIncrement();
    }
    return languageMap;
  }

  @Data
  public static class Repos {

    private String name;

    public String getName() {
      return name;
    }
  }
}
