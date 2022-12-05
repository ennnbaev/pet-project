package com.example1.demo.dao;


import com.example1.demo.domain.ChangeInfo;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ChangeDao
{
    private EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ChangeInfo saveNewOrder(ChangeInfo changeInfo){
        entityManager.persist(changeInfo);
        return changeInfo;
    }
    public List<ChangeInfo> findNewOrder(ChangeInfo changeInfo){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChangeInfo> criteriaQuery = criteriaBuilder.createQuery(ChangeInfo.class);
        Root<ChangeInfo> root = criteriaQuery.from(ChangeInfo.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("oldGame"), changeInfo.getNewGame()))
                .where(criteriaBuilder.equal(root.get("newGame"), changeInfo.getOldGame()));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
