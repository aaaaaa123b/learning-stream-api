package by.harlap.stream.task.impl;


import by.harlap.stream.collector.CustomDateCollector;
import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;

import java.time.LocalDate;
import java.util.List;

public class Task14 implements Task {

    @Override
    public void run() {
        System.out.println("\n14. Получите список дат и найдите количество дней между первой и последней датой.\n");
        List<LocalDate > dates = DataProvider.createDates();

        long dateRange = dates.stream()
                .collect(CustomDateCollector.calculateDateRange());

        System.out.println("Количество дней между первой и последней датой: " + dateRange);
    }
}
