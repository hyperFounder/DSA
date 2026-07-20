### C++ Utility Functions

### **string**

| Function              | Purpose                                 | Header     |
|-----------------------|-----------------------------------------|------------|
| `length()` or `size()`| Get string length                       | `<string>` |
| `substr(pos, len)`    | Substring extraction                    | `<string>` |
| `find(substring)`     | Find position of substring              | `<string>` |
| `append(string)`      | Append another string                   | `<string>` |
| `c_str()`             | Convert to `const char*`                | `<string>` |
| `empty()`             | Check if string is empty                | `<string>` |
| `erase(pos, len)`     | Remove part of string                   | `<string>` |
| `compare(string)`     | Compare two strings                     | `<string>` |

---

### **char***

| Function              | Purpose                                 | Header     |
|-----------------------|-----------------------------------------|------------|
| `strlen(char*)`       | Get length of C-string                  | `<cstring>`|
| `strcpy(dest, src)`   | Copy C-string                           | `<cstring>`|
| `strcat(dest, src)`   | Concatenate C-string                    | `<cstring>`|
| `strcmp(str1, str2)`  | Compare two C-strings                   | `<cstring>`|
| `strchr(str, c)`      | Find first occurrence of character      | `<cstring>`|
| `strstr(str, substr)` | Find substring                         | `<cstring>`|

---

### **int**

| Function         | Purpose                           | Header            |
|------------------|-----------------------------------|-------------------|
| `to_string(int)` | Convert int to string             | `<string>`        |
| `stoi(string)`   | Convert string to int             | `<string>`        |
| `abs(int)`       | Absolute value                    | `<cstdlib>` or `<cmath>` |
| `max(int, int)`  | Max of two integers               | `<algorithm>`     |
| `min(int, int)`  | Min of two integers               | `<algorithm>`     |

---

### **float / double**

| Function           | Purpose                            | Header       |
|--------------------|------------------------------------|--------------|
| `to_string(float)` | Convert float to string            | `<string>`   |
| `stof(string)`     | Convert string to float            | `<string>`   |
| `stod(string)`     | Convert string to double           | `<string>`   |
| `fabs(float)`      | Absolute value (floating-point)    | `<cmath>`    |
| `ceil(double)`     | Round up                          | `<cmath>`    |
| `floor(double)`    | Round down                        | `<cmath>`    |
| `pow(double, double)` | Power function               | `<cmath>`    |

---


## STL a.k.a Standard Template Library

The **Standard Template Library (STL)** is a collection of **generic classes and functions** in C++ that provides well-implemented data structures and algorithms. 

### Key Components of STL:
- **Containers**: Store collections of data (e.g., `vector`, `map`, `set`).
- **Function Objects**: Objects that can be called like functions (functors).
---

- ```#include <forward_list>``` // SINGLY LINKED LIST
- ```#include <list>``` // DOUBLY LINKED LIST

### **vector**

| Function                        | Purpose                                      | Header       |
|---------------------------------|----------------------------------------------|--------------|
| `push_back(val)`                | Add element to the end                       | `<vector>`   |
| `pop_back()`                    | Remove last element                          | `<vector>`   |
| `size()`                        | Get number of elements                       | `<vector>`   |
| `empty()`                       | Check if vector is empty                     | `<vector>`   |
| `clear()`                       | Remove all elements                          | `<vector>`   |
| `at(index)`                     | Access element at position with bounds check | `<vector>`   |
| `front()`                       | Get first element                            | `<vector>`   |
| `back()`                        | Get last element                             | `<vector>`   |
| `begin()` / `end()`             | Get iterators to the vector                  | `<vector>`   |
| `insert(pos, val)`              | Insert element at specified position         | `<vector>`   |
| `erase(pos)`                    | Remove element at specified position         | `<vector>`   |
| `sort(vec.begin(), vec.end())`  | Sort vector elements                         | `<algorithm>`|

---
### **queue**

| Function                      | Purpose                                        | Header     |
|-------------------------------|------------------------------------------------|------------|
| `push(val)`                   | Add element to the back                        | `<queue>`  |
| `pop()`                       | Remove element from the front                  | `<queue>`  |
| `front()`                     | Access front element                           | `<queue>`  |
| `back()`                      | Access last element                            | `<queue>`  |
| `size()`                      | Get number of elements                         | `<queue>`  |
| `empty()`                     | Check if queue is empty                        | `<queue>`  |

---

### **stack**

| Function                      | Purpose                                        | Header     |
|-------------------------------|------------------------------------------------|------------|
| `push(val)`                   | Add element to the top                         | `<stack>`  |
| `pop()`                       | Remove element from the top                    | `<stack>`  |
| `top()`                       | Access top element                             | `<stack>`  |
| `size()`                      | Get number of elements                         | `<stack>`  |
| `empty()`                     | Check if stack is empty                        | `<stack>`  |

---

### **list**

| Function                      | Purpose                                        | Header     |
|-------------------------------|------------------------------------------------|------------|
| `push_back(val)`              | Add element to the end                         | `<list>`   |
| `push_front(val)`             | Add element to the front                       | `<list>`   |
| `pop_back()`                  | Remove element from the end                    | `<list>`   |
| `pop_front()`                 | Remove element from the front                  | `<list>`   |
| `insert(pos, val)`            | Insert element at position (iterator)          | `<list>`   |
| `erase(pos)`                  | Remove element at position (iterator)          | `<list>`   |
| `size()`                      | Get number of elements                         | `<list>`   |
| `empty()`                     | Check if list is empty                         | `<list>`   |
| `clear()`                     | Remove all elements                            | `<list>`   |
| `reverse()`                   | Reverse the list                               | `<list>`   |
| `sort()`                      | Sort the list                                  | `<list>`   |

---

### **set**

| Function                      | Purpose                                        | Header     |
|-------------------------------|------------------------------------------------|------------|
| `insert(val)`                 | Insert element                                 | `<set>`    |
| `find(val)`                   | Find element (returns iterator)                | `<set>`    |
| `erase(val)`                  | Remove element                                 | `<set>`    |
| `clear()`                     | Remove all elements                            | `<set>`    |
| `size()`                      | Get number of elements                         | `<set>`    |
| `empty()`                     | Check if set is empty                          | `<set>`    |
| `begin()` / `end()`           | Get iterators for the set                      | `<set>`    |

---