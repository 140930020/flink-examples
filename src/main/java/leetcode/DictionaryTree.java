package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangqiuyue
 * @author 2022/7/7
 */
public class DictionaryTree {
    public static void main(String[] args) {
        DictionaryTree dictionaryTree = new DictionaryTree();
        String s = dictionaryTree.replaceWords(
                Arrays.asList(
                        "ad", "af", "aff"
                ),
                "the aff afff"
        );
        System.out.println(s);
    }

    public String replaceWords(List<String> dictionaryList, String sentence) {
        Trie trie = buildTrie(dictionaryList);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    private Trie buildTrie(List<String> dictionaryList) {
        Trie trie = new Trie();

        for (int i = 0; i < dictionaryList.size(); i++) {
            Trie cur = trie;
            String dictionaryWord = dictionaryList.get(i);
            for (int j = 0; j < dictionaryWord.length(); j++) {
                char triekey = dictionaryWord.charAt(j);
                cur.children.putIfAbsent(triekey, new Trie());
                cur = cur.children.get(triekey);
            }
            cur.children.put('#', new Trie());
        }
        return trie;
    }

    String findRoot(String word, Trie trie) {
        StringBuilder matchString = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return matchString.toString();
            } else if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return word;
            }
            matchString.append(c);
        }
        return matchString.toString();
    }

}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }

}