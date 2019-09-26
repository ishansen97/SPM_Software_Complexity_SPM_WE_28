package entity;

public class ProgramComplexity {

	private int programId;
	private String programName;
	private int totalComplexity;
	private int noOfLines;
	
	public ProgramComplexity(int programId, String programName, int totalComplexity, int noOfLines) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.totalComplexity = totalComplexity;
		this.noOfLines = noOfLines;
	}

	public ProgramComplexity(String programName, int totalComplexity, int noOfLines) {
		super();
		this.programName = programName;
		this.totalComplexity = totalComplexity;
		this.noOfLines = noOfLines;
	}

	public ProgramComplexity() {
		super();
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getTotalComplexity() {
		return totalComplexity;
	}

	public void setTotalComplexity(int totalComplexity) {
		this.totalComplexity = totalComplexity;
	}

	public int getNoOfLines() {
		return noOfLines;
	}

	public void setNoOfLines(int noOfLines) {
		this.noOfLines = noOfLines;
	}
	
	
}
