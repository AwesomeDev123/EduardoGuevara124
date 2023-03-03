package spring.sfgapp.springdatajpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import spring.sfgapp.entity.AppOpt;
import spring.sfgapp.repositories.AppOptRepository;
import spring.sfgapp.services.AppUpService;

import java.io.IOException;

/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class AppUpServiceImpl implements AppUpService {


    private final AppOptRepository  appOptRepository;

    public AppUpServiceImpl(AppOptRepository appOptRepository) {

        this.appOptRepository = appOptRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long appOptId, MultipartFile file) {

        try {
            AppOpt  appOpt = appOptRepository.findById(appOptId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

//            appOpt.setOptSrcImg(byteObjects);
            appOptRepository.save(appOpt);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}