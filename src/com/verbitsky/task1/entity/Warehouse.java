package com.verbitsky.task1.entity;

import com.verbitsky.task1.action.FigureCalculator;
import com.verbitsky.task1.action.impl.TetrahedronCalculator;
import com.verbitsky.task1.exception.FigureException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Warehouse {
    INSTANCE;
    private FigureCalculator calculator = new TetrahedronCalculator();
    private Logger logger = LogManager.getLogger();
    private Map<Long, FigureCalcResult> storage = new HashMap<>();

    public void updateCalculations (Figure figure) {
        try {
            double square = calculator.calculateSquare(figure);
            double volume = calculator.calculateVolume(figure);
            FigureCalcResult calcResult = get(figure.getFigureId());
            ((TetrahedronCalcResult)calcResult).setPlaneSquare(square);
            ((TetrahedronCalcResult)calcResult).setVolume(volume);
        } catch (FigureException e) {
            logger.log(Level.INFO, "Can't calculate figure parameters");
        }
    }

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
