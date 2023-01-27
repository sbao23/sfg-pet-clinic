package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
    Set<PetType> findAll();
    Optional<PetType> findById(Long id);
    PetType save(PetType petType);
    void delete(PetType petType);
    void deleteById(Long id);
}
