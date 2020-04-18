package com.labinvent.task.serivice;

import com.labinvent.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;

public interface Service<T> {
    T create(T entity);

    Page<T> readAll(SearchParameters parameters);

    T read(long id);

    void delete(long id);

    T update(T entity);
}
