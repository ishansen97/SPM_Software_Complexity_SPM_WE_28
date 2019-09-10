package queries;

public class ProgramComplexityMeasurementQueries {

	public static final String INSERT_PROGRAM_STATEMENT_COMPLEXITY = "Insert Into program_complexity_measurements Values (?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_PROGRAM_STATEMENT_COMPLEXITY = "Select * From program_complexity_measurements Where 	program_Id = ?";
	public static final String DELETE_PROGRAM_STATEMENT_COMPLEXITIES = "Delete From program_complexity_measurements Where 	program_Id = ?";

}
