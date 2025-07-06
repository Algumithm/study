import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0; // 이 prefix를 지나간 단어 수
}

class Solution {
    TrieNode root = new TrieNode();

    // Trie에 단어 삽입
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.count++;
        }
    }

    // 고유 prefix 길이 찾기
    private int getUniquePrefixLength(String word) {
        TrieNode node = root;
        int len = 0;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            len++;
            if (node.count == 1) break; // 여기서 고유해짐
        }
        return len;
    }
    
    void printTrie(TrieNode node, String prefix) {
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode child = entry.getValue();
            System.out.println(prefix + "└─ '" + ch + "' (count=" + child.count + ")");
            printTrie(child, prefix + "    ");
        }
    }

    public int solution(String[] words) {
        for (String word : words) {
            insert(word);
        }
        System.out.println("===== Trie 구조 출력 =====");
        printTrie(root, "");
        int answer = 0;
        for (String word : words) {
            answer += getUniquePrefixLength(word);
        }
        return answer;
    }
}
