package nk.mframe.demo.dao;

import nk.mframe.demo.model.match_table;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<match_table, Integer> {
}
