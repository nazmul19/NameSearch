# Contact-Name-Search
Contact Name Search using TRIE Algorithm implementation.
##Example
<pre>
  >1) Add contact 2) Search 3) Exit
  >1
  >Enter name: Chris Harris
  >1) Add contact 2) Search 3) Exit
  >1
  >Enter name: Chris
  >1) Add contact 2) Search 3) Exit
  >2
  >Enter name: Ch
  >Chris Harris
  >Chris
  >1) Add contact 2) Search 3) Exit
  >2
  >Enter name: Chris
  >Chris
  >Chris Harris
  >1) Add contact 2) Search 3) Exit
  >3
  >Happy Searching
</pre>
# What is TRIE Algorithm
In computer science, a trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes), is an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings. Unlike a binary search tree, no node in the tree stores the key associated with that node; instead, its position in the tree defines the key with which it is associated. All the descendants of a node have a common prefix of the string associated with that node, and the root is associated with the empty string. Values are not necessarily associated with every node. Rather, values tend only to be associated with leaves, and with some inner nodes that correspond to keys of interest. For the space-optimized presentation of prefix tree, see compact prefix tree.

#Prerequisite
Java-1.5+

#How to run
- Downlaod this repository
- Change your current directory to downloaded <b>target</b> folder
- CMD <b>java -jar nameSearch-0.0.1-SNAPSHOT-jar-with-dependencies.jar</b>

#How to build from source code
- Maven build should be installed on system
- Goto root Directory of source code
- CMD <b>mvn clean compile assembly:single</b>

#How to Run testcase(s)
- Goto root directory of source code
- CMD <b>mvn test</b>
- Testcase report available here https://github.com/nazmul19/name-search-trie/blob/master/target/surefire-reports/edu.test.contact.SearchTest.txt

#Input Data Error Handled
- Names not more than 50 characters
- Names only have two parts firstName and lastName, space separated.
- Empty and NULL handling

><i>Note:This is just POC.</i>
