package com.example.demo.dao;

import com.example.demo.models.match_table;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<match_table, Long> {
}
