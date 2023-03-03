package spring.sfgapp.services;

import org.springframework.web.multipart.MultipartFile;
import spring.sfgapp.entity.AppOpt;

import java.util.List;

public interface AppOptService extends CrudService<AppOpt,Long> {
    AppOpt getJson(String appOpt, List<MultipartFile> srcImg);
}
