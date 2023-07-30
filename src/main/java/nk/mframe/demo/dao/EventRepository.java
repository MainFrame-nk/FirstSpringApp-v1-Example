package nk.mframe.demo.dao;

import nk.mframe.demo.model.event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<event, Long> {
}
