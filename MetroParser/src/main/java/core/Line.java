package core;

import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line> {
    private final String number;
    private final String name;
    private final transient List<Station> stations;

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public int compareTo(Line line) {
        return number.compareTo(line.getNumber());
    }

    @Override
    public boolean equals(Object obj) {
        return compareTo((Line) obj) == 0;
    }

    @Override
    public String toString() {
        return number +
                ", " + name + '\'' +
                ", stations=" + stations +
                '}';
    }
}

