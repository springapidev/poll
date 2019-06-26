package com.coderbd.serviceimpl;

import com.coderbd.entity.Poll;
import com.coderbd.repo.PollRepo;
import com.coderbd.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepo repo;

    @Override
    public Poll saveOrUpdate(Poll poll) {
        return repo.saveAndFlush(poll);
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Poll getById(Long id) {
        return repo.getOne(id);
    }

    @Override
    public Iterable<Poll> findAllPolls() {
        return repo.findAll();
    }
}
