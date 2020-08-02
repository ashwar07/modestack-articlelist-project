package com.example.articleproject.rest;


import com.example.articleproject.service.ArticleService;
import com.example.articleproject.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createArticle(@RequestBody ArticleVO articleVO) throws Exception {
        String respString = articleService.createArticle(articleVO);
        ResponseEntity<String> resp = null;
        if(!respString.equals("")) {
        	resp = new ResponseEntity<>(respString, HttpStatus.CREATED);
        }else {
        	respString = "Invalid access token";
        	resp = new ResponseEntity<>(respString, HttpStatus.EXPECTATION_FAILED);
        }
        
        return resp;
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<ArticleVO>> listArticles() throws Exception {
        List<ArticleVO> articles = articleService.listArticles();
        ResponseEntity<List<ArticleVO>> resp = new ResponseEntity<>(articles, HttpStatus.OK);
        return resp;
    }


}
