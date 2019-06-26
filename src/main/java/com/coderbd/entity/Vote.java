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

    public Vote() {
    }

    public Vote(Option option) {
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public Option getOption() {
        return option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getId(), vote.getId()) &&
                Objects.equals(getOption(), vote.getOption());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getOption());
    }
}
