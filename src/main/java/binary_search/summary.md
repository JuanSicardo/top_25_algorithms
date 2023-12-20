Binary Search
=============

As the name implies this is a search algorithm. The prerequisite to use it is that the data structure that holds the elements you want to search for needs to be sorted.

General Idea
------------

The algorithms steps are:

1. Find the element at the middle of your data structure.
2. Compare the middle to the element you are searching for.
3. If the middle element is your target, then you are done, but if not do the following:
    1. If the target is smaller than the middle that means that your target should be in the half where the smaller elements are at.
   2. If the target is bigger that the middle that means that your target should be in the half where the bigger elements are at.
4. Repeat this process until you find the target, or you have exhausted the search space.

Complexity
----------

If:
* `n` is the number of elements in the array

* Time complexity: `O(log(n))`
* Space complexity: `O(1)`

Drawbacks
---------

* The data structure should be sorted first.
* The elements of the searched data structure need to be comparable (they can be sorted).