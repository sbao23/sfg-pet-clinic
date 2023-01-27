package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getOwner() == null ||
        object.getPet().getId() == null || object.getPet().getOwner().getId()==null ) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(object);
    }
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}

