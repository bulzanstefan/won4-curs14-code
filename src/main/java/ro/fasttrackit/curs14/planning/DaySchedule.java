package ro.fasttrackit.curs14.planning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private final WeekDay day;
    private final List<String> activities = new ArrayList<>();

    public DaySchedule(WeekDay day) {
        this(day, List.of());
    }

    public DaySchedule(WeekDay day, List<String> activities) {
        this.day = day;
        if (activities != null) {
            this.activities.addAll(activities);
        }
    }

    public WeekDay getDay() {
        return day;
    }

    public List<String> getActivities() {
        return new ArrayList<>(activities);
    }

    public void addActivity(String activity) {
        if (activity != null) {
            this.activities.add(activity);
        }
    }

    public boolean isEmpty() {
        return this.activities.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule that = (DaySchedule) o;
        return day == that.day && Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, activities);
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
