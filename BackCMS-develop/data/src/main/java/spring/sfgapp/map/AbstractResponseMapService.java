package spring.sfgapp.map;

import spring.sfgapp.entity.BaseEntity;
import spring.sfgapp.entity.User;
import spring.sfgapp.response.UserResponseRest;

import java.util.*;

/**
 * Created by jt on 7/21/18.
 */
public abstract class AbstractResponseMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<User> findAll(){
        //return new HashSet<>(map.values());
        return null;
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){

        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
