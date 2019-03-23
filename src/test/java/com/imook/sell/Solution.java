package com.imook.sell;

import lombok.val;
import org.hibernate.type.TrueFalseType;
import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.test.annotation.Commit;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author KnoWsea
 * @create 2018-12-07 8:59
 */
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        char[] t = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        Solution solution = new Solution();
//        System.out.println(solution.movingCount(18, 3, 4));
    }

    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public void push(int node) {
        if(mins.isEmpty()){
            mins.push(node);
        }else{
            if(node < mins.firstElement())
                mins.push(node);
        }
        s.add(node);
    }

    public void pop() {
        if(s.isEmpty()){
            return ;
        }else{
            int node = s.pop();
            if(node == mins.firstElement())
                mins.pop();
        }
    }

    public int top() {
        return s.firstElement();
    }

    public int min() {
        return mins.firstElement();
    }
}