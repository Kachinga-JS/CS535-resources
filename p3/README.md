
# Project3: BetterInvertedIndex-Pyspark

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the pyspark program code is based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with highest count are listed first since they are likely to be more relevant of a large dataset of documents using Pyspark.
# reflection 
first challenge I encountered was to find the efficient, resilient distributed datasets (RDD), which are fundamental data structures of Spark to implement on the Better Inverted Index program in python to analyze a large dataset. During this stage, I understood that performance tuning takes more time and effort to comprehend the job's input data, how Spark interacts with the cluster setups, and what the application code aims to accomplish. I tried different data shuffle operations like groupBykey, aggregateBykey they demonstrated to slow down the performance (runtime). Hence I resorted to using reduceBykey, which combine keys in each partition before shuffling data globally. The other challenge I faced was during the application test, which was done using a smaller and large dataset. At first the code often failed, got stuck, and sometimes took long time to finish, but ended up printing the error message. Doing some improvements on the code I managed to run it using a smaller dataset. Surprising, when I implemented it on the large data, the code was unable to run. Hence, I had to explore other alternatives that could improve the applicatian.
# Compiling and Running
<ol>
<li>Have Spark and Hadoop setup on the local Machine or on the cluster and also have Python installed.</li>
<li>Staging the input text files to Hadoop distributed filesystem (HDFS).</li>
 <code> hdfs dfs -put etext-all input</code>
<li>Submitting the Pyspark job to your cluster (bugs and cscluster00) and running pyspark job the command for running takes the jar file, the input and output. Both input and output files are **text** files for this code and requires user input.</li>
<code> time spark-submit --master local[*] betterinvertedindexwc.py hdfs://localhost:9000/user/kachingasilwimba/input </code> </br>
<code> time spark-submit --master local[*] betterinvertedindexwc.py hdfs://cscluster00.boisestate.edu:9000/user/kachingasilwimba/input </code>
 <li>Copy the output from the hdfs.</li>
<code>hdfs dfs -get output</code>
</ol>
  
# Results
The Spark Job was run on both cscluster00 and bugs clusters and compared with the MapReduce job runtime, which was also run on both cscluster00 and bugs clusters. The running time's observed are:

<ol>
<li>Spark Job on Bug cluster = 9 minutes and 27 seconds</li>
<li>Spark Job on cscluster00 cluster = 3 minutes and 40 seconds</li>
<li> MapReduce Job on cscluster00 cluster = 2 minutes and 37 seconds</li> 
<li>MapRduce Job on bugs cluster = 33 minutes and 17 seconds</li>
</ol>
It was oberserved that the cscluster00 was faster than the bugs cluster in running the MapReduce job for the BetterInvertedIndex.
