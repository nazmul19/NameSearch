/**
 * 
 */
package edu.contact;

import java.util.HashMap;

/**
 * @author Nazmul Hassan
 *
 */
// This is the data structure for implementing TRIE Algorithm
public class TrieNode {
	char c;
	TrieNode parent;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}

}
