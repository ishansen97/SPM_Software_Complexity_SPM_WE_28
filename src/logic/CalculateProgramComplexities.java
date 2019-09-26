package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.ComplexitySettings;
import models.ProgramStatementComplexity;

public class CalculateProgramComplexities {

	public static List<ProgramStatementComplexity> getProgramComplexity(String fileName) {
		
		File file = new File(fileName); 
		  
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
		  List<String> method_list = new ArrayList<>();
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
			ComplexityMeasurements cm = new ComplexityMeasurements(classes, variables, java_keywords, arithmetic_operators, relation_operators, logical_operators, bitwise_operators, miscellaneous_operators, primitive_types, method_list);
			
			//checking for size measurements
			while ((st = br.readLine()) != null) {
				int size_count = 0;
				
				count++;
				
				cm.setSize_count(size_count);
				cm.setSt(st);
				
				//for calculating the size count
				ProgramStatementComplexity obj = ComplexityMeasurements.calculateSizeMeasurements(cm, count);
				programStatements.add(obj);
							
			    System.out.println(st);

			  }
			br.close();
			
			
			//checking for inheritance measurements
			ComplexityMeasurements cm1 = new ComplexityMeasurements(user_defined_classes, user_defined_parent_classes, packages, br1);
			Map<String, Integer> class_inheritance_counts = ComplexityMeasurements.calculateInheritanceMeasurements(cm1);
			
			//checking for control structure measurements
			ComplexityMeasurements cm2 = new ComplexityMeasurements(conditional_logical_operations, br2);
			List<ProgramStatementComplexity> control_structure_complexities = ComplexityMeasurements.calculateControlStructureCount(cm2);
			
			//checking for nesting level measurements
			ComplexityMeasurements cm3 = new ComplexityMeasurements(br3);
			List<ProgramStatementComplexity> nesting_level_complexities = ComplexityMeasurements.calculateNestingLevelMeasurement(cm3);
			
			//checking for recursion method measurements
			ComplexityMeasurements cm4 = new ComplexityMeasurements(br4);
			List<String> recursion_methods = ComplexityMeasurements.calculateRecursionMeasurements(cm4);
			
			
			ProgramComplexityLogic pcl = new ProgramComplexityLogic(programStatements, control_structure_complexities, nesting_level_complexities, class_inheritance_counts, recursion_methods);
			total_complexities = pcl.calculateProgramStatementComplexity(br5,br6);
			
			

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return total_complexities;
		}

	}
}
