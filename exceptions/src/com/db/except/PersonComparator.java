package com.db.except;

import java.util.Comparator;

public class PersonComparator implements Comparator<Club.Person> {

    @Override
    public int compare(Club.Person o1, Club.Person o2) {
        return o1.getAge() - o2.getAge();
    }

}
