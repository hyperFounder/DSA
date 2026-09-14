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
- [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
- [503. Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) - circular, loop the array twice with modulo
- [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) - same algorithm, asks for distance instead of value
- [901. Online Stock Span](https://leetcode.com/problems/online-stock-span/) - previous greater, streaming

### Histogram family (the reason this pattern matters)
- [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) - the boss fight, needs previous *and* next smaller
- [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) - 84 applied row by row
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) - solvable with a stack or two pointers, do both

### Subarray contribution
- [907. Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/) - count how many subarrays each element dominates
- [2104. Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/)
- [1856. Maximum Subarray Min-Product](https://leetcode.com/problems/maximum-subarray-min-product/)

### Lexicographic / construction
- [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)
- [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/) - easier, do it before 316
- [1673. Find the Most Competitive Subsequence](https://leetcode.com/problems/find-the-most-competitive-subsequence/)
- [321. Create Maximum Number](https://leetcode.com/problems/create-maximum-number/)

### Other
- [853. Car Fleet](https://leetcode.com/problems/car-fleet/)
- [1019. Next Greater Node In Linked List](https://leetcode.com/problems/next-greater-node-in-linked-list/)
- [456. 132 Pattern](https://leetcode.com/problems/132-pattern/) - stack used backwards, genuinely tricky

## Suggested path

496 -> 739 -> 503 -> 901 -> 402 -> 84 -> 907 -> 42

## Gotchas

- Hold **indices**, not values. You can always look up the value, but you can't recover the index.
- For 84, append a sentinel `0` to the end so the final flush happens inside the main loop instead of a cleanup block afterwards.
- Strictness matters with duplicates. For next greater, `pop while top < current` leaves equal values on the stack, which is correct since equal isn't greater. `<=` would pop them and give the wrong answer.

## Recognition test

If the brute force is "for each i, walk outward until I find the first element that beats it", the monotonic stack collapses it from O(n^2) to O(n). That's the whole trigger.
