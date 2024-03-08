package org.example.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;  // Projet auquel la tâche est associée

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", project=" + (project != null ? project.getTitre() : "null") +
                '}';
    }
}