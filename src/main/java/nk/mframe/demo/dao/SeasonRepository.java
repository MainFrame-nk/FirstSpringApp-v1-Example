package nk.mframe.demo.dao;

import nk.mframe.demo.model.season_table;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<season_table, Integer> {
}
