# Silly Object Calethenics

## The Rules

### 1. One level of indentation per method

```java
public class IndentationExample {
  public String badExample() {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < 10; i++) {
      builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");

      for (int j = 0; j < 10; j++) {
        builder.append("| ").append(i).append(",").append(j).append(" "); // Oops! Two levels deep here.
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
      builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
      buildRow(builder, i);
    }
    builder.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
  }

  private void buildRow(StringBuilder builder, int row) {
    for (int j = 0; j < 10; j++) {
      builder.append("| ").append(row).append(",").append(j).append(" "); // Still only 1 level deep!
    }
    builder.append("|");
  }
}
```

### 2. Don't use "else" (or "switch")

User polymorphism, delegation, the Null Object Pattern, and get creative!

### 3. Wrap all primitives and Strings

```java
public class Person {
  private String badName; // A "name" is a domain concept. It shouldn't be a primitive or String!
  private Name goodName; // Hey, "name" is now a type. Good!
}

public class Name {
  private String value; // Here we can use String. It's the data structure and won't be directly exposed.
}
```

### 4. First-class collections

Similar to #3, but for collections. If the collection is representing a domain concept (e.g. a list of frames in a bowling game), then it should be wrapped and exposed as a domain class. (E.G. Frames.java)

### 5. One dot per line (Law of Demeter)

Taken strictly, this means that using the "this" keyword is often going to count against the number of dots in the line. Do that if you like (the point of this is that it should be uncomfortable). However, the point is to follow the Law of Demeter strictly.

Only talk to your friends. You can call methods on:
* yourself
* your instance variables
* parameters to the method you are in

### 6. Don't abbreviate
This isn't an excuse to write really long variable, method, or class names. Make use of context and remove duplication. Encapsulate! For example:

* Not:
```java
Order.shipOrder();
```
* Instead:
```java
Order.ship();
```

### 7. Keep entities small

* Packages should have less than 10 classes.
* Classes should have less than 50 lines.
* Methods should have less than 10 lines.

### 8. No classes with more than 2 instance variables

This won't be comfortable, but is possible. For example:

```java
public class PersonName {
  private Surname surname;
  private GivenNames givenNames;
}

public class Surname {
  private Name value;
}

public class GivenNames {
  private List<Name> list;
}
```

### 9. No getters or setters (no "properties")

* Tell, don't ask (Tell the object that has the information what you want. Don't ask it for information so *you* can manipulate it.)
* Encapsulate, encapsulate, encapsulate!
* Objects aren't data structures!

### 10. All classes have state
No utility classes that manipulate data they don't own.

Static factory methods *are* allowed.

### 11. (Bonus Rule) No mutable objects
Everything should be given to the object at construction time. Why?

* Mutability leads to unexpected states.
* Unexpected states lead to otherwise unneeded checks.
* Otherwise unneeded checks lead to missing checks.
* Missing checks lead to exceptions, errors, and bugs.

## Homework

Using "the rules" (see above), implement a bowling game scorekeeper. Below is an example interaction (the UI is a bonus):

```
--- Welcome to Silly Bowling ---

Provide a Bowler Name
> Adam

Bowlers so far: Mike
Provide a Bowler Name (use a blank name to start bowling)
> Beth

Bowlers so far: Mike, Beth
Provide a Bowler Name (use a blank name to start bowling)
>

Ready to bowl!
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Mike |      |      |      |      |      |      |      |      |      |         |
|      |      |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth |      |      |      |      |      |      |      |      |      |         |
|      |      |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

Enter Mike's first ball (X for strike)
> 1

Enter Mike's second ball (/ for spare)
> /

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Mike | 1  / |      |      |      |      |      |      |      |      |         |
|      |  16  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth |      |      |      |      |      |      |      |      |      |         |
|      |      |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

Enter Beth's first ball (X for strike)
> 8

Enter Beth's second ball (/ for spare)
> 1

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Mike | 1  / |      |      |      |      |      |      |      |      |         |
|      |  16  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth | 8  1 |      |      |      |      |      |      |      |      |         |
|      |   9  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

Enter Mike's first ball (X for strike)
> 6

Enter Mike's second ball (/ for spare)
> 2

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Mike | 1  / | 6  2 |      |      |      |      |      |      |      |         |
|      |  16  |  24  |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth | 8  1 |      |      |      |      |      |      |      |      |         |
|      |   9  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

...

Enter Beth's first ball (X for strike)
> 7

Enter Beth's second ball (/ for spare)
> /

Enter Beth's last ball (X for strike)
> 9

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Mike | 1  / | 6  2 | 4  / | 5  4 | 4  5 | 5  4 | 4  5 | 5  4 | 3  5 | 5  4    |
|      |  16  |  24  |  39  |  48  |  57  |  66  |  75  |  84  |  92  |   101   |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth | 8  1 | X    | X    | X    | 8  1 | 9  / | 9  / | X    | X    | 7  /  9 |
|      |   9  |  39  |  67  |  86  |  95  | 114  | 134  | 161  | 178  |   197   |
+------+------+------+------+------+------+------+------+------+------+---------+

```

Don't forget the rules for bowling that third ball in the tenth frame!

If you've got it all working, add:
* editable frames,
* add and remove bowlers,
* "celebrations" (e.g. for strikes, turkeys, etc.), and
* better UI.
