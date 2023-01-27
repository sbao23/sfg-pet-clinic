package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit,Long> {
    Set<Visit> findAll();
    Optional<Visit> findById(Long id);
    Visit save(Visit visit);
    void delete(Visit visit);
    void deleteById(Long id);
}
