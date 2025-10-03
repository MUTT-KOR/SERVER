package com.mutt.mutt_BE.idea.domain;

import jakarta.persistence.*;

@Entity
public class IdeaColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idea_id")
    private Idea idea;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;


}
