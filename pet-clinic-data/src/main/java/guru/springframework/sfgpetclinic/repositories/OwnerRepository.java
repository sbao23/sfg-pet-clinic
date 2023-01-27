package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
    Set<Owner> findAll();
    Optional<Owner> findById(Long id);
    Owner save(Owner object);
    void delete(Owner object);

    void deleteById(Long id);
}
