
package betterinvertedindex;

import java.util.Comparator;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class BetterInvertedIndex2
{

	public static class BetterMapper extends
			Mapper<LongWritable, Text, Text, Text>
	{

		private final static Text word = new Text();
		private final static Text filename = new Text();

		public void map(LongWritable key, Text val, Context context)
				throws IOException, InterruptedException
		{

			FileSplit fileSplit = (FileSplit) context.getInputSplit();
			String fileName = fileSplit.getPath().getName();
			filename.set(fileName);

			String line = val.toString();
			StringTokenizer itr = new StringTokenizer(line.toLowerCase(),
					" , .;:'\"&!?-_\n\t12345678910[]{}<>\\`~|=^()@#$%^*/+-");
			while (itr.hasMoreTokens()) {
				word.set(itr.nextToken());
				context.write(word, filename);
			}
		}
	}
     
	public static class BetterReducer
    extends Reducer<Text,Text,Text,Text> {
 /*
 Reduce method collects the output of the Mapper calculate and aggregate the word's count.
 */
 public void reduce(Text key, Iterable<Text> values,
                    Context context
                    ) throws IOException, InterruptedException {

   HashMap<String,Integer> map = new HashMap<String,Integer>();
   
   for (Text val : values) {
     if (map.containsKey(val.toString())) {
       map.put(val.toString(), map.get(val.toString()) + 1);
     } else {
       map.put(val.toString(), 1);
     }
   }
  
 List<Map.Entry<String, Integer>> list =new LinkedList<Map.Entry<String, Integer>> (map.entrySet()); 
 
 Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	 public int compare(Map.Entry<String, Integer>comp1, Map.Entry<String ,Integer> comp2) {
		 if (comp1.getValue() <= comp2.getValue()) {
			 if (comp1.getValue() == comp2.getValue()){
			     return comp1.getKey().compareTo(comp2.getKey());
		 }
		 return 1;
	 }
	 return -1;
   }
 
 });
 
   
   StringBuilder myvals = new StringBuilder();
   for(Entry<String, Integer> myfileID: list){
	   myvals.append(myfileID.getValue() + " " + myfileID.getKey() + "," + "\t");
    }
   context.write(key, new Text (myvals.toString()));
  }   
	}
   
public static void main(String[] args) throws IOException,

ClassNotFoundException, InterruptedException
{
Configuration conf = new Configuration();
if (args.length < 2) {
System.out
		.println("Usage: BetterInvertedIndex <input path> <output path>");
System.exit(1);
}
@SuppressWarnings("deprecation")
Job job = new Job(conf, "BetterInvertedIndex");
job.setJarByClass(BetterInvertedIndex2.class);
job.setMapperClass(BetterMapper.class);
job.setReducerClass(BetterReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);

FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
System.exit(job.waitForCompletion(true) ? 0 : 1);
}

}
	
	
	
	
	
	