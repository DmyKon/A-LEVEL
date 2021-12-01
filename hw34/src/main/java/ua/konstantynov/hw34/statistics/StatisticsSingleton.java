package ua.konstantynov.hw34.statistics;

import java.time.LocalDateTime;

public class StatisticsSingleton {
    private static StatisticsSingleton instance;
    private String localDateTime;
    volatile private int queryCount;

    private StatisticsSingleton() {
    }

    synchronized static public StatisticsSingleton getInstance() {
        if (instance == null) {
            instance = new StatisticsSingleton();
        }
        instance.localDateTime = LocalDateTime.now().toString();
        return instance;
    }

    synchronized public void incrementQueryCount() {
        queryCount++;
    }
}