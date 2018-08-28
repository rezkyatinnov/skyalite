package com.rezkyatinnov.skyalite;

import java.lang.reflect.Type;

public class SKyaLiteVanilla implements SKyaLitePort {
    @Override
    public <T> T get(String type, Type classType) {
        return null;
    }

    @Override
    public <M> boolean save(String type, M model) {
        return false;
    }

    @Override
    public <M> boolean update(String type, M model) {
        return false;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(String type) {

    }
}
