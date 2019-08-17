package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.omg.CORBA.OMGVMCID;

public class TestFileRead {

	public static void main(String[] args) {
		
		String fileName1 = "D:\\SLIIT\\3rd year\\2nd Semester\\SPM\\project\\spm\\ThreadTest.java";
		String fileName2 = "D:\\SLIIT\\3rd year\\2nd Semester\\SPM\\project\\spm\\SampleClass.java";
		String fileName3 = "D:\\SLIIT\\3rd year\\2nd Semester\\SPM\\project\\spm\\TestInheritanceClass.java";
		String fileName4 = "D:\\SLIIT\\3rd year\\2nd Semester\\SPM\\project\\spm\\FibonacciMain.java";
		File file = new File(fileName1); 
		  
		  BufferedReader br,br1,br2,br3,br4;
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
		  
		  
		try {
			br = new BufferedReader(new FileReader(file));
			br1 = new BufferedReader(new FileReader(file));
			br2 = new BufferedReader(new FileReader(file));
			br3 = new BufferedReader(new FileReader(file));
			br4 = new BufferedReader(new FileReader(file));
			String st; 
			int count = 0;
			int inheritance_count = 0;
			List<String> tokens = new ArrayList<>();
			ComplexityMeasurements cm = new ComplexityMeasurements(classes, variables, java_keywords, arithmetic_operators, relation_operators, logical_operators, bitwise_operators, miscellaneous_operators, primitive_types, method_definitions);
			
			//checking for size measurements
			while ((st = br.readLine()) != null) {
				int size_count = 0;
				
				count++;
				
				cm.setSize_count(size_count);
				cm.setSt(st);
				
				//for calculating the size count
				size_count = ComplexityMeasurements.calculateSizeMeasurements(cm);
							
			    System.out.println(st);
//				System.out.println("No.of Size tokens for line no. " + count + ": " + size_count);
//				System.out.println("Inheritance size for the line no. " + count + ": " + inheritance_count);
			  }
			
			//checking for control structure measurements
			
			
			//checking for inheritance measurements
//			ComplexityMeasurements cm1 = new ComplexityMeasurements(user_defined_classes, user_defined_parent_classes, packages, br1);
//			ComplexityMeasurements.calculateInheritanceMeasurements(cm1);
			
			//checking for control structure measurements
//			ComplexityMeasurements cm2 = new ComplexityMeasurements(conditional_logical_operations, br2);
//			ComplexityMeasurements.calculateControlStructureCount(cm2);
			
			//checking for nesting level measurements
//			ComplexityMeasurements cm3 = new ComplexityMeasurements(br3);
//			ComplexityMeasurements.calculateNestingLevelMeasurement(cm3);
			
//			ComplexityMeasurements cm3 = new ComplexityMeasurements(br3);
//			ComplexityMeasurements.calculateRecursionMeasurements(cm3);
			
//			for (String var: variables) {
//				System.out.println("Variable : " + var);
//			}
//			
//			System.out.println("======================");
//			
//			for (String cl: classes) {
//				System.out.println("Class : " + cl);
//			}
//			
			System.out.println("======================");
			
//			for (String user_classes: user_defined_classes) {
//				System.out.println("User defined class: " + user_classes);
//			}
			
			System.out.println("======================");
			
//			for (String parent_classes: user_defined_parent_classes) {
//				System.out.println("Parent class: " + parent_classes);
//			}
			
//			for (String method: method_definitions) {
//				System.out.println("Methods: " + method);
//			}

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
