package nk.mframe.demo.dao;

import nk.mframe.demo.model.league;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<league, Integer> {
}
