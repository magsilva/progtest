package progtest.execution;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import progtest.common.Assignment;
import progtest.common.Tool;

public class Run {
	
	private static void makeDirectories(Assignment assignment, Tool tool) {
		
		
		
	}
	
	private static void preprocess(Assignment assignment, Tool tool) {
		File preprocessFile = DirControl.getToolPreprocessFile(assignment, tool);
		process(assignment, tool, preprocessFile);
	}
	
	private static void compile(Assignment assignment) {
		
		
		
	}
	
	private static void postprocess(Assignment assignment, Tool tool) {
		File postprocessFile = DirControl.getToolPostprocessFile(assignment, tool);
		process(assignment, tool, postprocessFile);
	}
	
	private static void generageReports(Assignment assignment, Tool tool) {
		
		
		
	}
	
	private static void process(Assignment assignment, Tool tool, File processFile) throws IOException {
		
		FileInputStream fis = new FileInputStream(processFile);
	    DataInputStream dis = new DataInputStream(fis);
	    InputStreamReader isr = new InputStreamReader(dis);
	    BufferedReader br = new BufferedReader(isr);
		
		while (br.ready()) {
			
			String args[] = br.readLine().split(" ");
			
		}
		
	}

}
