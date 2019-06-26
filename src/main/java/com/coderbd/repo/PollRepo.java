package com.coderbd.repo;

import com.coderbd.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends JpaRepository<Poll,Long> {
}
