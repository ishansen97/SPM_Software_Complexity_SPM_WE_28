package entity;

public class ProgramComplexityMeasurement {
	private int progId;
	private int lineNo;
	private String statement;
	private int sizeCount;
	private int controlCount;
	private int nestedCount;
	private int inheritanceCount;
	private int totalWeight;
	private int statementComplexity;
	private int recusrionComplxity;
	
	public ProgramComplexityMeasurement(int progId, int lineNo, String statement, int sizeCount, int controlCount,
			int nestedCount, int inheritanceCount, int totalWeight, int statementComplexity, int recusrionComplxity) {
		super();
		this.progId = progId;
		this.lineNo = lineNo;
		this.statement = statement;
		this.sizeCount = sizeCount;
		this.controlCount = controlCount;
		this.nestedCount = nestedCount;
		this.inheritanceCount = inheritanceCount;
		this.totalWeight = totalWeight;
		this.statementComplexity = statementComplexity;
		this.recusrionComplxity = recusrionComplxity;
	}

	public ProgramComplexityMeasurement() {
		super();
	}


	public int getProgId() {
		return progId;
	}

	public void setProgId(int progId) {
		this.progId = progId;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public int getSizeCount() {
		return sizeCount;
	}

	public void setSizeCount(int sizeCount) {
		this.sizeCount = sizeCount;
	}

	public int getControlCount() {
		return controlCount;
	}

	public void setControlCount(int controlCount) {
		this.controlCount = controlCount;
	}

	public int getNestedCount() {
		return nestedCount;
	}

	public void setNestedCount(int nestedCount) {
		this.nestedCount = nestedCount;
	}

	public int getInheritanceCount() {
		return inheritanceCount;
	}

	public void setInheritanceCount(int inheritanceCount) {
		this.inheritanceCount = inheritanceCount;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getStatementComplexity() {
		return statementComplexity;
	}

	public void setStatementComplexity(int statementComplexity) {
		this.statementComplexity = statementComplexity;
	}

	public int getRecusrionComplxity() {
		return recusrionComplxity;
	}

	public void setRecusrionComplxity(int recusrionComplxity) {
		this.recusrionComplxity = recusrionComplxity;
	}
	
	
	
	
	
}
