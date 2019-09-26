package queries;

public class ProgramComplexityQueries {

	public static final String INSERT_PROGRAM_COMPLEXITY = "Insert Into program_complexity (program_name, total_complexity, no_of_lines) Values (?,?,?)";
	public static final String GET_LAST_RECORD = "Select program_Id From program_complexity Order By program_Id Desc Limit 1";
	public static final String GET_ALL_RECORDS = "Select * From program_complexity";
	public static final String DELETE_PROGRAM_COMPLEXITY = "Delete From program_complexity Where program_Id = ?";
}
