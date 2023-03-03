package spring.sfgapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.RegUser;

import java.util.*;

public interface RegUserRepository extends CrudRepository<RegUser,Long> {
  List<RegUser> findByIdUser(String idUser);
 /*     List<RegUser> findAllByIdUser(String idUser);
    List<RegUser> findByIdCountry(String idUser) ;*/
}



