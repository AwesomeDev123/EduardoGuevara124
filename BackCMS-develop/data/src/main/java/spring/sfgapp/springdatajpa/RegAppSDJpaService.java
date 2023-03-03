package spring.sfgapp.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.RegApp;
import spring.sfgapp.entity.RegUser;
import spring.sfgapp.services.RegAppService;
import spring.sfgapp.repositories.RegAppRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class RegAppSDJpaService implements RegAppService {
    private final RegAppRepository regAppRepository;
    public RegAppSDJpaService(RegAppRepository regAppRepository) {
        this.regAppRepository = regAppRepository;
    }
    @Override
    public Set<RegApp> findAll() {
        Set<RegApp> regAppHashSet = new HashSet<>();
        regAppRepository.findAll().forEach(regAppHashSet::add);
        return regAppHashSet;
    }
    @Override
    public List<RegApp> lfindAll() {
        return null;
    }
    @Override
    public RegApp findById(Long aLong) {
        return regAppRepository.findById(aLong).orElse(null);
    }
    @Override
    public RegApp save(RegApp object) {
        return regAppRepository.save(object);
    }
    @Override
    public void delete(RegApp object) {
        regAppRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        regAppRepository.deleteById(aLong);
    }

}
