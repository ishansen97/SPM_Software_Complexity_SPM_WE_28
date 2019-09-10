package models;

import java.util.List;

public class InsertProgrammingComplexityRequest {
	
	private int programId;
	private String programName;
	private int totalComplexity;
	private int noOfLines;
	private List<ProgramStatementComplexity> programComplexities;

	public InsertProgrammingComplexityRequest(int programId, String programName, int totalComplexity, int noOfLines,
			List<ProgramStatementComplexity> programComplexities) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.totalComplexity = totalComplexity;
		this.noOfLines = noOfLines;
		this.programComplexities = programComplexities;
	}

	public InsertProgrammingComplexityRequest(String programName, int totalComplexity, int noOfLines,
			List<ProgramStatementComplexity> programComplexities) {
		super();
		this.programName = programName;
		this.totalComplexity = totalComplexity;
		this.noOfLines = noOfLines;
		this.programComplexities = programComplexities;
	}


	public InsertProgrammingComplexityRequest() {
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

	public List<ProgramStatementComplexity> getProgramComplexities() {
		return programComplexities;
	}

	public void setProgramComplexities(List<ProgramStatementComplexity> programComplexities) {
		this.programComplexities = programComplexities;
	}
	
}
