package com.mikeabney.pgc.calisthenics;

import java.util.List;

public class SmallClasses {
    public class BadPerson {
        private String firstName;
        private String middleName;
        private String lastName;
    }

    public class BetterPerson {
        private Surname surname;
        private GivenNames givenNames;
    }

    public class Surname {
        private Wrappers.Name value;
    }

    public class GivenNames {
        private List<Wrappers.Name> list;
    }
}
