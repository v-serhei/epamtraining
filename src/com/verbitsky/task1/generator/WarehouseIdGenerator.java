package com.verbitsky.task1.generator;

public class WarehouseIdGenerator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = Long.MAX_VALUE - 1;
    private static long counter = 1;

    private WarehouseIdGenerator() {
    }

    public static long generateId() {
        if (MIN_ID + counter > MAX_ID) {
            counter = 1;
        }
        long id = counter;
        counter++;
        return id;
    }
}
