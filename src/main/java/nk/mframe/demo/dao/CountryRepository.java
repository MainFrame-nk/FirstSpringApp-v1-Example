package nk.mframe.demo.dao;

import nk.mframe.demo.model.country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<country, Integer> {
}
