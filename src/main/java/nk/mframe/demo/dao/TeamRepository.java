package nk.mframe.demo.dao;

import nk.mframe.demo.model.team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<team, Integer> {
}