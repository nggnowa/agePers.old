package com.dresen.agePers.region.search;

import com.dresen.agePers.region.Region;
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

        Root<Region> root = criteriaQuery.from(Region.class); //select * from region

        //prepare the where clause
        Predicate nomPredicate  = criteriaBuilder.like(root.get("nom"), "%" + nom + "%"); //WHERE nom like '%Centre%'
        Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + code + "%"); //WHERE code like '%CE%'

        Predicate orPredicate  = criteriaBuilder.or(nomPredicate, codePredicate);
        Predicate andPredicate = criteriaBuilder.and(nomPredicate, codePredicate);

        //=> final query ==> Select * from region where nom like '%Centre%' and code like '%CE%'
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
        if (searchrequest.nom() != null) {
            //WHERE nom like '%Centre%'
            Predicate nomPredicate = criteriaBuilder.like(root.get("nom"), "%" + searchrequest.nom() + "%");
            predicates.add(nomPredicate);
        }

        if (searchrequest.code() != null) {
            //WHERE code like '%CE%'
            Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + searchrequest.code() + "%");
            predicates.add(codePredicate);
        }

        //=> final query ==> Select * from region where nom like '%Centre%' and code like '%CE%'
        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Region> query = manager.createQuery(criteriaQuery);
        return query.getResultList();

    }

}
