### Data Type Utility Functions in Java


#### Arrays

You can use `Arrays.sort()` to sort an array.

```java
int[] arr = {20, 10, 30};
Arrays.sort(arr);  // Sorts the array in ascending order
System.out.println(Arrays.toString(arr));  // Output: [10, 20, 30]
```

Binary Search

To find the index of a specific element, use ```Arrays.binarySearch()```.

```java
int[] arr = {10, 20, 30, 40, 50};
int index = Arrays.binarySearch(arr, 30);  // Returns the index of 30 (2)
System.out.println(index);  // Output: 2
```

Copying an Array

To create a copy of an array, use ```Arrays.copyOf()```.

```java
int[] arr = {1, 2, 3};
int[] copy = Arrays.copyOf(arr, arr.length);  // Copy the entire array
System.out.println(Arrays.toString(copy));  // Output: [1, 2, 3]
```

#### Integer

You can convert a String to an Integer using Integer.parseInt().
```java
String str = "123";
int num = Integer.parseInt(str);  // Converts string to integer
System.out.println(num);  // Output: 123
```

Converting Integer to String

You can convert an Integer to a String using Integer.toString().
```java
int num = 456;
String str = Integer.toString(num);  // Converts integer to string
System.out.println(str);  // Output: "456"
```

#### Character Utilities

You can check whether a character is a digit using Character.isDigit().
```java
char ch = '5';
boolean isDigit = Character.isDigit(ch);  // Returns true for '5'
System.out.println(isDigit);  // Output: true
```
To check if a character is a letter, use Character.isLetter().
```java
char ch = 'A';
boolean isLetter = Character.isLetter(ch);  // Returns true for 'A'
System.out.println(isLetter);  // Output: true
```

To convert a character to uppercase or lowercase, use Character.toUpperCase() and Character.toLowerCase().
```java
char ch = 'b';
char upperCh = Character.toUpperCase(ch);  // Converts 'b' to 'B'
System.out.println(upperCh);  // Output: B
```

#### String Utilities

To get the length of a string, use String.length().
```java
String str = "Hello, World!";
int length = str.length();  // Returns the number of characters in the string
System.out.println(length);  // Output: 13
```

Converting to Uppercase or Lowercase

You can convert a string to uppercase or lowercase using String.toUpperCase() and String.toLowerCase().

```java
String str = "Hello";
String upperStr = str.toUpperCase();  // Converts to "HELLO"
System.out.println(upperStr);  // Output: HELLO
```

Substring

To extract a part of a string, use String.substring().
```java
String str = "Hello, World!";
String substr = str.substring(0, 5);  // Extracts substring from index 0 to 5
System.out.println(substr);  // Output: Hello
```

Checking for Substring

To check if a string contains a specific substring, use String.contains().
```java
String str = "Hello, World!";
boolean contains = str.contains("World");  // Returns true if "World" is in the string
System.out.println(contains);  // Output: true
```

Replacing a Character or Substring

You can replace characters or substrings using String.replace().
```java
String str = "Hello, World!";
String newStr = str.replace("World", "Java");  // Replaces "World" with "Java"
System.out.println(newStr);  // Output: Hello, Java!
```

Splitting a String

To split a string into parts based on a delimiter, use String.split().
```java
String str = "apple,banana,orange";
String[] fruits = str.split(",");  // Splits the string by commas
System.out.println(Arrays.toString(fruits));  // Output: [apple, banana, orange]
```

Comparing Strings

To compare two strings, use String.equals() or String.compareTo().
```java
String str1 = "Hello";
String str2 = "hello";
boolean isEqual = str1.equals(str2);  // Returns false because of case difference
System.out.println(isEqual);  // Output: false
```

#### Math Utilities

You can use Math.max() and Math.min() to find the maximum or minimum of two values.
```java
int max = Math.max(10, 20);  // Returns the larger of 10 and 20
System.out.println(max);  // Output: 20

double power = Math.pow(2, 3);  // 2 raised to the power of 3
System.out.println(power);  // Output: 8.0

double sqrt = Math.sqrt(16);  // Square root of 16
System.out.println(sqrt);  // Output: 4.0
```