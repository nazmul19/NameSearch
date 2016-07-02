/**
 * 
 */
package edu.test.contact;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import edu.contact.NameTrie;
import edu.contact.TrieNode;

/**
 * @author Nazmul Hassan
 *
 */
public class SearchTest {

	@Test
	public void testLikeMatch(){
		
		NameTrie nameSearchEngine = new NameTrie();
		  nameSearchEngine.insert("Chris Harris");
		  nameSearchEngine.insert("Chris");
		  
		  List<String> expectedNameList = new ArrayList<String>();
		  expectedNameList.add("Chris");
		  expectedNameList.add("Chris Harris");
		  
		  
		  if( nameSearchEngine.startsWith("Ch")==true)
		  {
		    TrieNode tn = nameSearchEngine.searchNode("Ch");
		    nameSearchEngine.nameMatchBuilder(tn,0);
		    //Check that expectedNameList & searchResult are equal
		    assertEquals(new HashSet<String>(expectedNameList), new HashSet<String>(nameSearchEngine.getFoundNames()));
		  }
	}
	
	@Test
	public void testRankMatch(){
		
		NameTrie nameSearchEngine = new NameTrie();
		  nameSearchEngine.insert("Chris Harris");
		  nameSearchEngine.insert("Chris");
		  
		  List<String> expectedNameList = new ArrayList<String>();
		  expectedNameList.add("Chris");
		  expectedNameList.add("Chris Harris");
		  
		  
		  if( nameSearchEngine.startsWith("Chris")==true)
		  {
		    TrieNode tn = nameSearchEngine.searchNode("Chris");
		    nameSearchEngine.nameMatchBuilder(tn,0);
		    //Check that expectedNameList & searchResult are equal
		    assertEquals(new HashSet<String>(expectedNameList), new HashSet<String>(nameSearchEngine.getFoundNames()));
		    assertEquals("Chris", nameSearchEngine.getFoundNames().get(0));
		  }
	}
}
