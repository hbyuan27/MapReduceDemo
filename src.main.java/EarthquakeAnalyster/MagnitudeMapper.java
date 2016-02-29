package EarthquakeAnalyster;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MagnitudeMapper extends
		Mapper<LongWritable, Text, Text, FloatWritable> {
	private Text mapKey = new Text();
	float threshold = 6.0f;

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		// ignore the first line (header)
		if (key.get() == 0) {
			return;
		}

		String[] lines = DataHelper.parseLine(value.toString());
		float magnitude = Float.parseFloat(lines[4]);
		if (magnitude >= threshold) {
			FloatWritable mapValue = new FloatWritable(magnitude);
			String dateStr = DataHelper.convertDateTime(lines[0]);
			String localtion = DataHelper.convertLocation(lines[13]);
			mapKey.set(dateStr + ", " + localtion + ":");
			context.write(mapKey, mapValue);
		}
	}
}