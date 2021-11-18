
# Project3: BetterInvertedIndex-Pyspark

* Author: Kachinga Silwimba
* Class: CS535 
* Semester: Fall 2021

# Overview
This is the python program code is based on improving the already existing Inverted Index MapReduce of words appearing by counting the number of times the word occurs in a given file to reduce the output and also documents with highest count are listed first since they are likely to be more relevant of a large dataset of documents using Pyspark.
# reflection 
During the testing of the code, I had multiple incidents with Spark. The first challenge I encountered was to find the efficient resilient distributed datasets (RDD), which are fundamental data structures of Spark to implement on the Better Inverted Index program in python to analyze a large dataset. During this stage I came to understand that performance tuning takes more time and effort to comprehend the job's input data, how Spark interacts with various cluster setups, and what the application code aims to accomplish, because I tried different data shuffle opperations like groupBykey, aggregateBykey they demostrated to slow down the performance (runtime). Hence I resorted to use reduceBykey which combine keys in each partition before shuffle data globally. 
# Compiling and Running

# Results 
By applying a mix of RDD, I managed to further reduce runtime.
