package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {

    Set<Speciality> findAll();
    Optional<Speciality> findById(Long id);
    Speciality save(Speciality speciality);
    void delete(Speciality speciality);
    void deleteById(Long id);
}
