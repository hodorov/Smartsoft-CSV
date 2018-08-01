package com.smartsoft.main.service;

import com.smartsoft.main.model.Record;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DBService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAll(List<Record> records) {
        records.forEach(r -> entityManager.persist(r));
        entityManager.flush();
        entityManager.clear();
        entityManager.close();
    }
}

