package com.coderbd.controller;

import com.coderbd.entity.Poll;
import com.coderbd.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/poll/")
public class PollController {
    @Autowired
    private PollService service;

    @GetMapping(value = "/list")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>(this.service.findAllPolls(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = this.service.saveOrUpdate(poll);
        // Set the location header for the newly created resourc
        HttpHeaders httpHeaders = new HttpHeaders();
        URI serveletUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        httpHeaders.setLocation(serveletUri);
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
    @GetMapping(value = "find/{id}")
    public ResponseEntity<?> getPollById(@PathVariable("id") Long id){
        Poll poll = this.service.getById(id);
        return new ResponseEntity<>(poll,HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deletePoll(@PathVariable("id") Long id){
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "update/{id}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable("id") Long id){
        poll.setId(id);
        Poll poll1 = this.service.saveOrUpdate(poll);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(null,httpHeaders,HttpStatus.CREATED);
    }
}
