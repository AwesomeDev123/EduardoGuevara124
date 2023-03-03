package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.sfgapp.entity.AppTxt;
import spring.sfgapp.repositories.AppTxtRepository;
import spring.sfgapp.services.AppTxtService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AppTxtSDJpaService implements AppTxtService {
    private final AppTxtRepository appTxtRepository;
    public AppTxtSDJpaService(AppTxtRepository appTxtRepository) {
        this.appTxtRepository = appTxtRepository;
    }

    @Override
    public List<AppTxt> lfindAll() {
        List<AppTxt> appTxtListSet = new ArrayList<>();
        appTxtRepository.findAll().forEach(appTxtListSet::add);
        return appTxtListSet;
    }
    @Override
    public Set<AppTxt> findAll() {
        Set<AppTxt> appTxtHashSet = new HashSet<>();
        appTxtRepository.findAll().forEach(appTxtHashSet::add);
        return appTxtHashSet;
    }
    @Transactional(readOnly=true)
    @Override
    public AppTxt findById(Long aLong) {
        return appTxtRepository.findById(aLong).orElse(null);
    }
    @Override
    public AppTxt save(AppTxt object) {
        return appTxtRepository.save(object);
    }
    @Override
    public void delete(AppTxt object) { appTxtRepository.delete(object); }
    @Override
    public void deleteById(Long aLong) {
        appTxtRepository.deleteById(aLong); }

}
