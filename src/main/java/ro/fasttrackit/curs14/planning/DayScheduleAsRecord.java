package ro.fasttrackit.curs14.planning;

import java.util.ArrayList;
import java.util.List;

public record DayScheduleAsRecord(WeekDay day, List<String> activities) {
    public DayScheduleAsRecord(WeekDay day, List<String> activities) {
        this.day = day;
        this.activities = new ArrayList<>();
        if (activities != null) {
            this.activities.addAll(activities);
        }
    }

    @Override
    public List<String> activities() {
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
}
