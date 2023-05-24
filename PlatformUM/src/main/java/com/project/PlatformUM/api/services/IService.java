package com.project.PlatformUM.api.services;

import java.util.List;

public interface IService<T> {

    public List<T> getAll();

    public T getById(Long id);

    public T create(T entity);

    public T update(T entity);

    public void delete(Long id);

}