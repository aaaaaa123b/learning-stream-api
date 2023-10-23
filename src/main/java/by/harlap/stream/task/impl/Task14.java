package by.harlap.stream.task.impl;


import by.harlap.stream.collector.CustomDateCollector;
import by.harlap.stream.task.Task;

import java.time.LocalDate;
import java.util.List;

public class Task14 implements Task {

    private final List<LocalDate> dates;

    public Task14(List<LocalDate> dates) {
        this.dates = dates;
    }
    @Override
    public void run() {
        System.out.println("\n14. Получите список дат и найдите количество дней между первой и последней датой.\n");

        long dateRange = dates.stream()
                .collect(CustomDateCollector.calculateDateRange());

        System.out.println("Количество дней между первой и последней датой: " + dateRange);
    }
}
