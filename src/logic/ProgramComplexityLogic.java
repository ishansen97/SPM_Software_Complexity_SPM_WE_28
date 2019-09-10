package logic;

import java.io.BufferedReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dbconnection.DBConnection;
import entity.ProgramComplexity;
import models.InsertProgrammingComplexityRequest;
import models.InsertProgrammingComplexityResponse;
import models.ProgramStatementComplexity;

public class ProgramComplexityLogic {
	
	private List<ProgramStatementComplexity> size_complexities;
	private List<ProgramStatementComplexity> control_structure_complexities;
	private List<ProgramStatementComplexity> nesting_level_complexities;
	private Map<String, Integer> class_inheritance_counts;
	private List<String> recursion_methods;
	
	

	public ProgramComplexityLogic(List<ProgramStatementComplexity> size_complexities,
			List<ProgramStatementComplexity> control_structure_complexities,
			List<ProgramStatementComplexity> nesting_level_complexities, Map<String, Integer> class_inheritance_counts,
			List<String> recursion_methods) {
		super();
		this.size_complexities = size_complexities;
		this.control_structure_complexities = control_structure_complexities;
		this.nesting_level_complexities = nesting_level_complexities;
		this.class_inheritance_counts = class_inheritance_counts;
		this.recursion_methods = recursion_methods;
	}

	public ProgramComplexityLogic() {
		super();
	}


	public List<ProgramStatementComplexity> calculateProgramStatementComplexity(BufferedReader br1, BufferedReader br2) {
		
		int index = 0;
		List<ProgramStatementComplexity> totalComplexities = new ArrayList<>();
		
		
		try {
			//getting the inheritance count for each line
			ComplexityMeasurements cm5 = new ComplexityMeasurements(br1);
			List<ProgramStatementComplexity> inheritance_complexities = ComplexityMeasurements.getInheritanceCountForStatement(cm5, class_inheritance_counts);
			
			ComplexityMeasurements cm6 = new ComplexityMeasurements(br2);
			List<ProgramStatementComplexity> recursion_complexities = ComplexityMeasurements.getRecursionCountforStatement(cm6, recursion_methods);
			
			//assigning the complexity values
			for (ProgramStatementComplexity psc: size_complexities) {
				int recursion_point = 0;
				ProgramStatementComplexity control = control_structure_complexities.get(index);
				ProgramStatementComplexity nested = nesting_level_complexities.get(index);
				ProgramStatementComplexity inheritance = inheritance_complexities.get(index);
				
				//setting the control structure count for the line
				psc.setControl_count(control.getControl_count());
				
				//setting the nested level count for the line
				psc.setNested_level_count(nested.getNested_level_count());
				
				//setting the inheritance level count for the line
				psc.setInheritance_count(inheritance.getInheritance_count());
				
				//calculating the total weight by adding control structure, nested level and inheritance complexities
				int total_weight = control.getControl_count() + nested.getNested_level_count() + inheritance.getInheritance_count();
				
				psc.setTotal_weight(total_weight);
				
				//calculating the Total complexity for the program statement by multiplying the total weight by size complexity count
				int total_complexity = psc.getSize_count() * total_weight;
				
				psc.setTotal_complexity(total_complexity);
				
				ProgramStatementComplexity recursion = recursion_complexities.get(index);
				
				if (recursion.isRecursionLine()) {
					recursion_point = total_complexity * 2;
				}
				psc.setRecursion_count(recursion_point);
				
				totalComplexities.add(psc);
				index++;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			return totalComplexities;
		}
		
	}
	
}
