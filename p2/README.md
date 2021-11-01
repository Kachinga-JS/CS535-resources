
# Project 2: Scaling up Better Inverted Index

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the Java program code based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with the highest count are listed first since they are likely to be more relevant of a large dataset of documents using the Hadoop MapReduce. Notably, the java program is run on the Adhoc cluster with 32 0r more Onyx nodes than the time taken to run on the pseudo-distributed mode on one onyx node.



# Reflection
Similar Better Inverted Index java program, which is the improved Inverted Index java program by running the program on the Onyx cluster lab by using 32 0r more Onyx nodes, one needs to create the Ad Hoc Hadoop cluster this is done by scaling the number of nodes to create the Ad Hoc Hadoop cluster for running the program. Running the program on the Ad Hoc onyx cluster was faster than running on a single onyx node. The experience of running the MapReduce job was very helpful because I feel it has prepared me in one way or the other to learn how computing of large scale data is done in the industry.

I encountered challenges in trying to scale and run the Better Inverted Index on the Ad Hoc cluster. Some of them are: finding the number of desired nodes to use because other classmates were running a similar program on the cluster. As such, I had to wait for them to release the nodes for scaling. I kept on trying for more than 24 hours to access the available nodes. Through the waiting process, I tried many times to secure the number of nodes and failed. During some instances, I reached the point of configuring the cluster to have it running as private, then proceeded with the formatting of the name node. Still, upon doing the admin report to check the status of the HDFS, I was getting one live node that had a space of zero. I repeated this process several times. I could not get the desired results until Professor Amit came to my rescue by providing Hadoop commands to clean my user from all the onyx nodes on the cluster. The other challenge I faced was running the Better Inverted Index on one Onyx node thats the part that didn't go well with me because I kept on searching to find one single node which is free which was easy at all, luckly I succeeded on running on a single onyx cluster node. To talk of the thing that I enjoyed was to see my Better Inverted Index program running on both onyx single node and also Onyx Ad Hoc cluster.





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
<li>Submitting the Hadoop job to your cluster and running hadoop job the command for running takes the jar file, the input and output. Both input and output files are text files for this code and requires user input.</li>
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
The hadoop jobs where also run on the cscluster00 and bugs clusters, the running time's observed are:
<ol>
<li>cscluster00 cluster = 2 minutes and 37.746 seconds</li> 
<li>bugs cluster = 33 minutes and 17.033 seconds</li>
<li>Onyx cluster nodes using 50 nodes = 0.42155 seconds</li>
    <li>Onyx cluster nodes using 1 node = 10.3328 minutes </li>
</ol>
It was observed that the more you increase the number of nodes on the Onyx node, the faster the program running time. In our instances, 50 nodes were used and compared with the running time on the cscluster00 and bugs cluster in running the MapReduce job for the Better Inverted Index. In conclusion, the more machines are used to create the Ad Hoc cluster, the higher the speed. 


