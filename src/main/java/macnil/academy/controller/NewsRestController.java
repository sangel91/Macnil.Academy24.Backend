package macnil.academy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import macnil.academy.model.News;
import macnil.academy.repository.NewsRepository;
import macnil.academy.service.NewsService;
// @RequestMapping("/api/v1/broadcasts")
@CrossOrigin
@RestController
@RequestMapping("/api/v1/news")
public class NewsRestController {


    @Autowired
    NewsRepository newsRepository;

    @Autowired 
    NewsService newsService;


    // @GetMapping
    // public List <News> getAllNews(){

    //     return newsRepository.findAll();   
    // }

    @GetMapping
    public List <News> readAll(Integer numero){

        List <News> news = newsService.readAll(numero);

        return news;

    }

    // @GetMapping("{id}")
    // public News getNews(@PathVariable("id") Long id){

    //     Optional <News> optNews = newsRepository.findById(id);

    //     if (optNews.isPresent()) {
    //          return optNews.get();
    //     }else{
    // //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "News non presente");
    // //     }
       
    // }

    @GetMapping ("value = /{newsId}")
    public News read(@PathVariable ("id") Long id){
         News news = newsService.read(id);
         return news;
    }


    }

    

