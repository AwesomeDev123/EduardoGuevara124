package spring.sfgapp.services;
import spring.sfgapp.entity.AppMod;
import java.util.List;

public interface AppModService  extends CrudService<AppMod,Long>{
    public List<AppMod> findByAppModName(String modName);
    public List<AppMod> findByAppModNameAndAppModIndex(String modName,String modIndex);

}
