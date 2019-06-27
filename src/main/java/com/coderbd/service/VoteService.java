package com.coderbd.service;


import com.coderbd.entity.Vote;

public interface VoteService {
    Vote saveOrUpdate(Vote vote);
    void delete(Long id);
    Vote getById(Long id);
    Iterable<Vote> findAllVotes(Long pollId);

}
