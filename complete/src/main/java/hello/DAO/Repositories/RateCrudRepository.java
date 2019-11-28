package hello.DAO.Repositories;

import hello.DAO.Entity.RateTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateCrudRepository extends CrudRepository<RateTable, Long> {
    RateTable findByDate(String dateString);
    Optional<RateTable> findById(int id);

}
