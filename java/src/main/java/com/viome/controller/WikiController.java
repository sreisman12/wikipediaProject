package com.viome.controller;

import com.viome.dao.IWikiDAO;
import com.viome.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class WikiController {

    @Autowired
    IWikiDAO wikiDao;

    @RequestMapping(value = "/wikiPage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getWikiPageById(@PathVariable String id) throws SQLException {
        Resource resource = (Resource) wikiDao.getResourceById(id);
        return new ResponseEntity<>("Fetching wiki page with id: " + id, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/wikiPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getResources(@RequestParam Map<String, String> searchParams) throws SQLException {
        Resource resource = (Resource) wikiDao.getResources(searchParams);
        return new ResponseEntity<>("Fetching wiki page with id: ",  HttpStatus.ACCEPTED);
    }


}
