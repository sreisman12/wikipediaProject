package com.viome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WikiController {


    @RequestMapping(value = "/wikiPage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getWikiPageById(@PathVariable String id) {

        return new ResponseEntity<>("Fetching wiki page with id: " + id, HttpStatus.ACCEPTED);
    }


}
