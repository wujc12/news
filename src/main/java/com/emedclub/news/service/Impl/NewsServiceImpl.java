package com.emedclub.news.service.Impl;

import com.emedclub.news.dao.NewsDao;
import com.emedclub.news.entity.News;
import com.emedclub.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> findByAgency(String agency) {
        return newsDao.findByAgency(agency);
    }

    @Override
    public List<News> findByTitle(String title) {
        return newsDao.findByTitle(title);
    }

    @Override
    public List<News> findByDate(String date) {
        return newsDao.findByDate(date);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public News findById(String id){
        return newsDao.findById(id).orElse(new News());
    }

    @Override
    public List<News> findAllOrderByDate() {
        return newsDao.findAll(Sort.by("date").descending());
    }
}
