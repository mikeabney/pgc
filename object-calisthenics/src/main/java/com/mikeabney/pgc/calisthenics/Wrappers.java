package com.mikeabney.pgc.calisthenics;

public class Wrappers {
    public class BadPerson {
        private String name;

        public BadPerson(String name) {
            this.name = name;
        }
    }

    public class Name {
        private String value;

        public String getValue() {
            return value;
        }
    }

    public class BetterPerson {
        private Name name;

        public BetterPerson(Name name) {
            this.name = name;
        }
    }
}
