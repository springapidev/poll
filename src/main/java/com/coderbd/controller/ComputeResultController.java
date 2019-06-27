package com.coderbd.controller;

import com.coderbd.dto.OptionCount;
import com.coderbd.dto.VoteResult;
import com.coderbd.entity.Vote;
import com.coderbd.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {

    @Autowired
    private VoteService voteService;

    @GetMapping(value = "/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteService.findAllVotes(pollId);
        // Algorithm to count votes
        Long totalVotes = 0L;
        Map<Long, OptionCount> optionCountMap = new HashMap<Long, OptionCount>();
        for (Vote vote : allVotes) {

        }
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}
