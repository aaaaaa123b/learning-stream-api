package by.harlap.stream.collector;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collector;

public class CustomDateCollector {

    public static Collector<LocalDate, ?, Long> calculateDateRange() {
        return Collector.of(
                DateRangeAccumulator::new,
                DateRangeAccumulator::accept,
                DateRangeAccumulator::combine,
                DateRangeAccumulator::getDifference
        );
    }

    private static class DateRangeAccumulator {
        private LocalDate minDate;
        private LocalDate maxDate;

        public DateRangeAccumulator() {
            minDate = LocalDate.MAX;
            maxDate = LocalDate.MIN;
        }

        public void accept(LocalDate date) {
            if (date.isBefore(minDate)) {
                minDate = date;
            }
            if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }

        public DateRangeAccumulator combine(DateRangeAccumulator other) {
            if (other.minDate.isBefore(minDate)) {
                minDate = other.minDate;
            }
            if (other.maxDate.isAfter(maxDate)) {
                maxDate = other.maxDate;
            }
            return this;
        }

        public long getDifference() {
            return ChronoUnit.DAYS.between(minDate, maxDate);
        }
    }
}
