package queries;

public class MetricMeasurementQueries {
	public static final String INSERT_METRIC_MEASUREMENT = "Insert Into metric_measurement (size_metric,control_metric,nested_metric,inheritance_metric,recursion_metric) Values (?,?,?,?,?)";
	public static final String GET_METRIC_MEASUREMENT = "Select * From metric_measurement Where Id = ?";
	public static final String GET_ALL_METRIC_MEASUREMENTS = "Select * From metric_measurement";
	public static final String UPDATE_METRIC_MEASUREMENT = "Update metric_measurement set size_metric = ?,control_metric = ?,nested_metric = ?,inheritance_metric = ?,recursion_metric = ? Where Id = ?";
}
