package models;

import java.util.List;

import entity.ProgramComplexityMeasurement;

public class GetProgrammingComplexityResponse {
	
	private int programId;
	private String programName;
	private int totalComplexity;
	private int noOfLines;
	private List<ProgramComplexityMeasurement> complexityMeasurements;

	public GetProgrammingComplexityResponse(int programId, String programName, int totalComplexity, int noOfLines,
			List<ProgramComplexityMeasurement> complexityMeasurements) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.totalComplexity = totalComplexity;
		this.noOfLines = noOfLines;
		this.complexityMeasurements = complexityMeasurements;
	}

	public GetProgrammingComplexityResponse() {
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

	public List<ProgramComplexityMeasurement> getComplexityMeasurements() {
		return complexityMeasurements;
	}

	public void setComplexityMeasurements(List<ProgramComplexityMeasurement> complexityMeasurements) {
		this.complexityMeasurements = complexityMeasurements;
	}
	
	
}
