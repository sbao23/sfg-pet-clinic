package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface PetRepository extends CrudRepository<Pet,Long> {

    Optional<Pet> findById(Long id);
    Set<Pet> findAll();
    Pet save(Pet pet);
    void delete(Pet pet);
    void deleteById(Long id);
}
