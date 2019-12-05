package hello.DAO.Repositories;

import hello.DAO.Entity.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateCrudRepository extends CrudRepository<Rate, Long> {
    Rate findByDate(String dateString);
    Optional<Rate> findById(int id);

}
