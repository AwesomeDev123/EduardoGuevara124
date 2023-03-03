package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.AppMod;
import spring.sfgapp.repositories.AppModRepository;
import spring.sfgapp.services.AppModService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class AppModSDJpaService implements AppModService {
    private final AppModRepository appModRepository;
    public AppModSDJpaService(AppModRepository appModRepository) {
        this.appModRepository = appModRepository;
    }

    @Override
    public Set<AppMod> findAll() {
     Set<AppMod> appModSet = new HashSet<>();
    appModRepository.findAll().forEach(appModSet::add);
    return appModSet;
    }
    @Override
    public List<AppMod> lfindAll() {
        List<AppMod> appModList = new ArrayList<>();
        appModRepository.findAll().forEach(appModList::add);
        return appModList;
    }
    @Override
    public AppMod findById(Long aLong) {
        return  appModRepository.findById(aLong).orElse(null);
    }
    @Override
    public AppMod save(AppMod object) {
        return appModRepository.save(object);
    }
    @Override
    public void delete(AppMod object) {
        appModRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        appModRepository.deleteById(aLong);
    }

    @Override
    public List<AppMod> findByAppModName(String modName) {
        List<AppMod> appModNameList = new ArrayList<>();
        appModRepository.findAll().forEach(appModNameList::add);
        return appModNameList;
    }

    @Override
    public List<AppMod> findByAppModNameAndAppModIndex(String modName,String modIndex){
        List<AppMod> appModNameeAndAppModIndexList = new ArrayList<>();
        appModRepository.findAll().forEach(appModNameeAndAppModIndexList::add);
        return appModNameeAndAppModIndexList;
    }
}
