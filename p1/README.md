# cs535-f21-Kachinga-JS
cs535-f21-Kachinga-JS created by GitHub Classroom

# Project: BetterInvertedIndex

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the Java program code based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with highest count are listed first since they are likely to be more relevant of a large dataset of documents using the Hadoop MapReduce.
# Reflection
During the improvement of the Inverted Index to Better Inverted Index, I encountered challenges. Some of them are: understanding how the Inverted Index code to be improved was implemented this was mainly on the reducer function sums up the list of occurrence counts and emits a count for word is summed and how a tuple is emitted where the word is a string and total is an integer. To understand this, I had to do some research on Google to understand better how the Java classes used in the code works and how they can be implemented in the Eclipse software environment using the Java programming language. One of the things I learned is that the Eclipse platform makes it easy and fast to write Java programs. After implementing the reducer and the sorter I now proceeded on to test the code on the **cscluster00** using the text dataset. 

Upon running the jar file, I got an error message that showed the Java software's incompatibility on the cluster and the one I used to compile my code on the Eclipse platform. Hence, I had to go back and start a new project by setting Java 1.8 on the Eclipse platform because initially, it was Java 11, so it is compatible with the one on the **cscluster00**. After, resolving I proceeded to run the code on the cluster following the guideline specified in the project description. After running the code, getting the output, and analysing it, I realised that the sorting was ascending. Thus, I had to include the Comparator class in my code and test it again. Some of the error messages were difficult to interpret. Therefore, I resorted to seeking help from my classmate, and I was glad they could help in debugging my code and helping me understand the code. Finally, I had my code running on both **cscluster00** and the **bugs** cluster. One of the things I enjoyed through in this project is getting the experience of running Hadoop job on two different clusters and getting the same output but with differnt running time.

# Compiling and Using
<ol>
<li>Have Hadoop setup on the local Machine or on the cluster and have Java 1.8 installed.</li>
<li>specify the main class while building the jar file class name BetterInvertedIndex2. Have the Java 1.8 and hadoop packages on your local machine.</li>
<li>Start DFS server and the resource and job manager yarn if you are using hadoop on your local machine.</li>
<code>start-dfs.sh</code> <br>
<code>hdfs dfsadmin -report</code> <br>
<code>start-yarn.sh</code> 
<li>copy input text files to Hadoop distributed filesystem.</li>
    <code> hdfs dfs -put input</code>
<li>Submitting the Hadoop job to your cluster and running hadoop job the command for running takes the jar file, the input and output. Both input and output files are **text** files for this code and requires user input.</li>
<code>time hadoop jar BetterInvertedIndex2.jar input output</code>
<li>Copy the output to your local folder.</li>
<code>hadoop dfs -get output</code>
<li>Deleting the output from the Hadoop distributed filesystem.</li>
<code>hadoop -rm -r output</code>
<li>Shut down the DFS servers and stop the job manager yarn if running on a local machine.</li>
  <code>stop-dfs.sh</code> <br>
  <code>stop-yarn.sh</code>
</ol>

# Results
The hadoop jobs where run on both cscluster00 and bugs clusters, the running time's observed are:
<ol>
<li>cscluster00 cluster = 2 minutes and 37.746 seconds</li> 
<li>bugs cluster = 33 minutes and 17.033 seconds</li>
</ol>

# Reference 
- [Map-Reduce-Inverted-Index](https://github.com/imehrdadmahdavi/map-reduce-inverted-index)
- [Algorithms in MapReduce](https://proserge.kh.ua/coding/index.php/post/49/Algorithms+in+MapReduce1:+Inverted+Index)
- [Map-reduce-inverted-index-sample](https://timepasstechies.com/map-reduce-inverted-index-sample/)
