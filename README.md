# Threads Sort
Bubble Sort Parallel - Pipeline Approach


## Introduction
This repository contains a Parallel Bubble Sort implementation. The parallelism uses threads to optimize the algorithm. The code was implemented in JAVA.

## Test Environment
- Computer: Asus Intel i7  
- SO: Linux Min 19.1  
- IDE: JetBrains  

## Results

This table shows his performance in test environment.

| Threads/Input | 1.000 | 5.000  | 10.000  |
|---------------|-------|--------|---------|
| 1             | 1.354 | 40.803 | 243.879 |
| 2             | 997   | 16.547 | 142.010 |
| 4             | 799   | 9.487  | 107.369 |
| 6             | 761   | 11.162 | 95.644  |
| 8             | 720   | 17.199 | 75.249  |
| 10            | 905   | 18.391 | 108.395 |
| 12            | 833   | 16.131 | 105.712 |
| 14            | 863   | 17.066 | 98.366  |
| 16            | 800   | 18.113 | 92.755  |
| 18            | 809   | 18.062 | 89.235  |
| 20            | 917   | 19.759 | 95.952  |

*time in milliseconds


## How to Run
