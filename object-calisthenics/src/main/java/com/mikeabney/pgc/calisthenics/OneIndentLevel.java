package com.mikeabney.pgc.calisthenics;

public class OneIndentLevel {

    public String badExample() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
            for (int j = 0; j < 10; j++) {
                builder.append("| ").append(i).append(",").append(j).append(" ");
            }
            builder.append("|");
        }
        builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");

        return builder.toString();
    }

    public String betterExample() {
        StringBuilder builder = new StringBuilder();
        buildRows(builder);

        return builder.toString();
    }

    private void buildRows(StringBuilder builder) {
        for (int i = 0; i < 10; i++) {
            buildRow(builder, i);
        }
        builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
    }

    private void buildRow(StringBuilder builder, int i) {
        builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
        for (int j = 0; j < 10; j++) {
            builder.append("| ").append(i).append(",").append(j).append(" ");
        }
        builder.append("|");
    }

    public static void main(String... args) {
        OneIndentLevel testObject = new OneIndentLevel();
        System.out.println("Bad version output: ");
        System.out.println(testObject.badExample());
        System.out.println("Better version output: ");
        System.out.println(testObject.betterExample());
    }
}
