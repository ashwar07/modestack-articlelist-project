package com.example.articleproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.articleproject.model.Article;
import com.example.articleproject.model.ArticleRepository;
import com.example.articleproject.model.User;
import com.example.articleproject.model.UserRepository;
import com.example.articleproject.vo.ArticleVO;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    public String createArticle(ArticleVO articleVO) {
    	
    	User existingUser = userRepository.findByAccessToken(articleVO.getAccess_token());
    	if (null != existingUser) 
    	{
    		/*Retrieving date of registration */
    		
    		String existingDate = existingUser.getDate();
    		CurrentDateService cds = new CurrentDateService();
    		String currentdate = cds.currentDateString();
    		
    		if(cds.dateDiffrence(existingDate, currentdate))
    		{
    			
    			return "";
    		}
    		
            String nullcheck = convertArticleVOtoModel(articleVO);
            if(nullcheck.equals("Saved"))
            {
            	return "new article created";
            }
            else
            {
            	return "Null Value";
            }
    	}
    	else
    	{
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

    private String convertArticleVOtoModel(ArticleVO articleVO) {
        Article article = new Article();
        if(null != articleVO.getTitle() && null != articleVO.getAuthor() && null != articleVO.getBody() )
        {
	        article.setTitle(articleVO.getTitle());
	        article.setAuthor(articleVO.getAuthor());
	        article.setBody(articleVO.getBody());
	        articleRepository.save(article);
	        return "Saved";
        }
        else
        {
        	return "";
        }
        
    }


}
