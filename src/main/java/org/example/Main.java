package org.example;

import org.example.dao.ProjectDao;
import org.example.entities.Project;
import org.example.entities.Tache;
import org.example.entities.Utilisateur;
import org.example.util.Config;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectDao projectDao = new ProjectDao();
//
        // Test de persistProject
//        Project project1 = new Project();
//        project1.setTitre("Nouveau Projet 1");
//        project1.setDescription("Description du nouveau projet 1");
//        Project project2 = new Project();
//        project2.setTitre("Nouveau Projet 2");
//        project2.setDescription("Description du nouveau projet 2");
//        projectDao.persistProject(project1);
//        projectDao.persistProject(project2);
//
//        // Afficher les projets après l'ajout
//        System.out.println("Projets après l'ajout :");
//        List<Project> projects = projectDao.findAllProjectsOrderedByIdAsc();
//        for (Project p : projects) {
//            System.out.println(p.toString());
//        }

        // Test de ajouterTacheAuProject
        Project project = Config.getEntityManager().getReference(Project.class, 1l);
//        Tache tache1 = new Tache();
//        tache1.setTitre("Nouvelle Tâche 1 pour project 1");
//        tache1.setTitre("titre de la nouvelle tâche 1 pour project 1");
//        Tache tache2 = new Tache();
//        tache2.setTitre("Nouvelle Tâche 1 pour project 2");
//        tache2.setTitre("titre de la nouvelle tâche 1 pour project 2");
//        projectDao.ajouterTacheAuProject(project.getId(), tache1);
//        projectDao.ajouterTacheAuProject(project.getId(), tache2);
//
//        // Afficher les tâches après l'ajout
//        System.out.println("\nTâches après l'ajout :");
//        List<Tache> taches = projectDao.findAllTachesOrderedByIdAsc();
//        for (Tache t : taches) {
//            System.out.println(t);
//        }
//
        // Test de supprimerTachesDuProjet
//        projectDao.supprimerTachesDuProjet(project.getId());
//
//        // Afficher les tâches après la suppression
//        System.out.println("\nTâches après la suppression :");
//        List<Tache> taches = projectDao.findAllTachesOrderedByIdAsc();
//        for (Tache t : taches) {
//            System.out.println(t);
//        }
//
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setNom("khalid");
//        utilisateur.setAdresse("123 Rue de Test");
//        utilisateur.setEmail("khalid@example.com");
//        Utilisateur utilisateur2 = new Utilisateur();
//        utilisateur2.setNom("ali");
//        utilisateur2.setAdresse("123 Rue de Test");
//        utilisateur2.setEmail("ali@example.com");
//        Config.getEntityManager().persist(utilisateur);
//        Config.getEntityManager().persist(utilisateur2);
//
//        // Afficher les utilisateurs après la suppression
//        System.out.println("\nUtilisateurs avant la suppression :");
//        List<Utilisateur> utilisateurs = projectDao.findAllUtilisateursOrderedByIdAsc();
//        for (Utilisateur u : utilisateurs) {
//            System.out.println(u);
//        }
//        // Test de supprimerUtilisateur
//        projectDao.supprimerUtilisateur(utilisateur.getId());
    }
}