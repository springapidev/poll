package com.coderbd.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "option_id")
    @OrderBy
    @Size(min = 2,max = 8)
    private Set<Option> options;

    public Poll() {
    }
    public Poll(Long id) {
        this.id=id;
    }

    public Poll(String question, Set<Option> options) {
        this.question = question;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return Objects.equals(getId(), poll.getId()) &&
                Objects.equals(getQuestion(), poll.getQuestion()) &&
                Objects.equals(getOptions(), poll.getOptions());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getQuestion(), getOptions());
    }
}
