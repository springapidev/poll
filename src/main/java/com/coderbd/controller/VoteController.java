package com.coderbd.controller;

import com.coderbd.entity.Poll;
import com.coderbd.entity.Vote;
import com.coderbd.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class VoteController {
    @Autowired
    private VoteService service;

    @PostMapping(value = "/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote){
        vote.setPoll(new Poll(pollId));
        this.service.saveOrUpdate(vote);
        HttpHeaders responseHeader = new HttpHeaders();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(vote.getId())
                .toUri();
        responseHeader.setLocation(uri);
        return new ResponseEntity<>(null,responseHeader, HttpStatus.CREATED);
    }
@GetMapping(value = "/polls/{pollId}/votes")
public ResponseEntity<Iterable<Vote>> getAllVotesByPoll(@PathVariable Long pollId){
        Iterable<Vote> votes = this.service.findAllVotes(pollId);
        return new ResponseEntity<>(votes,HttpStatus.OK);
}
}
