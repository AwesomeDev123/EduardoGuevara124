package spring.sfgapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.sfgapp.entity.RegPay;

import java.util.List;

public interface RegPayRepository extends CrudRepository<RegPay,Long> {
/*
    List<RegPay> findById(String id);
    List<RegPay> findByIdUser(String idUser);
    List<RegPay> findAllByIdUser(String idUser);
*/

}
