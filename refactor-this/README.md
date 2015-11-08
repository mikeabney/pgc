# Refactor This!

Your mission, should you choose to accept it, is to take the steaming pile of code in this project and refactor it
into something a bit more... palatable.

## Rules

To do this, follow the steps outlined below, committing after each one (if not more often).

1. Make sure that what you are about to change has unit tests. If not, write some
that pass without changing the "production" code.
1. If you want to change behavior:
   1. Change the tests, in small chunks, to model the new behavior.
   2. For each small test change, modify the corresponding code to make the test pass.
1. Pick a single change (say, a pattern to apply):
   1. Make the change
   1. Run all tests:
      1. If any red, start a 5-minute timer.
      1. If the timer runs out, revert your changes and try again.
    
## Bugs and Features

There are several bugs and potential for added features here. I'll point out a few:

* Once you have a BOGO for a particular item, the free one shouldn't really count toward any additional discounts.
* There are many other types of deals: packages containing more than one type of item, dollar amount sales, etc.
* If multiple deals may apply (like in the BOGO example at the beginning of this list), the customer should really
only get the best one.
* It might be desireable for some deals, discounts especially, to apply to everything rather than any one item.

Feel free to fix any bug or add any feature. The homework, though, is to just clean up the mess, and that means
adding tests!