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

    public News read(Long id) throws NoSuchElementException {
        News news = newsRepository.findById(id).orElseThrow();
        return news;
    }


    public List<News> readAll1(Integer numero, Long tenantId) {
        List <News> news;
     
        if (tenantId != null) {
            news = newsRepository.findByTenantId(tenantId);
        } else {
            // throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "NEWS NON PRESENTI");
            news = newsRepository.findAll();
        }

        if (numero == null || numero < 1)
            return news;
        else {
            return news.stream().limit(numero).collect(Collectors.toList());
        }

    }

}
