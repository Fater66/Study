import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        WordFilter wordFilter = new WordFilter(new String[]{"a","a","a","b","b"});
        System.out.println(wordFilter.f("a","a"));
        TreeSet<Integer> set1  = new TreeSet();
        TreeSet<Integer> set2 = new TreeSet<>(set1);

        HashMap<Pair<String,String>,Integer> map = new HashMap();
        map.put(new Pair<>("a","a"),3);
        System.out.println(map.get(new Pair<>("b","a")));
        int[] ne = {2,3,2,1};
        Arrays.so
    }


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}

class WordFilter {

    TrieTree preTree;
    TrieTree suffTree;

    public WordFilter(String[] words) {
        preTree = new TrieTree();
        suffTree = new TrieTree();
        for(int i = 0;i<words.length;i++)
        {
            preTree.add(words[i],i);
            suffTree.add(new StringBuilder(words[i]).reverse().toString(),i);
        }
    }

    public int f(String prefix, String suffix) {
        TreeSet<Integer> pre = preTree.search(prefix);
        TreeSet<Integer> suff = suffTree.search(new StringBuilder(suffix).reverse().toString());
        while(!pre.isEmpty() && !suff.isEmpty())
        {
            int w1 = pre.last();
            int w2 = suff.last();
            if(w1 > w2) pre.remove(w1);
            else if (w1 < w2) suff.remove(w2);
            else return w1;
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

class TrieNode{
    char ch;
    int freqs;  //记录单词出现次数
    TreeSet<Integer> weightSet;//record weight which has corresponding prefix or suffix
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freqs, TreeSet<Integer> weightSet, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freqs = freqs;
        this.weightSet = weightSet;
        this.nodeMap = nodeMap;
    }
}

/**
 * 描述: 字典树的实现
 *
 */
class TrieTree {

    private TrieNode root;

    public TrieTree(){
        root = new TrieNode('\u0000', 0, new TreeSet<Integer>(), new HashMap<Character, TrieNode>());
    }

    /**
     * 查询str字符串是否存在，不存在返回0，存在返回该字符串的个数
     * @param str
     * @return
     */

    public int query(String str){
        TrieNode cur=root;
        if(root==null){
            return 0;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return 0;
            }else {
                cur = child;
            }
        }
        return cur.freqs;
    }
    /**
     *添加单词
     */
    public void add(String str,int weight){
        TrieNode cur=root;
        root.weightSet.add(weight);
        if(root==null){
            return;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));

            if(child==null){
                TrieNode node=new TrieNode(str.charAt(i),0,new TreeSet<Integer>(),new HashMap<Character, TrieNode>());
                cur.nodeMap.put(str.charAt(i),node);
                cur.weightSet.add(weight);
                cur=cur.nodeMap.get(str.charAt(i));
            }else{
                cur=child;
                cur.weightSet.add(weight);
            }
        }
        cur.freqs++;
        cur.weightSet.add(weight);
    }

    /**
     * 判断str是否存在
     * @param str
     * @return treeset
     */

    public TreeSet search(String str){
        TrieNode cur=root;
        if(root==null){
            return new TreeSet<Integer>();
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return new TreeSet<Integer>();
            }else {
                cur = child;
            }
        }
        return cur.weightSet;
    }
}