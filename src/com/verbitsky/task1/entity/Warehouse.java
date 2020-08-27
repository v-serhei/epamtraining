package com.verbitsky.task1.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Warehouse {
    INSTANCE;
    private Map<Long, FigureCalcResult> storage = new HashMap<>();

    public Map<Long, FigureCalcResult> getStorage() {
        return Collections.unmodifiableMap(storage);
    }

    public FigureCalcResult get(Long key) {
        return storage.get(key);
    }

    public FigureCalcResult remove(Long key) {
        return storage.remove(key);
    }

    public Set<Map.Entry<Long, FigureCalcResult>> entrySet() {
        return storage.entrySet();
    }

    public FigureCalcResult putIfAbsent(Long key, FigureCalcResult value) {
        return storage.putIfAbsent(key, value);
    }

    public FigureCalcResult put(Long key, FigureCalcResult value) {
        return getStorage().put(key, value);
    }

    public void clear() {
        storage.clear();
    }

    public int getStorageSize() {
        return getStorage().size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Figure warehouse: number of figures in storage=");
        sb.append(storage.size());
        return sb.toString();
    }
}
