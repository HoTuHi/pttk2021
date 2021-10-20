package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> gellAll();

    Optional<T> get(int id);

    void create(T t);

    void read(T t);

    void update(T t);

    void delete(T t);
}
