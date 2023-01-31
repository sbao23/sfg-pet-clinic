package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;
    final long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().city("Brooklyn").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().city("Bxl").build();
        Owner ownerSaved = ownerServiceMap.save(owner);
        assertNotNull(ownerSaved);
        assertNotNull(ownerSaved.getId());
        assertEquals(owner, ownerSaved);
    }
    @Test
    void saveExistingId() {
        Owner owner = new Owner();
        owner.setId(2L);
        Owner ownerSaved = ownerServiceMap.save(owner);
        assertEquals(owner.getId(), ownerSaved.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setLastName("Jean");
        Owner savedOwner =ownerServiceMap.save(owner);
        assertEquals(owner.getLastName(),savedOwner.getLastName());
    }
}