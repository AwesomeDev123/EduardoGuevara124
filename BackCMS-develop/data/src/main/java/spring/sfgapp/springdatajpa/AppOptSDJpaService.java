package spring.sfgapp.springdatajpa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import spring.sfgapp.entity.AppOpt;
import spring.sfgapp.repositories.AppOptRepository;
import spring.sfgapp.services.AppOptService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class AppOptSDJpaService implements AppOptService {
    private final AppOptRepository appOptRepository;
    public AppOptSDJpaService(AppOptRepository appOptRepository) {
        this.appOptRepository = appOptRepository;
    }

    @Override
    public Set<AppOpt> findAll() {
        Set<AppOpt> appOptHasSet = new HashSet<>();
        appOptRepository.findAll().forEach(appOptHasSet::add);
        return appOptHasSet;
    }
    @Override
    public List<AppOpt> lfindAll() {
    //Creo el receptor de data
    List<AppOpt> appOptList = new ArrayList<>();
    //El servicio para inyectar los  datos
    appOptRepository.findAll().forEach(appOptList::add);
    //retorno
    return appOptList;
    }
    @Transactional(readOnly=true)
    @Override
    public AppOpt findById(Long aLong) {
        return appOptRepository.findById(aLong).orElse(null);
    }
    @Override
    public AppOpt save(AppOpt object) {
        return appOptRepository.save(object);
    }
    @Override
    public void delete(AppOpt object) {
        appOptRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        appOptRepository.deleteById(aLong);
    }
    public AppOpt getJson(String appOpt, List<MultipartFile> srcImg) {

        AppOpt appOptJson = new AppOpt();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            appOptJson = objectMapper.readValue(appOpt, AppOpt.class);
        } catch (IOException err) {
            System.out.println(err.toString());
        }

        int fileCount = srcImg.size();
        //appOptJson.setCount(fileCount);

        return appOptJson;

    }
}
