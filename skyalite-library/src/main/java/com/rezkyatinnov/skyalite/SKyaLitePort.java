package com.rezkyatinnov.skyalite;

public interface SKyaLitePort {
    <T> T get(String type, java.lang.reflect.Type classType);

    <M> boolean save(String type, M model);

    <M> boolean update(String type, M model);

    void deleteAll();

    void delete(String type);
}
