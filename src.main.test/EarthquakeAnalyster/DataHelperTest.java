package EarthquakeAnalyster;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class DataHelperTest {
	private final String sourceLine = "2016-01-29T23:56:46.801Z,39.3944,-119.8187,4.2,1.5,ml,19,82.49,0.042,0.1078,nn,nn00528985,2016-01-30T00:24:22.853Z,\"15km S of Reno, Nevada\",earthquake,0.65,1.5,0.2,7,reviewed,nn,nn";
	private final String sourceDataTime = "2016-01-29T23:56:46.801Z";
	private final String sourceLocation = "15km S of Reno, Nevada";
	
	@Test
	public void testParseLine() throws IOException {
		String[] result = DataHelper.parseLine(sourceLine);
		assertEquals(result[0], "2016-01-29T23:56:46.801Z");
	}
	
	@Test
	public void testConvertDateTime() {
		String result = DataHelper.convertDateTime(sourceDataTime);
		assertEquals(result, "2016-01-29");
	}
	
	@Test
	public void testConvertLocation() {
		String result = DataHelper.convertLocation(sourceLocation);
		assertEquals(result, "Nevada");
	}
}
