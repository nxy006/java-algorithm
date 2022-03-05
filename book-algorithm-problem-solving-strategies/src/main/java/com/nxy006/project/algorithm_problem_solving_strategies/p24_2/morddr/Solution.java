package com.nxy006.project.algorithm_problem_solving_strategies.p24_2.morddr;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        while(c-- > 0) {
            int m = scanner.nextInt(), q = scanner.nextInt();

            int[] minTree = new int[4 * m], maxTree = new int[4 * m], arr = new int[m];
            for(int i = 0; i < m; i++) {
                arr[i] = scanner.nextInt();
            }
            init(maxTree, 1, 0, m-1, arr);
            for(int i = 0; i < m; i++) {
                arr[i] = arr[i] * -1;
            }
            init(minTree, 1, 0, m-1, arr);

            for(int i = 0; i < q; i++) {
                int start = scanner.nextInt(), end = scanner.nextInt();
                System.out.println(query(maxTree, 1, 0, m-1, start, end) + query(minTree, 1, 0, m-1, start, end));
            }
        }
    }

    private static int init(int[] tree, int i, int l, int r, int[] arr) {
        if (l == r) {
            return tree[i] = arr[l];
        }

        int mid = (l + r) / 2;
        return tree[i] = Integer.max(init(tree, 2*i, l, mid, arr), init(tree, 2*i+1, mid+1, r, arr));
    }

    private static int query(int[] tree, int i, int nl, int nr, int l, int r) {
        if (r < nl || nr < l) return Integer.MIN_VALUE;
        if (l <= nl && nr <= r) return tree[i];

        int mid = (nl + nr) / 2;
        return Integer.max(query(tree, 2*i, nl, mid, l, r), query(tree, 2*i+1, mid+1, nr, l, r));
    }
}
