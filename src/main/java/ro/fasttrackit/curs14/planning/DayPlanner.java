package ro.fasttrackit.curs14.planning;

import ro.fasttrackit.curs14.planning.exceptions.EmptyActivitiesException;
import ro.fasttrackit.curs14.planning.exceptions.NoActivityException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayPlanner {
    private final List<DaySchedule> days = new ArrayList<>();

    public DayPlanner() {
        for (WeekDay day : WeekDay.values()) {
            days.add(new DaySchedule(day));
        }
    }

    public void addActivity(WeekDay day, String activity) throws NoActivityException {
        if (activity == null) {
            throw new NoActivityException("Can't add null activity");
        }
        for (DaySchedule schedule : days) {
            if (schedule.getDay() == day) {
                schedule.addActivity(activity);
            }
        }
    }

    public Map<WeekDay, List<String>> endPlanning() {
        Map<WeekDay, List<String>> result = new HashMap<>();
        for (DaySchedule schedule : days) {
            if (schedule.isEmpty()) {
                throw new EmptyActivitiesException("There's a day without activities!");
            }
            result.put(schedule.getDay(), schedule.getActivities());
        }
        return result;
    }
}
