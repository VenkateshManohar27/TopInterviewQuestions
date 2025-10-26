package com.ven.hard.design;

import java.util.*;

class Sentence implements Comparable<Sentence> {
    String sentence;
    int times;

    public Sentence(String s, int times) {
        this.sentence = s;
        this.times = times;
    }

    @Override
    public int compareTo(Sentence other) {
        if (other.times == this.times) {
            return sentence.compareTo(other.sentence);
        } else {
            return other.times - this.times;
        }
    }


    public String toString() {
        return "[" + sentence + "," + times + "]";
    }
}

class CharNode {
    public CharNode[] children;
    Map<Character, CharNode> charNodeMap;
    PriorityQueue<Sentence> sentences;
    boolean isEnd;

    public CharNode() {
        charNodeMap = new HashMap<>();
        sentences = new PriorityQueue<Sentence>();
        isEnd = false;
    }


    public String toString() {
        return "charNodeMap = " + charNodeMap.keySet() + ", sentences = " + sentences + " , end :" + isEnd;
    }

}

public class AutocompleteSystem {
    CharNode root = new CharNode();
    StringBuilder sb = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addSentence(sb.toString(), 1);
            List<String> li = find(sb.toString());
            sb = new StringBuilder();
            return li;
        }
        sb.append(c);
        List<String> li = find(sb.toString());
        return li;
    }

    private List<String> find(String s) {
        CharNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.charNodeMap.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.charNodeMap.get(c);
        }

        int j = 0;
        PriorityQueue<Sentence> pq = node.sentences;
        PriorityQueue<Sentence> clonedPQ = new PriorityQueue<>(pq);
        int end = Math.min(pq.size(), 3);
        List<String> li = new ArrayList<>();

        for (j = 0; j < end; j++) {
            if (clonedPQ.isEmpty()) {
                break;
            }
            Sentence sen = clonedPQ.poll();
            li.add(sen.sentence);
        }
        return li;
    }

    private void addSentence(String sentence, int times) {
        CharNode node = root;
        //System.out.println(node);
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!node.charNodeMap.containsKey(c)) {
                CharNode newnode = new CharNode();
                node.charNodeMap.put(c, newnode);
            }
            node = node.charNodeMap.get(c);
            node.sentences.offer(new Sentence(sentence, times));
            //System.out.println(node);
        }

        node.isEnd = true;
        //  System.out.println(node);
    }
}