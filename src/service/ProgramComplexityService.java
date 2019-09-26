package service;

import java.util.ArrayList;
import java.util.List;

import entity.ProgramComplexity;
import entity.ProgramComplexityMeasurement;
import models.DeleteProgramComplexityRequest;
import models.DeleteProgramComplexityResponse;
import models.GetProgrammingComplexityResponse;
import models.InsertProgrammingComplexityRequest;
import models.InsertProgrammingComplexityResponse;
import models.ProgramStatementComplexity;
import repository.ProgramComplexityMeasurementRepository;
import repository.ProgramComplexityRepository;

public class ProgramComplexityService {

	private ProgramComplexityRepository programComplexityRepository = new ProgramComplexityRepository();
	private ProgramComplexityMeasurementRepository programComplexityMeasurementRepository = new ProgramComplexityMeasurementRepository();
	
	public InsertProgrammingComplexityResponse insertProgramComplexity(InsertProgrammingComplexityRequest request) {
		
		ProgramComplexity programComplexity = new ProgramComplexity();
		List<ProgramStatementComplexity> program_statement_complexities = request.getProgramComplexities();
		InsertProgrammingComplexityResponse response = new InsertProgrammingComplexityResponse();
		boolean isNotInserted = false;
		
		programComplexity.setProgramName(request.getProgramName());
		programComplexity.setNoOfLines(request.getNoOfLines());
		programComplexity.setTotalComplexity(request.getTotalComplexity());
		
		boolean isInserted = programComplexityRepository.insertProgramComplexity(programComplexity);
		
		if (isInserted) {
			int inserted_Id = programComplexityRepository.getLastRecordId();
			
			for (ProgramStatementComplexity psc: program_statement_complexities) {
				ProgramComplexityMeasurement pcm = new ProgramComplexityMeasurement();
				pcm.setProgId(inserted_Id);
				pcm.setLineNo(psc.getLineNumber());
				pcm.setStatement(psc.getProgramStatement());
				pcm.setSizeCount(psc.getSize_count());
				pcm.setControlCount(psc.getControl_count());
				pcm.setNestedCount(psc.getNested_level_count());
				pcm.setInheritanceCount(psc.getInheritance_count());
				pcm.setTotalWeight(psc.getTotal_weight());
				pcm.setStatementComplexity(psc.getTotal_complexity());
				pcm.setRecusrionComplxity(psc.getRecursion_count());
				
				boolean inserted = programComplexityMeasurementRepository.insertProgramComplexityMeasurement(pcm);
				
				if (!inserted)
					isNotInserted = true;
			}
			
			
		}
		
		response.setInserted(isInserted && !isNotInserted);
		
		return response;
	}
	
	
	public List<GetProgrammingComplexityResponse> getAllProgramComplexities() {
		List<ProgramComplexity> programComplexities = programComplexityRepository.getAllProgramComplexities();
		List<GetProgrammingComplexityResponse> responseList = new ArrayList<>();
		
		for (ProgramComplexity programComplexity: programComplexities) {
			GetProgrammingComplexityResponse response = new GetProgrammingComplexityResponse();
			List<ProgramComplexityMeasurement> pcm = null;
			
			response.setProgramId(programComplexity.getProgramId());
			response.setProgramName(programComplexity.getProgramName());
			response.setTotalComplexity(programComplexity.getTotalComplexity());
			response.setNoOfLines(programComplexity.getNoOfLines());
			
			pcm = programComplexityMeasurementRepository.getProgramComplexityMeasurement(programComplexity.getProgramId());
			
			response.setComplexityMeasurements(pcm);
			
			
			
			responseList.add(response);
		}
		
		return responseList;
	}
	
	public DeleteProgramComplexityResponse deleteProgramComplexity(DeleteProgramComplexityRequest request) {
		
		int progId = request.getProgId();
		boolean isDeleted = programComplexityMeasurementRepository.deleteProgramComplexityMeasurements(progId);
		boolean isProgramDeleted = false;
		DeleteProgramComplexityResponse response = new DeleteProgramComplexityResponse();
		
		if (isDeleted) {
			isProgramDeleted = programComplexityRepository.deleteProgramComplexity(progId);
		}
		
		response.setDeleted(isDeleted && isProgramDeleted);
		
		return response;
		
		
	}
}
