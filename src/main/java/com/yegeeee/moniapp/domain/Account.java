package com.yegeeee.moniapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "BIGINT default 0")
    private Long budget;

    @Builder
    public Account(String name, Long budget) {
        this.name = name;
        this.budget = budget;
    }
}
