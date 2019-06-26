package com.coderbd.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "poll_option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_value")
    private String value;

    public Option() {
    }

    public Option(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(getId(), option.getId()) &&
                Objects.equals(getValue(), option.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getValue());
    }
}
