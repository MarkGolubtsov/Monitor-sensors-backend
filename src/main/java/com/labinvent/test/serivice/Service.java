package com.labinvent.test.serivice;

import com.labinvent.test.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;

public interface Service<T> {
    T create(T entity);

    Page<T> readAll(SearchParameters parameters);

    T read(long id);

    void delete(long id);

    T update(T entity);
}
