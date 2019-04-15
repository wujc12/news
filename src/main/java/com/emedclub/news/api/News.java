package com.emedclub.news.api;

import com.emedclub.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class News {

    @Autowired
    NewsService newsService;

    @RequestMapping("/first20news")
    public List<com.emedclub.news.entity.News> first20News() {
        return newsService.findAllOrderByDate().subList(2, 22);
    }

    @RequestMapping("/next20news/{index}")
    public List<com.emedclub.news.entity.News> allNews(@PathVariable("index") int index) {
        return newsService.findAllOrderByDate().subList(22 * index, 20 * index + 22);
    }

    @RequestMapping("/agency/{agency}")
    public List<com.emedclub.news.entity.News> newsAgency(@PathVariable("agency") String agency) {
        return newsService.findByAgency(agency);
    }

    @RequestMapping("/date/{date}")
    public List<com.emedclub.news.entity.News> newsDate(@PathVariable("date") String date) {
        return newsService.findByDate(date);
    }

    @RequestMapping("/id/{id}")
    public com.emedclub.news.entity.News newsId(@PathVariable("id") String id) {
        return newsService.findById(id);
    }
}
