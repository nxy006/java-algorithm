# 「剑指Offer —— 名企面试官精讲典型编程题 第 2 版」

## 书籍介绍

![](./book-sword_to_offer.jpg)

- **书籍名称：** 剑指Offer：名企面试官精讲典型编程题（第2版）
- **书籍介绍：** https://www.phei.com.cn/module/goods/wssd_content.jsp?bookid=49304
- **出版时间：** 2017-03
- **ISBN：** 9787121310928


## 代码库说明

本代码库每个包（即每个题目下）都具有 `SolutionTemplate` 及 `Solution` 至少两个文件， 其中 `SolutionTemplate` 是父类模板，当需要快速练习时，可以直接使用本文件，修改对应方法，即可运行 `main` 方法测试。如果需要已有的标准解法，则可查看目录下对应的 `Solution` 实现。

## 题目列表

| 题号 | 题目名称                       | 关键字 |     进度      |
| :--: | :----------------------------- | :----: | :-----------: |
|  1   | 赋值运算符函数                 |        | :o: 忽略，不适用 `Java` |
|  2   | 实现Singleton模式              |        | :o: 忽略，不适用 `Java` |
| 3-1  | 找出数组中重复的数字           |        | :heavy_check_mark: 已完成 |
| 3-2  | 不修改数组找出重复的数字       |        |               |
|  4   | 二维数组中的查找               |        |               |
|  5   | 替换空格                       |        |               |
|  6   | 从尾到头打印链表               |        |               |
|  7   | 重建二叉树                     |        |               |
|  8   | 二叉树的下一个结点             |        |               |
|  9   | 用两个栈实现队列               |        |               |
|  10  | 斐波那契数列                   |        |               |
|  22  | 链表中倒数第k个结点            |        |               |
|  23  | 链表中环的入口结点             |        |               |
|  24  | 反转链表                       |        |               |
|  25  | 合并两个排序的链表             |        |               |
|  26  | 树的子结构                     |        |               |
|  27  | 二叉树的镜像                   |        |               |
|  28  | 对称的二叉树                   |        |               |
|  29  | 顺时针打印矩阵                 |        |               |
|  30  | 包含min函数的栈                |        |               |
| 32-1 | 不分行从上往下打印二叉树       |        |               |
| 32-2 | 分行从上到下打印二叉树         |        |               |
| 32-3 | 之字形打印二叉树               |        |               |
|  33  | 二叉搜索树的后序遍历序列       |        |               |
|  34  | 二叉树中和为某一值的路径       |        |               |
|  35  | 复杂链表的复制                 |        |               |
|  36  | 二叉搜索树与双向链表           |        |               |
|  37  | 序列化二叉树                   |        |               |
|  38  | 字符串的排列                   |        |               |
|  39  | 数组中出现次数超过一半的数字   |        |               |
|  40  | 最小的k个数                    |        |               |
|  41  | 数据流中的中位数               |        |               |
|  42  | 连续子数组的最大和             |        |               |
|  43  | 从1到n整数中1出现的次数        |        |               |
|  44  | 数字序列中某一位的数字         |        |               |
|  45  | 把数组排成最小的数             |        |               |
|  46  | 把数字翻译成字符串             |        |               |
|  47  | 礼物的最大价值                 |        |               |
|  48  | 最长不含重复字符的子字符串     |        |               |
|  49  | 丑数                           |        |               |
| 50-1 | 字符串中第一个只出现一次的字符 |        |               |
| 50-2 | 字符流中第一个只出现一次的字符 |        |               |
|  51  | 数组中的逆序对                 |        |               |
|  52  | 两个链表的第一个公共结点       |        |               |
| 53-1 | 数字在排序数组中出现的次数     |        |               |
| 53-2 | 0到n-1中缺失的数字             |        |               |
|  54  | 二叉搜索树的第k个结点          |        |               |
| 55-1 | 二叉树的深度                   |        |               |
| 55-2 | 平衡二叉树                     |        |               |
| 56-1 | 数组中只出现一次的两个数字     |        |               |
| 56-2 | 数组中唯一只出现一次的数字     |        |               |
| 57-1 | 和为s的两个数字                |        |               |
| 57-2 | 为s的连续正数序列              |        |               |
| 58-1 | 翻转单词顺序                   |        |               |
| 58-2 | 左旋转字符串                   |        |               |
| 59-1 | 滑动窗口的最大值               |        |               |
| 59-2 | 队列的最大值                   |        |               |
|  60  | n个骰子的点数                  |        |               |
|  61  | 扑克牌的顺子                   |        |               |
|  62  | 圆圈中最后剩下的数字           |        |               |
|  63  | 股票的最大利润                 |        |               |
|  64  | 求1+2+…+n                      |        |               |
|  65  | 不用加减乘除做加法             |        |               |
|  66  | 构建乘积数组                   |        |               |
|  67  | 把字符串转换成整数             |        |               |
|  68  | 树中两个结点的最低公共祖先     |        |               |


