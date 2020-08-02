package com.example.articleproject.service;

import com.example.articleproject.model.Article;
import com.example.articleproject.model.ArticleRepository;
import com.example.articleproject.model.User;
import com.example.articleproject.model.UserRepository;
import com.example.articleproject.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    public String createArticle(ArticleVO articleVO) {
    	
    	User existingUser = userRepository.findByAccessToken(articleVO.getAccess_token());
    	if (null != existingUser) {
            convertArticleVOtoModel(articleVO);
            return "new article created";
    	}else {
    		return "";
    	}

        
    	
    	
    }

    public List<ArticleVO> listArticles() {
        List<ArticleVO> resultList = new ArrayList<>();
        List<Article> articles = (List<Article>) articleRepository.findAll();
        resultList = convertModeltoVO(articles);
        return resultList;
    }

    private List<ArticleVO> convertModeltoVO(List<Article> articles) {
        List<ArticleVO> articleVOS = new ArrayList<>();
        for(Article article: articles){
            ArticleVO articleVO = new ArticleVO();
            articleVO.setAuthor(article.getAuthor());
            articleVO.setTitle(article.getTitle());
            articleVO.setBody(article.getBody());
            articleVOS.add(articleVO);
        }
        return articleVOS;
    }

    private void convertArticleVOtoModel(ArticleVO articleVO) {
        Article article = new Article();
        article.setTitle(articleVO.getTitle());
        article.setAuthor(articleVO.getAuthor());
        article.setBody(articleVO.getBody());
        articleRepository.save(article);
    }


}
