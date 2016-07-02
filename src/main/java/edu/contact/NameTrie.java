/**
 * 
 */
package edu.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Nazmul Hassan
 *
 */
public class NameTrie {
	private TrieNode root;
	ArrayList<String> foundNames;
	TrieNode prefixRoot;
	String curPrefix;

	public NameTrie() {
		root = new TrieNode();
		foundNames = new ArrayList<String>();
	}

	// Inserts a name into the trie data structure
	public void insert(String name) {
		HashMap<Character, TrieNode> children = root.children;

		TrieNode crntparent;

		crntparent = root;

		// current children parent = root
	
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);

			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				t.parent = crntparent;
				children.put(c, t);
			}

			children = t.children;
			crntparent = t;

			// set leaf node
			if (i == name.length() - 1)
				t.isLeaf = true;
		}
	}

	// Returns if the name is in the trie.
	public boolean search(String name) {
		TrieNode t = searchNode(name);
		if (t != null && t.isLeaf) {
			return true;
		} else {
			return false;
		}
	}

	// Returns if there is any name in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null) {
			return false;
		} else {
			return true;
		}
	}

	public TrieNode searchNode(String str) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}

		prefixRoot = t;
		curPrefix = str;
		foundNames.clear();

		return t;
	}

	public void nameMatchBuilder(TrieNode node, int offset) {
		// IF Node is Leaf then collect & make name using horizontal character
		// stack
		// Exact match come first because we are adding isLeaf node name first
		if (node.isLeaf == true) {

			TrieNode altair;
			altair = node;

			Stack<String> horizontalStack = new Stack<String>();

			while (altair != prefixRoot) {
				horizontalStack.push(Character.toString(altair.c));
				altair = altair.parent;
			}

			String wrd = curPrefix;

			while (horizontalStack.empty() == false) {
				wrd = wrd + horizontalStack.pop();
			}

			foundNames.add(wrd);

		}

		Set<Character> kset = node.children.keySet();
		Iterator<Character> itr = kset.iterator();
		ArrayList<Character> aloc = new ArrayList<Character>();

		while (itr.hasNext()) {
			Character ch = (Character) itr.next();
			aloc.add(ch);
		}

		for (int i = 0; i < aloc.size(); i++) {
			nameMatchBuilder(node.children.get(aloc.get(i)), offset);
		}

	}

	public void displayFoundNames() {
		System.out.println("***************** Matching Name(s) *******************");
		for (int i = 0; i < foundNames.size(); i++) {
			System.out.println(foundNames.get(i));
		}
	}
	
	public List<String> getFoundNames(){
		return this.foundNames;
	}
}