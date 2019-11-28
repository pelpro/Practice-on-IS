package hello.DAO.Repositories;

import hello.DAO.Entity.WeatherTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherCrudRepository extends CrudRepository<WeatherTable, Long> {
    WeatherTable findByDate(String dateString);
    Optional<WeatherTable> findById(int id);
}
