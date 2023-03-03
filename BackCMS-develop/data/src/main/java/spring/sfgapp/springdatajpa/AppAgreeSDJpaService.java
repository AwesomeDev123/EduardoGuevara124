package spring.sfgapp.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.AppAgree;
import spring.sfgapp.repositories.AppAgreeRepository;
import spring.sfgapp.services.AppAgreeService;
import java.util.*;

@Service
@Profile("springdatajpa")
public class AppAgreeSDJpaService implements AppAgreeService {

    private final AppAgreeRepository appAgreeRepository;
   // private final AppAgreeService appAgreeService;

    //Inicializo AppAgreeService: como parametro del constructor y asigno como variable en el cuerpo
    //del constructor
    public AppAgreeSDJpaService(AppAgreeRepository appAgreeRepository) {
        this.appAgreeRepository = appAgreeRepository;
        //this.appAgreeService = appAgreeService;
    }

    @Override
    public Set<AppAgree> findAll() {
        Set<AppAgree> appAgreeHashSet = new HashSet<>();
        appAgreeRepository.findAll().forEach(appAgreeHashSet::add);
    //    appAgreeHashSet.addAll(appAgreeService.findAll());
        return appAgreeHashSet;
    }

    @Override
    public List<AppAgree> lfindAll() {
        List<AppAgree> appAgreeList = new ArrayList<>();
        appAgreeRepository.findAll().forEach(appAgreeList::add);
        return appAgreeList;
    }

    @Override
    public AppAgree findById(Long aLong) {
        //Optional<AppAgree> appAgree = appAgreeRepository.findById(aLong);
        return  appAgreeRepository.findById(aLong).orElse(null);
    }

    @Override
    public AppAgree save(AppAgree object) {
        return appAgreeRepository.save(object);
    }

    @Override
    public void delete(AppAgree object) {
        appAgreeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        appAgreeRepository.deleteById(aLong);
    }
}
