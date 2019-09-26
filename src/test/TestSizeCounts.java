package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import logic.ComplexityMeasurements;
import models.ComplexitySettings;
import models.ProgramStatementComplexity;

public class TestSizeCounts {

	public static void main(String[] args) {
		
		String fileName1 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM Sample Java Programs\\ThreadTest.java";
		String fileName2 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\SampleClass.java";
		String fileName3 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM Github repo\\SPM_Software_Complexity_SPM_WE_28\\src\\test\\TestInheritanceClass.java";
		String fileName4 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\FibonacciMain.java";
		String fileName5 = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM Github repo\\SPM_Software_Complexity_SPM_WE_28\\src\\test\\RecursionExample2.java";
		File file = new File(fileName2); 
		  
		  BufferedReader br,br1,br2,br3,br4,br5,br6;
		  List<String> java_keywords = ComplexitySettings.JAVA_KEYWORDS;
		  List<String> relation_operators = ComplexitySettings.RELATION_OPERATORS;
		  List<String> arithmetic_operators = ComplexitySettings.ARITHMETIC_OPERATORS;
		  List<String> logical_operators = ComplexitySettings.LOGICAL_OPERATORS;
		  List<String> bitwise_operators = ComplexitySettings.BITWISE_OPERATORS;
		  List<String> miscellaneous_operators = ComplexitySettings.MISCELLANEOUS_OPERATORS;
		  List<String> manipulators = ComplexitySettings.MANIPULATORS;
		  List<String> return_types = ComplexitySettings.RETURN_TYPES;
		  List<String> method_definitions = ComplexitySettings.METHOD_DEFINITIONS;
		  List<String> primitive_types = ComplexitySettings.PRIMITIVE_TYPES;
		  List<String> conditional_logical_operations = ComplexitySettings.CONDITIONAL_LOGICAL_OPERATORS;
		  List<String> variables = new ArrayList<>();
		  List<String> classes = new ArrayList<>();
		  List<String> user_defined_classes = new ArrayList<>();
		  List<String> user_defined_parent_classes = new ArrayList<>();
		  List<String> packages = new ArrayList<>();
		  List<ProgramStatementComplexity> programStatements = new ArrayList<>();
		  List<ProgramStatementComplexity> total_complexities = new ArrayList<>();
		  
		  
		try {
			br = new BufferedReader(new FileReader(file));
			br1 = new BufferedReader(new FileReader(file));
			br2 = new BufferedReader(new FileReader(file));
			br3 = new BufferedReader(new FileReader(file));
			br4 = new BufferedReader(new FileReader(file));
			br5 = new BufferedReader(new FileReader(file));
			br6 = new BufferedReader(new FileReader(file));
			String st; 
			int count = 0;
			ComplexityMeasurements cm = new ComplexityMeasurements(classes, variables, java_keywords, arithmetic_operators, relation_operators, logical_operators, bitwise_operators, miscellaneous_operators, primitive_types, method_definitions);
			
			while ((st = br.readLine()) != null) {
				int size_count = 0;
				
				count++;
				
				cm.setSize_count(size_count);
				cm.setSt(st);
				
				System.out.println(st);
				
				//for calculating the size count
				ProgramStatementComplexity obj = ComplexityMeasurements.calculateSizeMeasurements(cm, count);
				programStatements.add(obj);
							
//			    System.out.println(st);

			  }
			
			for (ProgramStatementComplexity psc: programStatements) {
				System.out.println("Size count for line no. " + psc.getLineNumber() + ": " + psc.getSize_count());
				System.out.println("===============================\n");
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
