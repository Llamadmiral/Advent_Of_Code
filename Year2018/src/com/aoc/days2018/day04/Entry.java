package com.aoc.days2018.day04;

/**
 * @author maczaka.
 */
public class Entry {
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int guardId;
    private Event event;

    public Entry(final int month, final int day, final int hour, final int minute, final int guardId, final Event event) {
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.guardId = guardId;
        this.event = event;
    }

    public static Entry make(final String row) {
        final int guardId = (row.contains("#")) ? Integer.parseInt(row.substring(row.indexOf('#') + 1, row.indexOf("begins") - 1)) : -1;
        final Event newEvent;
        if (row.contains("Guard")) {
            newEvent = Event.SHIFT_START;
        } else if (row.contains("falls")) {
            newEvent = Event.FALLS_ASLEEP;
        } else {
            newEvent = Event.WAKES_UP;
        }
        return new Entry(
            Integer.parseInt(row.substring(6, 8)),
            Integer.parseInt(row.substring(9, 11)),
            Integer.parseInt(row.substring(12, 14)),
            Integer.parseInt(row.substring(15, 17)),
            guardId,
            newEvent
        );
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getGuardId() {
        return guardId;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "[1518-" + month + "-" + day + " " + hour + ":" + minute + "] " + event.name() + " " + (guardId == -1 ? "" : guardId);
    }

    enum Event {
        SHIFT_START,
        FALLS_ASLEEP,
        WAKES_UP
    }
}
