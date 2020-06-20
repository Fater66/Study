import Tool.TreeNode;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.numberOfPatterns(2,2));
        TreeNode root = TreeNode.mkTree("[0,1,null,2,3]");
        System.out.println(test.minCameraCover(root));
        int[] sss = new int[]{3,2,1};

    }

    HashSet<TreeNode> set;
    int total;
    int result;
    public int minCameraCover(TreeNode root) {
        set = new HashSet<TreeNode>();
        total = count(root);
        result = Integer.MAX_VALUE;
        addCamera(root,root,false,0);
        return result;
    }

    private int count(TreeNode node)
    {
        if(node == null)
            return 0;
        return 1 + count(node.left) + count(node.right);
    }

    private void addCamera(TreeNode currNode, TreeNode preNode, boolean isPreCamera, int cameraAmount)
    {
        if(currNode == null)
        {
            if(set.size() == total)
                result = Math.min(result,cameraAmount);
            return;
        }

        if(isPreCamera)
            set.add(currNode);
        //第一种 自己是camera
        set.add(preNode);
        set.add(currNode);
        addCamera(currNode.left,currNode,true,cameraAmount+1);
        addCamera(currNode.right,currNode,true,cameraAmount+1);
        if(!isPreCamera)set.remove(currNode);
        set.remove(preNode);

        //第二种
        addCamera(currNode.left,currNode,false,cameraAmount);
        addCamera(currNode.right,currNode,false,cameraAmount);

        return;
    }
}