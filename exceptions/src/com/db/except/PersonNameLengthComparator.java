package com.db.except;

import java.util.Comparator;

public class PersonNameLengthComparator implements Comparator<Club.Person> {


    @Override
    public int compare(Club.Person o1, Club.Person o2) {
        return o1.getName().length() - o2.getName().length();
    }
}
