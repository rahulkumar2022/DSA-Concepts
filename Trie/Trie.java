package Trie;

public class Trie {
    static class Node{
        Node[] links = new Node[26];
        boolean flag = true;

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch,Node node){
            links[ch-'a'] = node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }
    private Node root;
    public Trie(){
        this.root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix){
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Insetion words: ");
        trie.insert("strinver");

    }
}
