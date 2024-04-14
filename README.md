<!-- check-out single branch from repo:
        git clone -b b12 --single-branch https://github.com/sgra64/se1.play.git
 -->

# Assignment B2

Follow steps for completing this assignment.

1. [Getting Started](#1-getting-started)

2. [Sourcing the Project](#2-sourcing-the-project)

3. [Building the Application](#3-building-the-application)

4. [Running the Application](#4-running-the-application)

5. [Completing Numbers Methods](#5-completing-numbers-methods)

    1. `sum()`            - calculate sum of numbers[]                   (1Pt)

    1. `sum_pen()`        - sum of positive even numbers                 (1Pt)

    1. `sum_rec()`        - sum of numbers[] without using loops         (1Pt)

    1. `findFirst(int x)`     - find index of first occurrence of x      (1Pt)

    1. `findLast(int x)`      - find index of last occurrence of x       (1Pt)

    1. `findAll(int x)`       - find all indices of x in numbers         (1Pt)

    1. `findSums(int sum)`    - find all pairs {a, b} with a + b = sum   (2Pt)

    1. `findAllSums(int sum)` - find all combinations of numbers that add to sum (3Pt)

      Points are credited when corresponding JUnit tests pass.

      For 7. and 8. tests `7a` and `8a` must pass. Extra points when tests
      `7b` (+1EP) and `8b` (+2EP) pass.

6. [Running JUnit Tests](#6-running-junit-tests)

7. [Generating Javadoc](#7-generating-javadoc)

8. [Packaging the Application](#8-packaging-the-application)   


&nbsp;
## 1. Getting started

This assignment adds package `numbers` to `src` and `tests`:

```sh
--<se1.play>:
 |
 +--<src>                       # Java source code
 |   +-- module-info.java           # module defintion file
 |   +--<application>               # Java package 'application'
 |   |   +-- package-info.java      # 'application'-package defintion
 |   |   +-- Application.java       # main application program with main()
 |   |
 |   +--<numbers>               # new 'Numbers' package
 |       +-- Numbers.java           # Numbers interface
 |       +-- NumbersImpl.java       # Numbers implementation class
 |       +-- package-info.java
 |
 +--<tests>                     # Unit-test source code separated from src/main
 |   +--<application>               # mirrored package structure
 |   |   +-- Application_0_always_pass_Tests.java   # initial JUnit-test
 |   |
 |   +--<numbers>               # new 'Numbers' JUnit tests
 |       +-- Matchers.java      # assertion matcher that ignores order in collections
 |       +-- Numbers_1_sum_Tests.java
 |       +-- Numbers_2_sum_positive_even_Tests.java
 |       +-- Numbers_3_sum_recursion_Tests.java
 |       +-- Numbers_4_find_first_Tests.java
 |       +-- Numbers_5_find_last_Tests.java
 |       +-- Numbers_6_find_all_Tests.java
 |       +-- Numbers_7a_find_sums_Tests.java
 |       +-- Numbers_7b_find_sums_duplicates_Tests.java
 |       +-- Numbers_8a_find_all_sums_Tests.java
 |       +-- Numbers_8b_find_all_sums_XL_Tests.java
 |
```


&nbsp;
## 2. Sourcing the Project

Sourcing the project means to set up the project environment:

```sh
source .env/project.sh
```

Make sure files are in the proper place. Open a terminal and navigate
to the project directory:

```sh
find src tests resources
```

Output:

```
src
src/application
src/application/Application.java
src/application/package-info.java
src/module-info.java
src/numbers
src/numbers/Numbers.java
src/numbers/NumbersImpl.java
src/numbers/package-info.java
tests
tests/application
tests/application/Application_0_always_pass_Tests.java
tests/numbers
tests/numbers/Matchers.java
tests/numbers/Numbers_1_sum_Tests.java
tests/numbers/Numbers_2_sum_positive_even_Tests.java
tests/numbers/Numbers_3_sum_recursion_Tests.java
tests/numbers/Numbers_4_find_first_Tests.java
tests/numbers/Numbers_5_find_last_Tests.java
tests/numbers/Numbers_6_find_all_Tests.java
tests/numbers/Numbers_7a_find_sums_Tests.java
tests/numbers/Numbers_7b_find_sums_duplicates_Tests.java
tests/numbers/Numbers_8a_find_all_sums_Tests.java
tests/numbers/Numbers_8b_find_all_sums_XL_Tests.java
resources
resources/application.properties
resources/logging.properties
resources/META-INF
resources/META-INF/MANIFEST.MF
```


&nbsp;
## 3. Building the Application

Command `show` shows operations for the *Build-Process*:

```sh
show
show --all
```

```
source | project:
  source .env/project.sh

classpath:
  echo $CLASSPATH | tr "[;:]" "\n"

compile:
  javac $(find src/main -name '*.java') -d bin/classes; \
  copy src/resources bin/resources

compile-tests:
  javac $(find src/tests -name '*.java') -d bin/test-classes; \
  copy src/resources bin/resources

resources:
  copy src/resources bin/resources

run:
  java application.Application

run-tests:
  java -jar libs/junit-platform-console-standalone-1.9.2.jar \
    $(eval echo $JUNIT_OPTIONS) --scan-class-path

javadoc:
  javadoc -d docs $(eval echo $JDK_JAVADOC_OPTIONS) \
    $(cd src/main; find . -type f | xargs dirname | uniq | cut -c 3-)

clean:
  rm -rf bin logs docs

wipe:
```

Execute build steps with the `build` or `mk` (make) command:

```sh
mk compile                        # compile source code
```

The last command is called a *clean build*. It clears the `bin` directory,
removes all content and re-compiles all source code.

The result is in the `bin` directory:

```sh
find bin
```

Output

```
bin
bin/classes
bin/classes/application
bin/classes/application/Application.class
bin/classes/application/package-info.class
bin/classes/application/package_info.class
bin/classes/module-info.class
bin/classes/numbers
bin/classes/numbers/Numbers$Pair.class
bin/classes/numbers/Numbers.class
bin/classes/numbers/NumbersImpl$1Command.class
bin/classes/numbers/NumbersImpl.class
bin/classes/numbers/package-info.class
bin/resources
bin/resources/application.properties
bin/resources/logging.properties
```


&nbsp;
## 4. Running the Application

After building the application, it can be run using the `run` command
and passing a number `n` to factorize.

```sh
mk run op=sum n=numbers
```

Output:

```
Hello, NumbersImpl
sum('numbers': [-2, 4, 9, 4, -3, 4, 9, 5])
 - result: sum()=0

done.
```

The invocation refers to an operation `sum()` from the
[Numbers.java](https://github.com/sgra64/se1.play/blob/b12/src/numbers/Numbers.java)
interface that adds numbers provided as argument `int[] numbers`:

```java
package numbers;

public interface Numbers {

    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * 
     * @param numbers input
     * @return sum of numbers[]
     */
    int sum(int[] numbers);
    ...
}
```

There are several numbers arrays in the implementation class
[NumbersImpl.java](https://github.com/sgra64/se1.play/blob/b12/src/numbers/NumbersImpl.java)

```java
package numbers;

public class NumbersImpl implements Numbers, Runnable {

    /*
     * Numbers with negative numbers and duplicates (n=0).
     */
    static final int[] numbers = {-2, 4, 9, 4, -3, 4, 9, 5};

    /*
     * Numbers with no negative numbers and no duplicates (n=1).
     */
    static final int[] numb_1 = {8, 10, 7, 2, 14, 5, 4};

    /*
     * Larger set of 24 numbers, no negatives, no duplicates (n=2).
     */
    static final int[] numb_2 = {   // 24 numbers
        371,  682,  446,  754,  205,  972,  600,  163,  541,  672,
         27,  170,  226,    7,  190,  639,   87,  773,  651,  370,
        125,  774,  903,  636//,225,  463,  286,  569,  384,    9,
    }; // add more numbers to find more solutions

    /*
     * Even larger set of 63 numbers, no negatives, no duplicates (n=3).
     */
    static final int numb_3[] = {
        799, 2377,  936, 3498, 1342,  493, 1635, 4676, 1613, 3851,
       1445, 4506, 3346,    7, 2141, 2064, 1491,  908,   78, 3325,
       1756, 3691,   23, 1995, 1800,   15, 2784, 4305,   36, 2532,
       4292, 4802, 2522, 4183, 3261, 2610,  803, 2656,  498, 1668,
       2038, 2194,  440,  463, 4047, 4235, 3931,  756,  521, 4042,
       3302,  485, 1002,  408, 4691, 3387, 3104, 3658, 2241, 4382,
       1220, 3656,  500,
    };
    ...
}
```

All methods defined in the `Numbers` interface are:

```
1.) sum()            - calculate sum of numbers[].
2.) sum_pen()        - sum of positive even numbers
3.) sum_rec()        - sum of numbers[] without using loops
4.) findFirst(int x)     - find index of first occurrence of x
5.) findLast(int x)      - find index of last occurrence of x
6.) findAll(int x)       - find all indices of x in numbers
7.) findSums(int sum)    - find all pairs {a, b} with a + b = sum
8.) findAllSums(int sum) - find all combinations of numbers that add to sum
```


&nbsp;
## 5. Completing Numbers Methods

Methods of the
[Numbers.java](https://github.com/sgra64/se1.play/blob/b12/src/numbers/Numbers.java)
interface are implemented in class
[NumbersImpl.java](https://github.com/sgra64/se1.play/blob/b12/src/numbers/NumbersImpl.java):

```java
package numbers;

public class NumbersImpl implements Numbers, Runnable {

    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * 
     * @param numbers input
     * @return sum of numbers[]
     */
    @Override
    public int sum(int[] numbers) {
        int result = 0;

        /*
         * TODO: write code to implement the method
         */
        return result;
    }
    ...
```

Implement the method and verify the result:

```sh
mk run op=sum n=numbers
```

The correct result for array `'numbers': [-2, 4, 9, 4, -3, 4, 9, 5]` is `30`:

```
Hello, NumbersImpl
sum('numbers': [-2, 4, 9, 4, -3, 4, 9, 5])
 - result: sum()=30

done.
```

Verify the result with other numbers arrays:

```sh
mk run op=sum n=numbers op=sum n=numb_1 op=sum n=numb_2 op=sum n=numb_3
```

Results:

```
Hello, NumbersImpl
sum('numbers': [-2, 4, 9, 4, -3, 4, 9, 5])
 - result: sum()=30

sum('numb_1': [8, 10, 7, 2, 14, 5, 4])
 - result: sum()=50

sum('numb_2': [371, 682, 446, 754, 205, 972, 600, 163, 541, 672, 27, 170, 226, 7
, 190, 639, 87, 773, 651, 370, 125, 774, 903, 636])
 - result: sum()=10984

sum('numb_3': [799, 2377, 936, 3498, 1342, 493, 1635, 4676, 1613, 3851, 1445, 45
06, 3346, 7, 2141, 2064, 1491, 908, 78, 3325, 1756, 3691, 23, 1995, 1800, 15, 27
84, 4305, 36, 2532, 4292, 4802, 2522, 4183, 3261, 2610, 803, 2656, 498, 1668, 20
38, 2194, 440, 463, 4047, 4235, 3931, 756, 521, 4042, 3302, 485, 1002, 408, 4691
, 3387, 3104, 3658, 2241, 4382, 1220, 3656, 500])
 - result: sum()=141466

done.
```

Compile and run the JUnit test for the `sum` - method:

```sh
mk compile-tests

java -jar libs/junit-platform-console-standalone-1.9.2.jar $(eval echo $JUNIT_OPTIONS) \
    -c numbers.Numbers_1_sum_Tests
```

The JUnit Test class for the `sum` - method is
[numbers.Numbers_1_sum_Tests.java](https://github.com/sgra64/se1.play/blob/b12/tests/numbers/Numbers_1_sum_Tests.java) in
[tests/numbers](https://github.com/sgra64/se1.play/blob/b12/tests/numbers).

Output of correct tests:

```
├─ JUnit Jupiter ✔
│  └─ Numbers_1_sum_Tests ✔
│     ├─ test100_sum_regular() ✔
│     ├─ test101_sum_regular() ✔
│     ├─ test102_sum_regular() ✔
│     └─ test103_sum_regular() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 161 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[         4 tests found           ]
[         0 tests skipped         ]
[         4 tests started         ]
[         0 tests aborted         ]
[         4 tests successful      ]
[         0 tests failed          ]
```

Also run the JUnit tests for the `sum()` - method in your IDE.


&nbsp;
## 6. Running JUnit Tests

Gradually complete methods one after another and verify with JUnit-Tests:

```
1.) sum()                - Numbers_1_sum_Tests.java
2.) sum_pen()            - Numbers_2_sum_positive_even_Tests.java
3.) sum_rec()            - Numbers_3_recursive_Tests
4.) findFirst(int x)     - Numbers_4_find_first_Tests
5.) findLast(int x)      - Numbers_5_find_last_Tests
6.) findAll(int x)       - Numbers_6_find_all_Tests
7.) findSums(int sum)    - Numbers_7a_find_sums_Tests, Numbers_7b_find_sums_Tests
8.) findAllSums(int sum) - Numbers_8a_find_all_sums_Tests, Numbers_8b_find_all_sums_Tests
```

When tests fail, locate the test-method and verify *expected* values
and *actual* values obtained from from your method implementation.

Run final JUnit-Tests in the IDE for the tests you managed to pass.

Remove tests from the list that do not pass:

```sh
java -jar libs/junit-platform-console-standalone-1.9.2.jar $(eval echo $JUNIT_OPTIONS) \
    -c application.Application_0_always_pass_Tests \
    -c numbers.Numbers_1_sum_Tests \
    -c numbers.Numbers_2_sum_positive_even_Tests \
    -c numbers.Numbers_3_sum_recursion_Tests \
    -c numbers.Numbers_4_find_first_Tests \
    -c numbers.Numbers_5_find_last_Tests \
    -c numbers.Numbers_6_find_all_Tests \
    -c numbers.Numbers_7a_find_sums_Tests \
    -c numbers.Numbers_7b_find_sums_duplicates_Tests \
    -c numbers.Numbers_8a_find_all_sums_Tests \
    -c numbers.Numbers_8b_find_all_sums_XL_Tests
```

Tests `Numbers_7b_find_sums_duplicates_Tests` and `Numbers_8b_find_all_sums_XL_Tests`
are hard and require solid implementations of methods.

Output when all tests pass:

```
├─ JUnit Jupiter ✔
│  ├─ Numbers_3_sum_recursion_Tests ✔
│  │  ├─ test300_sum_recursion_regular() ✔
│  │  ├─ test301_sum_recursion_regular() ✔
│  │  ├─ test302_sum_recursion_regular() ✔
│  │  └─ test303_sum_recursion_regular() ✔
│  ├─ Numbers_7b_find_sums_duplicates_Tests ✔
│  │  ├─ test710_find_sums_duplicates() ✔
│  │  ├─ test711_find_sums_same_duplicates() ✔
│  │  ├─ test712_find_sums_mirror_duplicates() ✔
│  │  └─ test713_find_sums_regular_duplicates() ✔
│  ├─ Application_0_always_pass_Tests ✔
│  │  ├─ test_001_always_pass() ✔
│  │  └─ test_002_always_pass() ✔
│  ├─ Numbers_7a_find_sums_Tests ✔
│  │  ├─ test700_find_sums_regular() ✔
│  │  ├─ test701_find_sums_regular() ✔
│  │  ├─ test702_find_sums_regular() ✔
│  │  ├─ test703_find_sums_regular() ✔
│  │  ├─ test704_find_sums_regular() ✔
│  │  ├─ test705_find_sums_regular() ✔
│  │  └─ test706_find_sums_regular() ✔
│  ├─ Numbers_8a_find_all_sums_Tests ✔
│  │  ├─ test800_find_all_sums_regular() ✔
│  │  └─ test821_find_all_sums_regular_nbrs_2_sum999() ✔
│  ├─ Numbers_2_sum_positive_even_Tests ✔
│  │  ├─ test200_sum_positive_even_numbers_regular() ✔
│  │  ├─ test201_sum_positive_even_numbers_regular() ✔
│  │  ├─ test202_sum_positive_even_numbers_regular() ✔
│  │  └─ test203_sum_positive_even_numbers_regular() ✔
│  ├─ Numbers_5_find_last_Tests ✔
│  │  ├─ test500_find_last_regular() ✔
│  │  ├─ test501_find_last_regular() ✔
│  │  ├─ test502_find_last_regular() ✔
│  │  └─ test503_find_last_regular() ✔
│  ├─ Numbers_6_find_all_Tests ✔
│  │  ├─ test600_find_all_regular() ✔
│  │  ├─ test601_find_all_regular() ✔
│  │  ├─ test602_find_all_regular() ✔
│  │  └─ test603_find_all_regular() ✔
│  ├─ Numbers_1_sum_Tests ✔
│  │  ├─ test100_sum_regular() ✔
│  │  ├─ test101_sum_regular() ✔
│  │  ├─ test102_sum_regular() ✔
│  │  └─ test103_sum_regular() ✔
│  ├─ Numbers_8b_find_all_sums_XL_Tests ✔
│  │  ├─ test824_find_all_sums_XL_24_numbers() ✔
│  │  ├─ test825_find_all_sums_XL_25_numbers() ✔
│  │  ├─ test826_find_all_sums_XL_26_numbers() ✔
│  │  ├─ test827_find_all_sums_XL_27_numbers() ✔
│  │  ├─ test828_find_all_sums_XL_28_numbers() ✔
│  │  ├─ test829_find_all_sums_XL_29_numbers() ✔
│  │  └─ test830_find_all_sums_XL_30_numbers() ✔
│  └─ Numbers_4_find_first_Tests ✔
│     ├─ test400_find_first_regular() ✔
│     ├─ test401_find_first_regular() ✔
│     ├─ test402_find_first_regular() ✔
│     └─ test403_find_first_regular() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 3403 ms
[        14 containers found      ]
[         0 containers skipped    ]
[        14 containers started    ]
[         0 containers aborted    ]
[        14 containers successful ]
[         0 containers failed     ]
[        46 tests found           ]
[         0 tests skipped         ]
[        46 tests started         ]
[         0 tests aborted         ]
[        46 tests successful      ]   <-- 46 tests successful
[         0 tests failed          ]   <-- 0 tests failed
done.
```

Run JUnit-Tests also in your IDE.


&nbsp;
## 7. Generating Javadoc

Build the javadoc for the project:

```sh
mk javadoc
```

Open `docs/index.html` in a browser.



&nbsp;
## 8. Packaging the Application

After testing, the application is ready for packaging:

```sh
mk package
```

Resulting `application-1.0.0-SNAPSHOT.jar` is in the `bin` directory.

```sh
ls -la bin
```

Output:

```
total 16
drwxr-xr-x 1 svgr2 Kein     0 Apr 14 21:55 .
drwxr-xr-x 1 svgr2 Kein     0 Apr 14 21:54 ..
-rw-r--r-- 1 svgr2 Kein 15871 Apr 14 21:55 application-1.0.0-SNAPSHOT.jar
```

Run the packaged `.jar` for a final test:

```sh
java -jar bin/application-1.0.0-SNAPSHOT.jar \
    op=sum n=numb_1 \
    op=findSums n=numb_1 sum=12 \
    op=findAllSums n=numb_1 sum=14 \
    op=findAllSums n=numb_1 sum=15 \
    op=findAllSums n=numb_2 sum=999
```

Output:

```
sum('numb_1': [8, 10, 7, 2, 14, 5, 4])
 - result: sum()=50

findSums('numb_1': [8, 10, 7, 2, 14, 5, 4]), sum=12
 - result: findSums(sum=12)=[(5,7), (4,8), (2,10)], 3 solutions

findAllSums('numb_1': [8, 10, 7, 2, 14, 5, 4]), sum=14
 - result: findAllSums(sum=14)=[[2, 4, 8], [4, 10], [2, 5, 7], [14]], 4 solutions

findAllSums('numb_1': [8, 10, 7, 2, 14, 5, 4]), sum=15
 - result: findAllSums(sum=15)=[[7, 8], [2, 5, 8], [5, 10]], 3 solutions

findAllSums('numb_2': [371, 682, 446, 754, 205, 972, 600, 163, 541, 672, 27, 170, 226, 7, 190, 639, 87, 773, 651, 370, 125, 774, 903, 636]), sum=999
 - result: findAllSums(sum=999)=[[226, 163, 371, 87, 27, 125], [226, 163, 371, 7, 27, 205], [226, 371, 170, 27, 205], [226, 371, 7, 205, 190], [371, 87, 541], [226, 371, 87, 125, 190], [226, 27, 541, 205], [27, 972], [163, 170, 125, 541], [170, 190, 639], [163, 170, 27, 639], [226, 773], [163, 7, 190, 639]], 13 solutions
```

The packaged `application-1.0.0-SNAPSHOT.jar` can now be distributed.
