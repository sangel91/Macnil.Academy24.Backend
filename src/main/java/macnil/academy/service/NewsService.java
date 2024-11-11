package macnil.academy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import macnil.academy.model.News;

import macnil.academy.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public News read(Long id) throws NoSuchElementException {
        News news = newsRepository.findById(id).orElseThrow();
        return news;
    }


    public List<News> readAll(Long tenantId) {
        List <News> news;
     
        if (tenantId != null) {
            news = newsRepository.findByTenantId(tenantId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NEWS NON PRESENTI");
            
        }

         return news;

    }
  

}
