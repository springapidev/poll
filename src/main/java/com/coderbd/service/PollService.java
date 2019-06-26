package com.coderbd.service;

import com.coderbd.entity.Poll;

public interface PollService {
    Poll saveOrUpdate(Poll poll);
    void delete(Long id);
    Poll getById(Long id);
    Iterable<Poll> findAllPolls();
}
