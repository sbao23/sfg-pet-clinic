package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        Speciality radio = new Speciality();
        radio.setDescription("radiology");
        specialityService.save(radio);

        Speciality surgery = new Speciality();
        radio.setDescription("surgery");
        specialityService.save(surgery);

        Speciality dentist = new Speciality();
        radio.setDescription("dentistry");
        specialityService.save(dentist);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jean");
        owner1.setLastName("De La Vallière");
        owner1.setAddress("123 Boston");
        owner1.setCity("Boston");
        owner1.setTel("456");

        Pet pet1= new Pet();
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.now());
        pet1.setName("Henry");
        owner1.getPets().add(pet1);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Saito");
        owner2.setLastName("Sato");
        owner1.setAddress("123 Bxl");
        owner1.setCity("Bxl");
        owner1.setTel("987");

        Pet pet2= new Pet();
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("Yan");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded  owner....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Max");
        vet1.setLastName("Duobis");
        vet1.getSpecialities().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Louise");
        vet2.setLastName("Dupont");
        vet2.getSpecialities().add(radio);
        vet2.getSpecialities().add(dentist);

        vetService.save(vet2);

        System.out.println("Loaded Vet...");

        Visit visitCat = new Visit();
        visitCat.setPet(pet2);
        visitCat.setDate(LocalDate.now());
        visitCat.setDescription("back pain");

        visitService.save(visitCat);

        Visit visitDog =new Visit();
        visitDog.setPet(pet1);
        visitDog.setDate(LocalDate.now());
        visitDog.setDescription("pawn pain");

        visitService.save(visitDog);

    }
}
