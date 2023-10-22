Given an matrix M of size l*n containing integers with the following two properties:

 - Each row is sorted in non-decreasing order.
 - The first integer of each row is greater than the last integer of the previous row.

Given an integer target x, return true if target is in matrix, false otherwise.

## Input Format:
```
l, n
x
    [ a b c ]
M = [ d e f ]
    [ g h i ]
```

## Example:
Input:
```
4, 3
3
matrix = [[1,3,5,7],
         [10,11,16,20],
         [23,30,34,60]] 
```


Output: 
```
true
```

## Example 2:
Input: 
```
4, 3
13
matrix = [[1,3,5,7],
         [10,11,16,20],
         [23,30,34,60]]
```

Output: 
```
false
```
