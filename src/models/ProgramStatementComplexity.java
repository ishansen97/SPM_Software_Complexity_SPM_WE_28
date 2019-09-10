package models;

public class ProgramStatementComplexity {
	private int lineNumber;
	private String programStatement;
	private int size_count;
	private int control_count;
	private int nested_level_count;
	private int inheritance_count;
	private int recursion_count;
	private int total_weight;
	private int total_complexity;
	private boolean isRecursionLine;
	
	public ProgramStatementComplexity(int lineNumber, int size_count, int control_count, int nested_level_count,
			int inheritance_count, int recursion_count, int total_weight, int total_complexity, boolean isRecursionLine) {
		super();
		this.lineNumber = lineNumber;
		this.size_count = size_count;
		this.control_count = control_count;
		this.nested_level_count = nested_level_count;
		this.inheritance_count = inheritance_count;
		this.recursion_count = recursion_count;
		this.total_weight = total_weight;
		this.total_complexity = total_complexity;
		this.isRecursionLine = isRecursionLine;
	}
	
	public ProgramStatementComplexity(int lineNumber, String programStatement, int size_count, int control_count,
			int nested_level_count, int inheritance_count, int recursion_count, int total_weight, int total_complexity,
			boolean isRecursionLine) {
		super();
		this.lineNumber = lineNumber;
		this.programStatement = programStatement;
		this.size_count = size_count;
		this.control_count = control_count;
		this.nested_level_count = nested_level_count;
		this.inheritance_count = inheritance_count;
		this.recursion_count = recursion_count;
		this.total_weight = total_weight;
		this.total_complexity = total_complexity;
		this.isRecursionLine = isRecursionLine;
	}

	public ProgramStatementComplexity() {
		super();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getProgramStatement() {
		return programStatement;
	}

	public void setProgramStatement(String programStatement) {
		this.programStatement = programStatement;
	}

	public int getSize_count() {
		return size_count;
	}

	public void setSize_count(int size_count) {
		this.size_count = size_count;
	}

	public int getControl_count() {
		return control_count;
	}

	public void setControl_count(int control_count) {
		this.control_count = control_count;
	}

	public int getNested_level_count() {
		return nested_level_count;
	}

	public void setNested_level_count(int nested_level_count) {
		this.nested_level_count = nested_level_count;
	}

	public int getInheritance_count() {
		return inheritance_count;
	}

	public void setInheritance_count(int inheritance_count) {
		this.inheritance_count = inheritance_count;
	}

	public int getRecursion_count() {
		return recursion_count;
	}

	public void setRecursion_count(int recursion_count) {
		this.recursion_count = recursion_count;
	}

	public int getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(int total_weight) {
		this.total_weight = total_weight;
	}

	public int getTotal_complexity() {
		return total_complexity;
	}

	public void setTotal_complexity(int total_complexity) {
		this.total_complexity = total_complexity;
	}

	public boolean isRecursionLine() {
		return isRecursionLine;
	}

	public void setRecursionLine(boolean isRecursionLine) {
		this.isRecursionLine = isRecursionLine;
	}
	
}
