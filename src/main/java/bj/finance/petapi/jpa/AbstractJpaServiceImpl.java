package bj.finance.petapi.jpa;

import bj.finance.petapi.model.BaseEntity;

import java.util.*;
import java.util.stream.Collectors;

public class AbstractJpaServiceImpl <T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        // return new HashSet<>(map.values());

        return map.values().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableSet());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object !=null){

            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
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
        try{
            return Collections.max(map.keySet()) + 1;
        }
        catch (NoSuchElementException ex){
            return 1L;
        }
    }
}