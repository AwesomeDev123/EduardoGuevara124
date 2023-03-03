package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.RegUser;
import spring.sfgapp.services.RegUserService;
import spring.sfgapp.repositories.RegUserRepository;
import java.util.*;

@Service
@Profile("springdatajpa")
public class RegUserSDJpaService implements RegUserService {
    private final RegUserRepository regUserRepository;
    public RegUserSDJpaService( RegUserRepository regUserRepository) {
        this.regUserRepository = regUserRepository;
    }
    @Override
    public Set<RegUser> findAll() {
        Set<RegUser> regUserHashSet = new HashSet<>();
        regUserRepository.findAll().forEach(regUserHashSet::add);
        return regUserHashSet;
    }
    @Override
    public List<RegUser> lfindAll() {
        return null;
    }
    @Override
    public RegUser findById(Long aLong) {
        return regUserRepository.findById(aLong).orElse(null);
    }
    @Override
    public RegUser save(RegUser object) {
        return regUserRepository.save(object); }
    @Override
    public void delete(RegUser object) { regUserRepository.delete(object); }
    @Override
    public void deleteById(Long aLong) { regUserRepository.deleteById(aLong); }
    @Override
    public List<RegUser> findByIdUser(String id) {
        List<RegUser> regUserListSet = new ArrayList<>();
        regUserRepository.findByIdUser(id).forEach(regUserListSet::add);
        return regUserListSet;
    }
}
