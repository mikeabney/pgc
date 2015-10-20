package com.bud.pgc.calisthenics;

public class Player {
    private final String name;

    public Player(String name){
        this.name = name;
    }

    public Player() {
        this.name = "";
    }

    public String printNamePlate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" " + name);
        int buffer = 8 - name.length();
        for (int index = 0; index < buffer; index++){
            stringBuilder.append(" ");
        }

        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            String otherValue = ((Player)obj).name;
            return otherValue.equals(name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
