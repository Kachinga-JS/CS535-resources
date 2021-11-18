
# Project3: BetterInvertedIndex-Pyspark

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the python program code is based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with highest count are listed first since they are likely to be more relevant of a large dataset of documents using Pyspark.
# reflection 
first challenge I encountered was to find the efficient, resilient distributed datasets (RDD), which are fundamental data structures of Spark to implement on the Better Inverted Index program in python to analyze a large dataset. During this stage, I understood that performance tuning takes more time and effort to comprehend the job's input data, how Spark interacts with the cluster setups, and what the application code aims to accomplish. I tried different data shuffle operations like groupBykey, aggregateBykey they demonstrated to slow down the performance (runtime). Hence I resorted to using reduceBykey, which combine keys in each partition before shuffling data globally. The other challenge I faced was during the application test, which was done using a smaller and large dataset. The code was running on the smaller dataset, but surprising, when implemented on the extensive data, the code was unable to run. Hence, I had to explore other alternatives that could improve my code.
# Compiling and Running

# Results 
By applying a mix of RDD, I managed to further reduce runtime.
