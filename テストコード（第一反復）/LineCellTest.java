package Sisaku;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LineCellTest {

	Line line;
	String[] mark = new String[3];
	
	@Test
	public void testjudgeLine_1_1() {
		
		Cell cell1 = new Cell(1,1);
		Cell cell2= new Cell(1,2);
		Cell cell3 = new Cell(1,3);
		
		line = new Line(cell1,cell2,cell3);
		
		cell1.setMark("〇");
		cell2.setMark("〇");
		cell3.setMark(" ");
		
		mark[0] = cell1.getcell();
		mark[1] = cell2.getcell();
		mark[2] = cell3.getcell();
		
		boolean expected_JudgeLine = false;
		
		boolean actual = line.judgeLine();
		
		assertThat(actual, is(expected_JudgeLine));
	 }

	@Test
	public void testjudgeLine_1_2() {
		
		Cell cell1 = new Cell(1,1);
		Cell cell2= new Cell(1,2);
		Cell cell3 = new Cell(1,3);
		
		line = new Line(cell1,cell2,cell3);
		
		cell1.setMark("〇");
		cell2.setMark("✕");
		cell3.setMark("〇");
		
		mark[0] = cell1.getcell();
		mark[1] = cell2.getcell();
		mark[2] = cell3.getcell();
		
		boolean expected_JudgeLine = false;
		
		boolean actual = line.judgeLine();
		
		assertThat(actual, is(expected_JudgeLine));
	 }

	@Test
	public void testjudgeLine_1_3() {
		
		Cell cell1 = new Cell(1,1);
		Cell cell2= new Cell(1,2);
		Cell cell3 = new Cell(1,3);
		
		line = new Line(cell1,cell2,cell3);
		
		cell1.setMark("〇");
		cell2.setMark("〇");
		cell3.setMark("〇");
		
		mark[0] = cell1.getcell();
		mark[1] = cell2.getcell();
		mark[2] = cell3.getcell();
		
		boolean expected_JudgeLine = true;
		
		boolean actual = line.judgeLine();
		
		assertThat(actual, is(expected_JudgeLine));
	 }

	@Test
	public void testjudgeLine_1_4() {
		
		Cell cell1 = new Cell(1,1);
		Cell cell2= new Cell(1,2);
		Cell cell3 = new Cell(1,3);
		
		line = new Line(cell1,cell2,cell3);
		
		cell1.setMark("✕");
		cell2.setMark("✕");
		cell3.setMark("✕");
		
		mark[0] = cell1.getcell();
		mark[1] = cell2.getcell();
		mark[2] = cell3.getcell();
		
		boolean expected_JudgeLine = true;
		
		boolean actual = line.judgeLine();
		
		assertThat(actual, is(expected_JudgeLine));
	 }

}
