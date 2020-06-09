package Sisaku;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CellTest {

	Cell cell;

	@Test
	public void testJudgeCoordinate_1_1() {
		Cell cell = new Cell(1,1);
		cell.setMark(" ");
		
		boolean expected_JudgeCoordinate = true;
		
		boolean actual = cell.judgeCoordinate();
		
		assertThat(actual, is(expected_JudgeCoordinate));
	 }

	@Test
	public void testJudgeCoordinate_1_2() {
		Cell cell = new Cell(1,1);
		cell.setMark("〇");
		
		boolean expected_JudgeCoordinate = false;

		boolean actual = cell.judgeCoordinate();

		assertThat(actual, is(expected_JudgeCoordinate));

	  }
}
