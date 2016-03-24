package com.alina.clothe.service;

import java.util.List;

/**
 * Created by mkvitko on 3/22/16.
 */
public interface CRUDService<T, K> {

    void save(T object);

    List<T> findAll();

    T find(K id);
}