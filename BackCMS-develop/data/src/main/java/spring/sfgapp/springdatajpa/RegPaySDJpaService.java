package spring.sfgapp.springdatajpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.sfgapp.entity.RegPay;
import spring.sfgapp.services.RegPayService;
import spring.sfgapp.repositories.RegPayRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class RegPaySDJpaService implements RegPayService {
    private final RegPayRepository registryPayRepository;

    public RegPaySDJpaService(RegPayRepository registryPayRepository) {
        this.registryPayRepository = registryPayRepository;
    }

    @Override
    public Set<RegPay> findAll() {
        Set<RegPay> regPayHashSet = new HashSet<>();
        registryPayRepository.findAll().forEach(regPayHashSet::add);
        return regPayHashSet;
    }
    @Override
    public List<RegPay> lfindAll() {
        List<RegPay> regPayList = new ArrayList<>();
        registryPayRepository.findAll().forEach(regPayList::add);
        return regPayList;
    }
    @Transactional(readOnly = true)
    @Override
    public RegPay findById(Long aLong) {
        return registryPayRepository.findById(aLong).orElse(null);
    }
    @Override
    public RegPay save(RegPay object) {
        return registryPayRepository.save(object);
    }
    @Override
    public void delete(RegPay object) {
        registryPayRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        registryPayRepository.deleteById(aLong);
    }
}

/*    @Override
    public List<RegPay> lFindAll() {
        List<RegPay> regPayListSet = new ArrayList<>();
        registryPayRepository.findAll().forEach(regPayListSet::add);
        return regPayListSet;
    }*/

/*    @Override
    public List<RegPay> findByIdUser(String id) {
        return null;
    }
}*/
/*    @Override
    public List<RegPay> lfindById(String id) {
        List<RegPay> regPayListSet = new ArrayList<>();
        registryPayRepository.lfindById(id).forEach(regPayListSet::add);
        return regPayListSet;
    }*/