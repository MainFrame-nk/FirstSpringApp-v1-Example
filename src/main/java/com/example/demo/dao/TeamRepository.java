package com.example.demo.dao;

import com.example.demo.models.team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<team, Integer> {
}