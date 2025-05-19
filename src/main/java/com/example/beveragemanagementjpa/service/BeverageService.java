package com.example.beveragemanagementjpa.service;

import com.example.beveragemanagementjpa.model.Beverage;
import com.example.beveragemanagementjpa.repository.IBeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageService implements IBeverageService {
    @Autowired
    private IBeverageRepository iBeverageRepository;

    @Override
    public List<Beverage> findAll() {
        return iBeverageRepository.findAll();
    }

    @Override
    public void save(Beverage beverage) {
        iBeverageRepository.save(beverage);
    }

    @Override
    public Beverage findById(Long id) {
        return iBeverageRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iBeverageRepository.remove(id);
    }

    @Override
    public List<Beverage> searchByName(String keyword) {
        return iBeverageRepository.searchByName(keyword);
    }

}