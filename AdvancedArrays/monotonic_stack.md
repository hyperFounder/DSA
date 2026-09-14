# Monotonic Stack

Answers one shape of question: **for each element, find the nearest element to its left or right that is bigger/smaller.** Whenever you catch yourself writing a nested loop that scans outward looking for the first thing satisfying a comparison, that's the signal.

## The four variants

Name which one you need before writing code.

| Want | Stack holds | Pop while |
|---|---|---|
| Next greater | decreasing | top < current |
| Next smaller | increasing | top > current |
| Previous greater | decreasing | top <= current |
| Previous smaller | increasing | top >= current |

"Decreasing" describes the contents at rest, bottom to top: bottom is largest, top is smallest.

## Problems

### Start here
- 496. Next Greater Element I
- 503. Next Greater Element II - circular, loop the array twice with modulo
- 739. Daily Temperatures - same algorithm, asks for distance instead of value
- 901. Online Stock Span - previous greater, streaming

### Histogram family (the reason this pattern matters)
- 84. Largest Rectangle in Histogram - the boss fight, needs previous *and* next smaller
- 85. Maximal Rectangle - 84 applied row by row
- 42. Trapping Rain Water - solvable with a stack or two pointers, do both

### Subarray contribution
- 907. Sum of Subarray Minimums - count how many subarrays each element dominates
- 2104. Sum of Subarray Ranges
- 1856. Maximum Subarray Min-Product

### Lexicographic / construction
- 316. Remove Duplicate Letters
- 402. Remove K Digits - easier, do it before 316
- 1673. Find the Most Competitive Subsequence
- 321. Create Maximum Number

### Other
- 853. Car Fleet - sort, then stack
- 1019. Next Greater Node In Linked List
- 456. 132 Pattern - stack used backwards, genuinely tricky

## Suggested path

496 -> 739 -> 503 -> 901 -> 402 -> 84 -> 907 -> 42

## Gotchas

- Hold **indices**, not values. You can always look up the value, but you can't recover the index.
- For 84, append a sentinel `0` to the end so the final flush happens inside the main loop instead of a cleanup block afterwards.
- Strictness matters with duplicates. For next greater, `pop while top < current` leaves equal values on the stack, which is correct since equal isn't greater. `<=` would pop them and give the wrong answer.

## Recognition test

If the brute force is "for each i, walk outward until I find the first element that beats it", the monotonic stack collapses it from O(n^2) to O(n). That's the whole trigger.
