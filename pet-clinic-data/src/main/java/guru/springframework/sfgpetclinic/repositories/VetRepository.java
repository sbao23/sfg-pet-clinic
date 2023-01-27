package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface VetRepository extends CrudRepository<Vet,Long> {

    Set<Vet> findAll();
    Optional<Vet> findById(Long id);
    Vet save(Vet object);
    void delete(Vet object);
    void deleteById(Long id);
}
