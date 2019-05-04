package com.emedclub.news.api;

import com.emedclub.news.entity.ResponseBody;
import com.emedclub.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/translate", method = RequestMethod.POST, produces = "application/json")
    public ResponseBody translate(@RequestBody com.emedclub.news.entity.News news) {
        com.emedclub.news.entity.News originalNews = newsService.findById(news.getId());
        originalNews.setChContent(news.getChContent());
        originalNews.setTranslated(true);
        boolean success = newsService.saveNews(originalNews);
        if (success) {
            return new ResponseBody(true, HttpStatus.OK);
        } else {
            return new ResponseBody(false, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
