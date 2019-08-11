package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import test.ComplexitySettings;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sampleCode = "int factorial(int number) {";
		String sampleCode1 = "\t\tex.getMessage20j(10,20+21)";
		
		
		String fileName1 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM Sample Java Programs\\ThreadTest.java";
		String fileName2 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\SampleClass.java";
		String fileName3 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\TestInheritanceClass.java";
		String fileName4 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\FibonacciMain.java";
		String fileName5 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\RecursionExample2.java";
		String fileName6 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\SwitchProgram.java";
		File file = new File(fileName6); 
		
		int count = 1;
		int first_line = 0;
		int last_line = 0;
		BufferedReader br;
		String statement;
		int left_braces = 0;
		int right_braces = 0;
		int case_count = 0;
		List<String> method_list = new ArrayList<>();
		boolean isSwitchFound = false;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			while ((statement = br.readLine()) != null) {
				
				if (statement.contains(" ")) {
					String[] parts = statement.trim().split(" ");
					
					if (parts[0].equals(ComplexitySettings.SWITCH)) {
						isSwitchFound = true;
						first_line = count;
					}
				}
				
				if (isSwitchFound && statement.contains(" ")) {
					String[] parts = statement.trim().split(" ");
					
					if (parts[0].contains(ComplexitySettings.CASE)) {
						case_count++;
					}
				}
				
				if (!statement.contains("\"") && statement.contains("}") && isSwitchFound) {
					right_braces++;
				}
				
				if (statement.contains("{") && isSwitchFound) {
					left_braces++;
				}
				
				if ((left_braces == right_braces) && (left_braces > 0) && (right_braces > 0)) {
					System.out.println("switch method ends at line no. " + count);
					isSwitchFound = false;
					case_count = 0;
					left_braces = 0;
					right_braces = 0;
					last_line = count;
				}
				
				count++;
			}
			
			System.out.println("Number of cases: " + case_count);
			System.out.println("First Line: " + first_line);
			System.out.println("Last line: " + last_line);
			
		}
		catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}	

	}

}
