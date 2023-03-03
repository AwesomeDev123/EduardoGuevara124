package spring.sfgapp.service;

import spring.sfgapp.model.Owner;
import spring.sfgapp.services.CrudService;

import java.util.List;


/**
 * Created by jt on 7/18/18.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
