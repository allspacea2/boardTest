package UpdateTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParsingTest {

	@Test
	public void test() {
	/***Given***/
		String contents = "<p>안녕</p>";
	/***When***/
	String content = contents.substring(3, contents.length()-4);

	/***Then***/
	assertEquals("안녕", content);
	}

}
