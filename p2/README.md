
# Project 2: Scaling up Bette Inverted Index

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the Java program code based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with the highest count are listed first since they are likely to be more relevant of a large dataset of documents using the Hadoop MapReduce. Notably, the java program is run on the Adhoc cluster with 32 0r more onyx nodes than the time taken to run on the pseudo-distributed mode on one onyx node.



# Reflection
Similar Better Inverted Index java program, which is the improved Inverted Index java program by running the program on the Onyx cluster lab by using 32 0r more Onyx nodes, one needs to create the Ad Hoc Hadoop cluster this is done by scaling the number of nodes to create the Ad Hoc Hadoop cluster for running the program. Running the program on the Ad Hoc onyx cluster was faster than running on a single onyx node. The experience of running the MapReduce job was very helpful because I feel it has prepared me in one way or the other to learn how computing of large scale data is done in the industry.

I encountered challenges in trying to scale and run the Better Inverted Index on the Ad Hoc cluster. Some of them are: finding the number of desired nodes to use because other classmates were running a similar program on the cluster. As such, I had to wait for them to release the nodes for scaling. I kept on trying for more than 24 hours to access the available nodes. Through the waiting process, I tried many times to secure the number of nodes and failed. During some instances, I reached the point of configuring the cluster to have it running as private, then proceeded with the formatting of the name node. Still, upon doing the admin report to check the status of the HDFS, I was getting one live node that had a space of zero. I repeated this process several times. I could not get the desired results until Professor Amit came to my rescue by providing Hadoop commands to clean my user from all the onyx nodes on the cluster.





# Compiling and Using
<ol>
<li>Have Hadoop setup on the cluster and Java 1.8 installed if using Hadoop-2.10.1 installed.</li>
<li>Compile the MapReduce application on eclipse and specify the main class while building the jar file class name BetterInvertedIndex1. Have the Java 1.8 and hadoop packages on your local machine.</li>
<li>Navigate to the server and find the onyx node to use as master and run the setup script for distributed hdoop</li>
    <code>./setmode.sh distributed</code>
    <li> Find the desired number of workers nodes (e.g 50 nodes)</li>
     <code>./findnodes.sh 50</code>
    <li>Copy the files containing the names of the worker nodes to the configuration folder.</li>
     <code>cp workers ~/hadoop-install/hadoop/etc/hadoop/slaves</code>
  <li>Format the name node and start DFS server and aslo check the status of the live nodes </li>  
<code>hdfs namenode -format</code> <br>    
<code>start-dfs.sh</code> <br>
<code>hdfs dfsadmin -report</code> <br>
    <li>Create the User</li>
    <code>hdfs dfs -mkdir -p /user/$USER</code>
<li> Start the resource and job manager yarn.</li>
<code>start-yarn.sh</code> 
<li>copy input text files to Hadoop distributed filesystem (e.g etext-all).</li>
    <code> hdfs dfs -put etext-all</code>
<li>Submitting the Hadoop job to your cluster and running hadoop job the command for running takes the jar file, the input and output. Both input and output files are **text** files for this code and requires user input.</li>
<code>time hadoop jar BetterInvertedIndex2.jar etext-all output</code>
<li>Copy the output.</li>
<code>hdfs dfs -get output</code>
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
It was oberserved that the cscluster00 was faster than the bugs cluster in running the MapReduce job for the BetterInvertedIndex.

# Reference 
- [Map-Reduce-Inverted-Index](https://github.com/imehrdadmahdavi/map-reduce-inverted-index)
- [Algorithms in MapReduce](https://proserge.kh.ua/coding/index.php/post/49/Algorithms+in+MapReduce1:+Inverted+Index)
- [Map-reduce-inverted-index-sample](https://timepasstechies.com/map-reduce-inverted-index-sample/)
