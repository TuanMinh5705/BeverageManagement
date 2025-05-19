package com.example.beveragemanagementjpa.repository;

import com.example.beveragemanagementjpa.model.Beverage;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BeverageRepository implements IBeverageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Beverage> findAll() {
        TypedQuery<Beverage> query = entityManager.createQuery("select c from Beverage c", Beverage.class);
        return query.getResultList();
    }

    @Override
    public Beverage findById(Long id) {
        TypedQuery<Beverage> query = entityManager.createQuery("select c from Beverage c where  c.id=:id", Beverage.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Beverage beverage) {
        if (beverage.getId() != null) {
            entityManager.merge(beverage);
        } else {
            entityManager.persist(beverage);
        }
    }

    @Override
    public void remove(Long id) {
        Beverage beverage = findById(id);
        if (beverage != null) {
            entityManager.remove(beverage);
        }
    }

    @Override
    public List<Beverage> searchByName(String keyword) {
        TypedQuery<Beverage> sql = entityManager.createQuery("select b from Beverage b where b.name like :name", Beverage.class);
        sql.setParameter("name","%"+keyword+"%");
        return sql.getResultList();
    }
}