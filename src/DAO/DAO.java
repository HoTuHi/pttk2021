package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(int id);

    List<T> gellAll();

    void create(T t);

    T read(int t);

    void update(T t);

    void delete(T t);
}
