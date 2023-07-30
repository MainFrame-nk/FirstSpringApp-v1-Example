package nk.mframe.demo.dao;

import nk.mframe.demo.model.coefficient_table;
import org.springframework.data.repository.CrudRepository;

public interface CoefficientRepository extends CrudRepository<coefficient_table, Long> {
}
