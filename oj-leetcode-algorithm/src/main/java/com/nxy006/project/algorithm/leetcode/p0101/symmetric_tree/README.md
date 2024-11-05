# 101. Symmetric Tree

- **Difficulty**: `Easy`
- **Tag**: `Tree`, `Depth-First Search`, `Breadth-First Search`, `Binary Tree`
- **Origin Link**: [Symmetric Tree - LeetCode](https://leetcode.com/problems/symmetric-tree/)


## Description

Given the `root` of a binary tree, *check whether it is a mirror of itself* (i.e., symmetric around its center).


## Example

### Example 1

![](./symtree1.jpg)

```
Input: root = [1,2,2,3,4,4,3]
Output: true
```

### Example 2

![](./symtree2.jpg)

```
Input: root = [1,2,2,null,3,null,3]
Output: false
```

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`


## Default code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
    }
}
```
