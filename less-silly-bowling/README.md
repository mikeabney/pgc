# Less Silly Bowling

## The Rules

This week, there are no rules. Well, at least not the same rules.

1. Pick a portion of my "silly bowling" solution.
2. Make sure no one else is working on it.
3. Apply a design pattern (from www.oodesign.com) in your reworking of that area.
4. The goal is to make the implementation something we would be proud of.

## Sample Game for Reference

```
--- Welcome to Silly Bowling ---

Provide a Bowler Name
> Adam

Bowlers so far: Adam
Provide a Bowler Name (use a blank name to start bowling)
> Beth

Bowlers so far: Adam, Beth
Provide a Bowler Name (use a blank name to start bowling)
>

Ready to bowl!
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Adam |      |      |      |      |      |      |      |      |      |         |
|      |      |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth |      |      |      |      |      |      |      |      |      |         |
|      |      |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

Enter Adam's first ball (X for strike)
> 1

Enter Adam's second ball (/ for spare)
> /

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Adam | 1  / |      |      |      |      |      |      |      |      |         |
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
| Adam | 1  / |      |      |      |      |      |      |      |      |         |
|      |  16  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+
| Beth | 8  1 |      |      |      |      |      |      |      |      |         |
|      |   9  |      |      |      |      |      |      |      |      |         |
+------+------+------+------+------+------+------+------+------+------+---------+

Enter Adam's first ball (X for strike)
> 6

Enter Adam's second ball (/ for spare)
> 2

Current score:
+------+------+------+------+------+------+------+------+------+------+---------+
|      |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10    |
+------+------+------+------+------+------+------+------+------+------+---------+
| Adam | 1  / | 6  2 |      |      |      |      |      |      |      |         |
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
| Adam | 1  / | 6  2 | 4  / | 5  4 | 4  5 | 5  4 | 4  5 | 5  4 | 3  5 | 5  4    |
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
