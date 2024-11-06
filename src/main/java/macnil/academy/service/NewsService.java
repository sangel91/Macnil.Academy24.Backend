package macnil.academy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import macnil.academy.model.News;
import macnil.academy.repository.NewsRepository;

@Service
public class NewsService {
    

     @Autowired
     NewsRepository newsRepository;


    public News read(Long id) throws NoSuchElementException{
        News news = newsRepository.findById(id).orElseThrow();
        return news;
    }

       public List<News> readAll(Integer numero) {
        List<News> news = newsRepository.findAll();
            if(numero==null || numero<1)
            return news;
        else {
            return news.stream().limit(numero).collect(Collectors.toList());
        }
       
    }



}
