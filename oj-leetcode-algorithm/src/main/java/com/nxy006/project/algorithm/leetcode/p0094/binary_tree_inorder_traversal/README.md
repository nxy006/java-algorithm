# 94. Binary Tree Inorder Traversal `Easy`

- **Origin Link**: [https://leetcode.com/problems/binary-tree-inorder-traversal/](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Tag**: `hash-table`, `stack`, `tree`


## Description

Given the `root` of a binary tree, return *the inorder traversal of its nodes' values*.

**Follow up:** Recursive solution is trivial, could you do it iteratively?


## Example

**Example 1:**

![](./inorder_1.jpg)

```
Input: root = [1,null,2,3]
Output: [1,3,2]
```

**Example 2:**

```
Input: root = []
Output: []
```

**Example 3:**

```
Input: root = [1]
Output: [1]
```

**Example 4:**

![](./inorder_5.jpg)

```
Input: root = [1,2]
Output: [2,1]
```

**Example 5:**

![](./inorder_4.jpg)

```
Input: root = [1,null,2]
Output: [1,2]
```


## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`


## Solution Template

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
    }
}
```
