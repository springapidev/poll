package com.coderbd.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    public Vote() {
    }


    public Long getId() {
        return id;
    }

    public Option getOption() {
        return option;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id) &&
                Objects.equals(option, vote.option) &&
                Objects.equals(poll, vote.poll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, option, poll);
    }
}
