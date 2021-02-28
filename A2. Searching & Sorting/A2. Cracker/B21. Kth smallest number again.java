Problem
 HackerEarth Question: Dexter was good in finding the K th smallest number from a set of numbers. He thought he could solve any problem related to K th smallest number. His friend Pipi challenged him with a problem.
He gave him various ranges of number, These numbers were arranged in increasing order(only distinct numbers to be taken into account). Now he asked him to find the K th smallest number in the sequence, again and again.

//GFG Question
Find k-th smallest element in given n ranges
Difficulty Level : Medium
 Last Updated : 09 Dec, 2020
Given n and q, i.e, the number of ranges and number of queries, find the kth smallest element for each query (assume k>1).Print the value of kth smallest element if it exists, else print -1.

Examples : 

Input : arr[] = {{1, 4}, {6, 8}}
        queries[] = {2, 6, 10};
Output : 2
         7
        -1
After combining the given ranges, the numbers
become 1 2 3 4 6 7 8. As here 2nd element is 2,
so we print 2. As 6th element is 7, so we print
7 and as 10th element doesn't exist, so we
print -1.

Input : arr[] = {{2, 6}, {5, 7}}
        queries[] = {5, 8};
Output : 6
        -1
After combining the given ranges, the numbers 
become 2 3 4 5 6 7. As here 5th element is 6, 
so we print 6 and as 8th element doesn't exist, 
so we print -1.

  
