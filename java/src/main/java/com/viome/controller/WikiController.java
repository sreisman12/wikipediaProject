package com.viome.controller;

import com.viome.dao.IWikiDAO;
import com.viome.model.WikiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class WikiController {

    @Autowired
    IWikiDAO wikiDao;

    @RequestMapping(value = "/wikiPage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WikiPage> getWikiPageById(@PathVariable String id) throws SQLException {
        WikiPage wikiPage = wikiDao.getResourceById(id);
        return new ResponseEntity<>(wikiPage, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/wikiPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WikiPage>> getResources(@RequestParam Map<String, String> searchParams) throws SQLException {
        List<WikiPage> wikiPages = wikiDao.getResources(searchParams);
        wikiPages.forEach(page->{
            System.out.println(page.getTitle());
        });
        return new ResponseEntity<>(wikiPages,  HttpStatus.ACCEPTED);
    }


}
