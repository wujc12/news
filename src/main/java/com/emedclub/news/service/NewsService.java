package com.emedclub.news.service;

import com.emedclub.news.entity.News;

import java.util.List;

public interface NewsService {
    public List<News> findByAgency(String agency);

    public List<News> findByTitle(String title);

    public List<News> findByDate(String date);

    public List<News> findAll();

    public News findById(String id);

    public List<News> findAllOrderByDate();
}
