package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.sfgapp.entity.AppImg;
import spring.sfgapp.repositories.AppImgRepository;
import spring.sfgapp.services.AppImgService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class AppImgSDJpaService implements AppImgService {

    private final AppImgRepository appImgRepository;
    public AppImgSDJpaService(AppImgRepository appImgRepository) {
        this.appImgRepository = appImgRepository;
    }

    @Override
    public Set<AppImg> findAll() {
        Set<AppImg> appImgHashSet = new HashSet<>();
        appImgRepository.findAll().forEach(appImgHashSet::add);
        return appImgHashSet;    }
    @Override
    public List<AppImg> lfindAll() {
        List<AppImg> imgList  = new ArrayList<>();
        appImgRepository.findAll().forEach(imgList::add);
        return imgList;
    }
    @Override
    public AppImg findById(Long aLong) {
        return appImgRepository.findById(aLong).orElse(null);
    }
    @Override
    public AppImg save(AppImg object) {
        return appImgRepository.save(object);
    }
    @Override
    public void delete(AppImg object) {
        appImgRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        appImgRepository.deleteById(aLong);
    }
}
