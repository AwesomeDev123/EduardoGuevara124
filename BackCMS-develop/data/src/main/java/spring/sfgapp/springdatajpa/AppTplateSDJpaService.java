package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.AppTplate;
import spring.sfgapp.entity.AppTxt;
import spring.sfgapp.repositories.AppTplateRepository;
import spring.sfgapp.services.AppTplateService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class AppTplateSDJpaService implements AppTplateService {
    private final AppTplateRepository appTplateRepository;
    public AppTplateSDJpaService(AppTplateRepository appTplateRepository) {
        this.appTplateRepository = appTplateRepository;
    }

    @Override
    public List<AppTplate> lFindAll() {
        List<AppTplate> appTplateListSet = new ArrayList<>();
        appTplateRepository.findAll().forEach(appTplateListSet::add);
        return appTplateListSet;
    }
    @Override
    public List<AppTplate> lfindAll() {
        List<AppTplate> appTplateList = new ArrayList<>();
        appTplateRepository.findAll().forEach(appTplateList::add);
        return appTplateList;
    }
    @Override
    public Set<AppTplate> findAll() {
        Set<AppTplate> appTplateHashSet = new HashSet<>();
        appTplateRepository.findAll().forEach(appTplateHashSet::add);
        return appTplateHashSet;
    }
    @Override
    public AppTplate findById(Long aLong) {
        {
            return appTplateRepository.findById(aLong).orElse(null);
        }
    }
    @Override
    public AppTplate save(AppTplate object) {
        return appTplateRepository.save(object);
    }
    @Override
    public void delete(AppTplate object) {
        appTplateRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        appTplateRepository.deleteById(aLong);
    }
}