package com.coderbd.serviceimpl;

import com.coderbd.entity.Poll;
import com.coderbd.entity.Vote;
import com.coderbd.repo.VoteRepo;
import com.coderbd.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepo repo;

    @Override
    public Vote saveOrUpdate(Vote vote) {
        return repo.saveAndFlush(vote);
    }

    @Override
    public void delete(Long id) {
this.repo.deleteById(id);
    }

    @Override
    public Vote getById(Long id) {
        return this.repo.getOne(id);
    }

    @Override
    public Iterable<Vote> findAllVotes(Long pollId) {
        Poll poll = new Poll();
        poll.setId(pollId);
        return this.repo.findAllByPoll(poll);
    }
}
