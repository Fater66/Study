import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"e","ey","eyj","d"}));
    }
}

class Solution {
    String result;
    TrieTree trieTree;
    public String longestWord(String[] words) {
        result = "";
        trieTree = new TrieTree();
        for(String word:words)
        {
            trieTree.add(word);
        }
        TrieNode node = trieTree.getRoot();
        dfs(node,"");
        return result;
    }

    private void dfs(TrieNode node,String s)
    {
        if(node != trieTree.getRoot() && node.freqs == 0)
        {
            return;
        }
        if(node != trieTree.getRoot()) s = s + node.ch;
        if(node.nodeMap.isEmpty() || node.freqs > 0)
        {
            if (s.length() > result.length() || s.length() == result.length() && s.compareTo(result) < 0)
                result = s;
            if(node.nodeMap.isEmpty())return;
        }
        for(Character child:node.nodeMap.keySet())
        {
            dfs(node.nodeMap.get(child),new String(s));
        }
    }
}

class TrieNode{
    char ch;
    int freqs;  //记录单词出现次数
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freqs, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freqs = freqs;
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
        root = new TrieNode(' ', 0, new HashMap<Character, TrieNode>());
    }

    public TrieNode getRoot()
    {
        return root;
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
    public void add(String str){
        TrieNode cur=root;
        if(root==null){
            return;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                TrieNode node=new TrieNode(str.charAt(i),0,new HashMap<Character, TrieNode>());
                cur.nodeMap.put(str.charAt(i),node);
                cur=cur.nodeMap.get(str.charAt(i));
            }else{
                cur=child;
            }
        }
        cur.freqs++;
    }

    /**
     * 判断str是否存在
     * @param str
     * @return
     */

    public boolean search(String str){
        TrieNode cur=root;
        if(root==null){
            return false;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return false;
            }else {
                cur = child;
            }
        }
        return true;
    }


    /**
     * 删除str字符串
     * 三种情况
     *
     */
    public void remove(String str) {
        if(search(str)==false){
            return;
        }
        TrieNode cur=root;
        TrieNode delPreNode=root;
        char delch=str.charAt(0);
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child.nodeMap==null){  //后面没有结点
                return;
            }else if(i<str.length()-1 && (child.nodeMap.get(str.charAt(i+1))!=null) && child.nodeMap.size()>0){
                delPreNode=child;
                delch=str.charAt(i+1);
            }
            cur=child;
        }
        if(cur.nodeMap.size()>0){
            cur.freqs=0;
        }else{
            cur.nodeMap.remove(delch);
        }
    }
}
