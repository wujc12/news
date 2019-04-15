package com.emedclub.news.dao;

import com.emedclub.news.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsDao extends MongoRepository<News, String> {
    List<News> findByAgency(String agency);

    List<News> findByTitle(String title);

    List<News> findByDate(String date);

    List<News> findAllOrderByDate();
}
