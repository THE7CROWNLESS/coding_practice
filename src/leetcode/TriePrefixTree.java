package leetcode;

//前缀树
//前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//重点：26位数组，本身位置表示字母，
//             然后是否为空表示存在与否，
//             isEnd表示是否为结束
public class TriePrefixTree {

    private TriePrefixTree[] next;
    boolean isEnd;

    public TriePrefixTree() {
        isEnd = false;
        next = new TriePrefixTree[26];
    }

    public void insert(String word) {
        TriePrefixTree node = this;         //通过循环外的变量，保存当前比较的节点；并且学会用this赋值
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';            //字母转数字操作
            if (node.next[index] == null){
                node.next[index] = new TriePrefixTree();
            }
            node = node.next[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TriePrefixTree node = this;
        node = searchPrefix(word,node);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TriePrefixTree node = this;
        return searchPrefix(prefix,node) != null;
    }

    public TriePrefixTree searchPrefix(String word,TriePrefixTree node){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.next[index] == null){
                return node.next[index];
            }else {
                node = node.next[index];
            }
        }
        return node;
    }
}
