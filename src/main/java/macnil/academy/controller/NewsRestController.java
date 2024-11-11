package macnil.academy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import macnil.academy.model.News;
import macnil.academy.repository.NewsRepository;
import macnil.academy.service.NewsService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/news")
public class NewsRestController {


    @Autowired
    NewsRepository newsRepository;

    @Autowired 
    NewsService newsService;


   

    @GetMapping (value = "/{newsId}")
    public News read(@PathVariable ("id") Long id){
         News news = newsService.read(id);
         return news;
    }


    

    @GetMapping("tenants/{tenantId}")
    public  List <News> readAll( @PathVariable ("tenantId") Long tenantId ){  //@RequestBody  //  required = false,@RequestParam( name="tenantId") 
      
        List <News> news = newsService.readAll(tenantId);

        return news;

    }

        @GetMapping
        public @ResponseBody List<News> getAllNews() {

        return newsRepository.findAll();

    }

}