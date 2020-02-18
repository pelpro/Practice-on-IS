package ru.sbt.darkspy.DAO.Repositories;

import ru.sbt.darkspy.DAO.Entity.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherCrudRepository extends CrudRepository<Weather, Long> {
    Weather findByDate(String dateString);
    Optional<Weather> findById(int id);
}
