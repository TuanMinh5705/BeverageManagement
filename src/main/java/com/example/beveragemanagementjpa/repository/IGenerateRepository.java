package com.example.beveragemanagementjpa.repository;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
    List<T> searchByName(String keyword);
}