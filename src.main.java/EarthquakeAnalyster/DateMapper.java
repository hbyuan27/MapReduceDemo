package EarthquakeAnalyster;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DateMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
	private Text mapKey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		// ignore the first line (header)
		if (key.get() == 0) {
			return;
		}

		String[] lines = DataHelper.parseLine(value.toString());
		String dateStr = DataHelper.convertDateTime(lines[0]);
		mapKey.set(dateStr);
		context.write(mapKey, one);
	}
}