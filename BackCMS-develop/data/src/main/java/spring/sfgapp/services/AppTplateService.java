package spring.sfgapp.services;
import spring.sfgapp.entity.AppTplate;
import spring.sfgapp.entity.AppTxt;

import java.util.List;

public interface AppTplateService extends CrudService<AppTplate, Long> {
    List<AppTplate> lFindAll();
    List<AppTplate> lfindAll();
}
