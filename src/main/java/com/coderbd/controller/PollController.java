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
public class PollController {
    @Autowired
    private PollService service;

    @GetMapping(value = "/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>(this.service.findAllPolls(), HttpStatus.OK);
    }

    @PostMapping(value = "/polls")
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
    @GetMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> getPollById(@PathVariable Long pollId){
        Poll poll = this.service.getById(pollId);
        return new ResponseEntity<>(poll,HttpStatus.OK);
    }

    @DeleteMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId){
        this.service.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId){
        poll.setId(pollId);
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
