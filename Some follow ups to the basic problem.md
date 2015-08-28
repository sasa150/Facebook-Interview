# Some follow ups to the basic problem

1.strStr->anaStrStr: now you shoud find any permutations string of the needle in the haystack. i.e anaStrStr("abcd", "cb") -> true
the best method is to write you own hash function to hash a count array, check: group anagrams and two strings are anagram prblem
2.threeSum->fourSum(same is find A+B=C+D): naive way is to add a new for loop and reduce this problem to threeSum. Another way is to use hashtable. First
generate all the pairs (O(n^2)), then use two sum algorithm to search for the two pairs.
3.target arrangement I and II: you have serval tasks. k is the interval time between two same task. I. you should keep the order of the tasks
how much time you should spend to complete all the tasks:ABACD, 3 -> 7 because AB__ACD II. you don't need to keep the order of the tasks, find 
the shortest time you spend to complete all the problems
I. use a hashtable to record the lastime of the each task
II. greedy, count the frequence to each task. Then always choose the valid task with highest frequence. each time you should also update the frequence. 
4.find Kth largest or smallest elemnt in an unsorted array: 1. MinHeap(Maxheap) 2. quich select(do the parition step of quick sort until you at k)
5.find Kth item(or median) in AVL: count the nodes of the left subtree, and judge whether you have done. Notice that if the tree is not AVL, you should
anayzle the worst case, that is not the same time complexity.
6.print a tree: this is not just a travsal, you need to print the tree tree like. My method is to store all the space and branches in a matrix.
7.print a tree vertically: check the problem on geeks for geeks http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 
