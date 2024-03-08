package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur creePar;  // Utilisateur créateur du projet

    @OneToMany(mappedBy = "project")
    private List<Tache> taches;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", taches=" + taches +
                '}';
    }
}
