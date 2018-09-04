package com.metacube.userLogin.dao;

import java.util.List;

public interface BaseDao <T>{

    public List<T> getAll();

    public boolean insert(T entity);

    public boolean update(T t);

    public boolean delete(T t);
}
