### Exercise 1: Unique & Sorted Word Extractor (`TreeSet`)

**Task:** Write a program that takes a sentence from the user, splits it into words, converts all words to lowercase, removes punctuation, and prints the unique words in alphabetical order.

* **Goal:** Practice basic `TreeSet` operations and automatic sorting/deduplication.

---

### Exercise 2: Student Leaderboard (`TreeMap` + Custom Sorting)

**Task:** Create a class `Student` with attributes `name` and `gpa`.
1. Store student objects as **keys** in a `TreeMap` where the value is their major (e.g., `"Computer Science"`).
2. Pass a custom `Comparator` to the `TreeMap` constructor so students are automatically sorted in **descending order of GPA**.

* **Goal:** Practice using custom `Comparator` objects with tree collections.

---

### Exercise 3: Word Frequency & Range Filter (`TreeMap`)

**Task:** 1. Given a long paragraph, count the frequency of each word using a `TreeMap<String, Integer>`.
2. Use `.subMap(fromKey, toKey)` to print only words starting between `'d'` and `'m'`.

* **Goal:** Leverage key-based navigation methods in `TreeMap`.
