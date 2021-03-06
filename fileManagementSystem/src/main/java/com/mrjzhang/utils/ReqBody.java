package com.mrjzhang.utils;

/**
 * Created by @author: mrjzhang on 2018/5/16
 */
public class ReqBody {
  private int page;
  private int limit;
  private Object generateStatus;
  // 分数的状态，用于筛选分数
  private Object scoreStatus;
  private String name;
  private String start_time;
  private String end_time;
  private String score_order;
  private String create_time_order;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public String getStart_time() {
    return start_time;
  }

  public void setStart_time(String start_time) {
    this.start_time = start_time;
  }

  public String getEnd_time() {
    return end_time;
  }

  public void setEnd_time(String end_time) {
    this.end_time = end_time;
  }

  public String getScore_order() {
    return score_order;
  }

  public void setScore_order(String score_order) {
    this.score_order = score_order;
  }

  public String getCreate_time_order() {
    return create_time_order;
  }

  public void setCreate_time_order(String create_time_order) {
    this.create_time_order = create_time_order;
  }

  public Object getGenerateStatus() {
    return generateStatus;
  }

  public void setGenerateStatus(Object generateStatus) {
    this.generateStatus = generateStatus;
  }

  public Object getScoreStatus() {
    return scoreStatus;
  }

  public void setScoreStatus(Object scoreStatus) {
    this.scoreStatus = scoreStatus;
  }
}

