package com.coderbd.controller;

import com.coderbd.dto.OptionCount;
import com.coderbd.dto.VoteResult;
import com.coderbd.entity.Vote;
import com.coderbd.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {

    @Autowired
    private VoteService voteService;

    @GetMapping(value = "/computeresult/{pollId}")
    public ResponseEntity<?> computeResult(@PathVariable Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteService.findAllVotes(pollId);
        // Algorithm to count votes
        Long totalVotes = 0L;
        Map<Long, OptionCount> map = new HashMap<Long, OptionCount>();
        for (Vote vote : allVotes) {
            totalVotes++;
            OptionCount optionCount = map.get(vote.getOption().getId());
            if (optionCount == null) {

                optionCount = new OptionCount();
                optionCount.setOptionId(vote.getOption().getId());
                map.put(vote.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(map.values());

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}