### 面试题 1：赋值运算符函数

**题目：** 如下为类型CMyString的声明，请为该类型添加赋值运算符函数。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/01_AssignmentOperator


### 面试题 2：实现Singleton模式

**题目：** 设计一个类，我们只能生成该类的一个实例。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/02_Singleton


### 面试题 3：找出数组中重复的数字

**题目一：找出数组中重复的数字**

- 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
- 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/03_01_DuplicationInArray

**题目二：不修改数组找出重复的数字**

- 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
- 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/03_02_DuplicationInArrayNoEdit


### 面试题 4：二维数组中的查找

**题目：** 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/04_FindInPartiallySortedMatrix


### 面试题 5：替换空格

**题目：** 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/05_ReplaceSpaces


### 面试题 6：从尾到头打印链表

**题目：** 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/blob/master/06_PrintListInReversedOrder


### 面试题 7：重建二叉树

**题目：** 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出图2.6所示的二叉树并输出它的头结点。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/07_ConstructBinaryTree


### 面试题8：二叉树的下一个结点

**题目：** 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/08_NextNodeInBinaryTrees


### 面试题 9：用两个栈实现队列

**题目：** 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 ·deleteHead`，分别完成在队列尾部插入结点和在队列头部删除结点的功能。


### 面试题 10：斐波那契数列

**题目一：** 写一个函数，输入 n，求斐波那契（Fibonacci）数列的第 `n` 项。

**题目二：** 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

**官解：** https://github.com/zhedahht/CodingInterviewChinese2/tree/master/10_Fibonacci


### 面试题 22：链表中倒数第k个结点

题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是值为4的结点。


### 面试题 23：链表中环的入口结点

题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，环的入口结点是结点3。

### 面试题 24：反转链表

题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。



### 面试题 25：合并两个排序的链表

题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链表3所示。


### 面试题 26：树的子结构

题目：输入两棵二叉树A和B，判断B是不是A的子结构。


### 面试题 27：二叉树的镜像

题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。

### 面试题 28：对称的二叉树

题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/28_SymmetricalBinaryTree

### 面试题 29：顺时针打印矩阵

题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/29_PrintMatrix

### 面试题 30：包含min函数的栈

题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/30_MinInStack

### 面试题 32：打印二叉树

题目一：不分行从上往下打印二叉树
- 内容：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
- 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/32_01_PrintTreeFromTopToBottom

题目二：分行从上到下打印二叉树
- 内容：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
- 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/32_02_PrintTreesInLines

题目三：之字形打印二叉树
- 内容：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
- 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/32_03_PrintTreesInZigzag

### 面试题 33：二叉搜索树的后序遍历序列

题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/33_SquenceOfBST


### 面试题 34：二叉树中和为某一值的路径

题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/34_PathInTree



### 面试题 35：复杂链表的复制

题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/35_CopyComplexList

### 面试题 36：二叉搜索树与双向链表

题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/36_ConvertBinarySearchTree

### 面试题 37：序列化二叉树

题目：请实现两个函数，分别用来序列化和反序列化二叉树。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/37_SerializeBinaryTrees
 
### 面试题 38：字符串的排列

题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/38_StringPermutation


### 面试题 39：数组中出现次数超过一半的数字

题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/39_MoreThanHalfNumber

### 面试题 40：最小的k个数

题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/40_KLeastNumbers

### 面试题 41：数据流中的中位数

题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/41_StreamMedian


### 面试题 42：连续子数组的最大和

题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/42_GreatestSumOfSubarrays

### 面试题 43：从1到n整数中1出现的次数

题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/43_NumberOf1

### 面试题 44：数字序列中某一位的数字

题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数求任意位对应的数字。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/44_DigitsInSequence

### 面试题 45：把数组排成最小的数

题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数字能排成的最小数字321323。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/45_SortArrayForMinNumber

### 面试题 46：把数字翻译成字符串

题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和"mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/46_TranslateNumbersToStrings

### 面试题 47：礼物的最大价值

题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/47_MaxValueOfGifts

### 面试题 48：最长不含重复字符的子字符串

题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从'a'到'z'的字符。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/48_LongestSubstringWithoutDup

### 面试题 49：丑数

题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/49_UglyNumber

### 面试题 50：字符串中第一个只出现一次的字符

- 题目一：字符串中第一个只出现一次的字符
  - 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/50_01_FirstNotRepeatingChar

- 题目二：字符流中第一个只出现一次的字符
  - 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/50_02_FirstCharacterInStream

### 面试题 51：数组中的逆序对

题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/51_InversePairs


### 面试题 52：两个链表的第一个公共结点

题目：输入两个链表，找出它们的第一个公共结点。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/52_FirstCommonNodesInLists

### 面试题 53：数字在排序数组中出现的次数

- 题目一：数字在排序数组中出现的次数
  - 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组 {1, 2, 3, 3, 3, 3, 4, 5} 和数字3，由于3在这个数组中出现了4次，因此输出4。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/53_01_NumberOfK

- 题目二：0到n-1中缺失的数字
  - 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/53_02_MissingNumber

### 面试题 54：二叉搜索树的第k个结点

题目：给定一棵二叉搜索树，请找出其中的第k大的结点。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/54_KthNodeInBST


### 面试题 55：二叉树的深度

- 题目一：二叉树的深度
  - 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/55_01_TreeDepth

- 题目二：平衡二叉树
  - 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/55_02_BalancedBinaryTree

### 面试题 56：数组中只出现一次的两个数字

- 题目一：数组中只出现一次的两个数字
  - 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/56_01_NumbersAppearOnce

- 题目二：数组中唯一只出现一次的数字
  - 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个吃出现一次的数字。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/56_02_NumberAppearingOnce

### 面试题 57：和为s的两个数字

- 题目一：和为s的两个数字
  - 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/57_01_TwoNumbersWithSum

- 题目二：为s的连续正数序列
  - 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/57_02_ContinuousSquenceWithSum

### 面试题 58：翻转单词顺序

- 题目一：翻转单词顺序
  - 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/58_01_ReverseWordsInSentence

- 题目二：左旋转字符串
  - 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/58_02_LeftRotateString

### 面试题 59：滑动窗口的最大值

- 题目一：滑动窗口的最大值
  - 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/59_01_MaxInSlidingWindow

- 题目二：队列的最大值
  - 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
  - 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/59_02_QueueWithMax
 

### 面试题 60：n个骰子的点数

题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/60_DicesProbability

### 面试题 61：扑克牌的顺子

题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/61_ContinousCards

### 面试题 62：圆圈中最后剩下的数字

题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/62_LastNumberInCircle

### 面试题 63：股票的最大利润

题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/63_MaximalProfit

### 面试题 64：求1+2+…+n

题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/64_Accumulate

### 面试题 65：不用加减乘除做加法

题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/65_AddTwoNumbers

### 面试题 66：构建乘积数组

题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/66_ConstuctArray

### 面试题 67：把字符串转换成整数

题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不能使用atoi或者其他类似的库函数。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/67_StringToInt

### 面试题 68：树中两个结点的最低公共祖先

题目：输入两个树结点，求它们的最低公共祖先。

官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/68_CommonParentInTree


