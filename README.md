Synthesis-of-Gates
==================

Synthesis of trees of Gates minimizes the arrival time at the output using Dynamic Programming concept.

Algorithm Description:
1. Creation of array lists for Pin file data and gate library data. 
2. Taking the data of pin file into leaves of tree and then add to array list.
3. we take a float array list and add delays of gates. 
4. we extract the min delay in library file and corresponding cost.
5. Find the minimum of arrival input and check for the consecutive leaves of this min for which the gate is implement tg=max(tx,ty) + dg and acting as parent. Add the cost for adding the gate.
6. Remove the element from the array list and add the new element. 
7. Repeat the steps 5 and 6 till only one element remains in the list.
8. the root element of tree is the optimized gate arrival output. 

Runtime Analysis: Suppose there are N inputs and M gates then O(M+N) to get the data to array list and doing delete, insert and addition operation will take O(N) time. A total of O(N) time it takes.

Solution Extraction:The solution is extracted by using array list operations and few conditions on array data. Instead of checking all the combinations for gate delays, we just take the minimum and operate on them and then delete them after adding a gate. 

Example Instance: 
Input file: 6  2 6.0 3.0 4.0 7.0 2.0 3.0 
Gate library file: 3 5.0 1 4.5 1 3.5 3 

Output: 
optimized arrival time is:14.5 
Cost is:15 
The Topolgy in Postfix Notation : 6.0 3.0 4.0 7.5 11.0 7.0 2.0 3.0 6.5 10.5 14.5
