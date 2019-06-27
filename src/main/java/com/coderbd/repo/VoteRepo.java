package com.coderbd.repo;

import com.coderbd.entity.Poll;
import com.coderbd.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {
public Iterable<Vote> findAllByPoll(Poll poll);
}
