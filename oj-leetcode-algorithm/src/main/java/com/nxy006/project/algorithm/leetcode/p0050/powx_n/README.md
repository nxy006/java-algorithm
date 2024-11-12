# 50. Pow(x, n) `Medium`

- **Origin Link**: [https://leetcode.com/problems/powx-n/](https://leetcode.com/problems/powx-n/)
- **Tag**: `math`,  `binary-search`


## Description

Implement [pow(x, n)](http://www.cplusplus.com/reference/valarray/pow/), which calculates `x` raised to the power `n` (i.e., `xn`).


## Example

**Example 1:**

```
Input: x = 2.00000, n = 10
Output: 1024.00000
```

**Example 2:**

```
Input: x = 2.10000, n = 3
Output: 9.26100
```

**Example 3:**

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```


## Constraints

- $-100.0 < x < 100.0$
- $-2^{31} <= n <= 2^{31}-1$
- $-10^4 <= x^n <= 10^4$


## Solution Template

题目本身难度不高，主要是细节问题：因为 n 的范围非常大，要考虑对 n 的处理时不能越界，且特殊取值要尽早退出避免超时

```java
class Solution {
    public double myPow(double x, int n) {
        // 注意这里要直接计算 1/x 的幂，而非计算 x^n 后再用 1 除
        // 原因是当 n 非常大时，后续计算 x^n 会非常耗时，而用 1/x 就能在结果为 0 时尽快退出循环
        if (n < 0) {
            x = 1.0 / x;
        }

        // 特殊值直接处理
        if (x == 1.0 || x == 0.0) {
            return x;
        } else if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }

        // 注意 n 的范围是 int 范围
        // 如果在 n 为 MIN_VALUE 时调用 Math.abs 会返回零，导致运算错误
        double result = 1;
        if (n == Integer.MIN_VALUE) {
            result = x;
            n = Integer.MAX_VALUE;
        } else {
            n = Math.abs(n);
        }

        while(n-- > 0) {
            result *= x;

            // 同上说明，用于在 n 较大时尽早退出
            if (result == 0.0) {
                return result;
            }
        }
        return result;
    }
}
```
