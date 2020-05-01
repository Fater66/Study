package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;

public class BoundaryOfBinaryTree {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        //1.先加左边界
        if(root == null) return res;
        if(!isLeaf(root))
            res.add(root.val);
        TreeNode node = root.left;
        while(node != null)
        {
            if(!isLeaf(node))
                res.add(node.val);
            if(node.left!= null)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }
        addLeaves(root);
        node = root.right;
        Stack<Integer> stack = new Stack<>();
        while(node != null)
        {
            if(!isLeaf(node))
                stack.push(node.val);
            if(node.right!=null)
                node = node.right;
            else
                node = node.left;
        }
        while(!stack.isEmpty())
        {
            res.add(stack.pop());
        }
        return res;
    }

    private boolean isLeaf(TreeNode node)
    {
        return node.left == null && node.right == null;
    }

    private void addLeaves(TreeNode node)
    {
        if(node == null) return;
        if(isLeaf(node))
            res.add(node.val);
        else{
            addLeaves(node.left);
            addLeaves(node.right);
        }
    }
}
