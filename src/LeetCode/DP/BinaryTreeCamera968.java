package LeetCode.DP;

import Tool.TreeNode;

public class BinaryTreeCamera968 {
    /**
     * Given a binary tree, we install cameras on the nodes of the tree. 
     *
     * Each camera at a node can monitor its parent, itself, and its immediate children.
     *
     * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
     *
     * Input: [0,0,null,0,0]
     * Output: 1
     * Explanation: One camera is enough to monitor all nodes if placed as shown.
     */

    public int minCameraCover(TreeNode root) {
        if(root == null)
            return 0;
        int[] result = solve(root);
        //注意root 不可能是状态1
        return Math.min(result[1],result[2]);
    }

    private int[] solve(TreeNode currNode)
    {
        if(currNode == null)
            return new int[]{0,0,99999};
        int[] L = solve(currNode.left);
        int[] R = solve(currNode.right);

        int mL = Math.min(L[1],L[2]);
        int mR = Math.min(R[1],R[2]);
        int[] dp = new int[3];
        //1.森严的子树，自己没有被覆盖 但是之下的子树全被覆盖，所以两个字节点必定都是正常子树
        dp[0] = L[1] + R[1];
        //2.正常的子树，自己和之下的子树都被覆盖 但是该节点没有摄像头,必定有一个子节点处于状态3
        dp[1] = Math.min(L[2] + mR,R[2] + mL);
        //3.该节点有摄像头，子节点状态都可以
        dp[2] = 1+ Math.min(L[0],mL) + Math.min(R[0],mR);
        return dp;
    }

}
