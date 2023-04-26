package com.homubee.jwebcrawler.crawl.controller;

import com.homubee.jwebcrawler.crawl.domain.dto.SimpleCrawlRequestDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/crawl")
public class CrawlController {
    @GetMapping("")
    public String test() {
        return "test";
    }

    @PostMapping("/jsoup")
    public String test2(@RequestBody SimpleCrawlRequestDTO crawlRequestDTO) {
        System.out.println("HI : " + crawlRequestDTO.getUrl());
        Document document;
        String result = "";
        try {
            document = Jsoup.connect(crawlRequestDTO.getUrl()).get();
            result = document.title() + " : " + document.text();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
