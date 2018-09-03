package com.rezkyatinnov.skyalite;

class SKyaLiteChiper implements SKyaLitePort {
    @Override
    public <T, M> T get(M model) {
        return null;
    }

    @Override
    public <M> boolean save(M model) {
        return false;
    }

    @Override
    public <M> boolean update(M model) {
        return false;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <M> boolean delete(M model) {
        return false;
    }
}
