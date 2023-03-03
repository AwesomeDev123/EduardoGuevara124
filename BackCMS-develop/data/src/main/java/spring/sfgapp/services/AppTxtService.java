package spring.sfgapp.services;
import spring.sfgapp.entity.AppTxt;
import java.util.List;

public interface AppTxtService extends CrudService<AppTxt, Long> {
    List<AppTxt> lfindAll();
}

