package com.dresen.agePers.region;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class RegionSearchDao {

    private final EntityManager manager;

    public List<Region> findAllBySimpleQuery(String nom, String code) {

        CriteriaBuilder       criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Region> criteriaQuery   = criteriaBuilder.createQuery(Region.class);

        //select * from region

        Root<Region> root = criteriaQuery.from(Region.class);

        //prepare the where clause
        //WHERE nom like '%Centre%'
        Predicate nomPredicate = criteriaBuilder.like(root.get("nom"), "%" + nom + "%");

        //WHERE code like '%CE%'
        Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + code + "%");


        //Predicate orPredicate  = criteriaBuilder.or(nomPredicate, codePredicate);
        Predicate andPredicate = criteriaBuilder.and(nomPredicate, codePredicate);

        //=> final query ==> Select * from region where nom like '%Centre%' or code like '%CE%'
        criteriaQuery.where(andPredicate);

        TypedQuery<Region> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Region> findAllByCriteria(Searchrequest searchrequest) {

        CriteriaBuilder       criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Region> criteriaQuery   = criteriaBuilder.createQuery(Region.class);

        List<Predicate> predicates = new ArrayList<>();

        //select from region
        Root<Region> root = criteriaQuery.from(Region.class);
        //prepare the where clause

        if (searchrequest.getNom() != null) {
            //WHERE nom like '%Centre%'
            Predicate nomPredicate = criteriaBuilder.like(root.get("nom"), "%" + searchrequest.getNom() + "%");
            predicates.add(nomPredicate);
        }

        if (searchrequest.getCode() != null) {
            //WHERE code like '%CE%'
            Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + searchrequest.getCode() + "%");
            predicates.add(codePredicate);
        }

        //=> final query ==> Select * from region where nom like '%Centre%' or code like '%CE%'
        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Region> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

}
