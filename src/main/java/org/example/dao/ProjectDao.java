package org.example.dao;

import org.example.entities.Project;
import org.example.entities.Tache;
import org.example.entities.Utilisateur;
import org.example.util.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class ProjectDao {
    public List<Project> findAllProjectsOrderedByIdAsc(){
        EntityManager entityManager = Config.getEntityManager();
        try {
            String jpql = "SELECT p FROM Project p ORDER BY p.id ASC";
            List<Project> projects =  entityManager.createQuery(jpql, Project.class)
                    .getResultList();
            for (Project project : projects) {
                project.getTaches().size();
            }
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Utilisateur> findAllUtilisateursOrderedByIdAsc(){
        EntityManager entityManager = Config.getEntityManager();
        try {
            String jpql = "SELECT u FROM Utilisateur u ORDER BY u.id ASC";
            return entityManager.createQuery(jpql, Utilisateur.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Tache> findAllTachesOrderedByIdAsc() {
        EntityManager entityManager = Config.getEntityManager();
        try {
            String jpql = "SELECT t FROM Tache t ORDER BY t.id ASC";
            return entityManager.createQuery(jpql, Tache.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void persistProject(Project project){
        EntityManager entityManager = Config.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // Créer une requête JPQL pour l'insertion
            String jpql = "INSERT INTO Project (id, titre, description) VALUES (:id,:titre, :description)";
            Query query = entityManager.createNativeQuery(jpql);

            // Définir les paramètres de la requête
            query.setParameter("id", project.getId());
            query.setParameter("titre", project.getTitre());
            query.setParameter("description", project.getDescription());

            // Exécuter la requête d'insertion
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void ajouterTacheAuProject(long projectId, Tache tache){
        EntityManager entityManager = Config.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            // Récupérer le projet existant par son ID
            Project existingProject = entityManager.find(Project.class, projectId);

            if (existingProject != null) {
                // Ajouter la tâche au projet existant
                tache.setProject(existingProject);
                existingProject.getTaches().add(tache);

                // Persister la tâche (si nécessaire)
                entityManager.persist(tache);
            }else {
                throw new EntityNotFoundException("Project with id "+projectId+" not found");
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void supprimerTachesDuProjet(long projectId) {
        EntityManager entityManager = Config.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Récupérer le projet
            Project existingProject = entityManager.find(Project.class, projectId);

            if (existingProject != null) {
                // Supprimer toutes les tâches
                List<Tache> taches = existingProject.getTaches();
                for (Tache tache : taches) {
                    entityManager.remove(tache);  // Remove each task from the database
                }
                taches.clear();  // Clear the collection in memory

                transaction.commit();
            } else {
                throw new EntityNotFoundException("Project with id " + projectId + " not found");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void supprimerUtilisateur(long utilisateurId) {
        EntityManager entityManager = Config.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // Récupérer l'utilisateur existant
            Utilisateur existingUser = entityManager.find(Utilisateur.class, utilisateurId);

            if (existingUser != null) {
                // Supprimer l'utilisateur
                entityManager.remove(existingUser);
            }else {
                throw new EntityNotFoundException("Utilisateur with id "+utilisateurId+" not found");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


}
