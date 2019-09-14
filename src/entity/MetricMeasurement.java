package entity;

public class MetricMeasurement {

	private int Id;
	private int size_metric;
	private int control_metric;
	private int nested_metric;
	private int inheritance_metric;
	private int recursion_metric;
	
	public MetricMeasurement(int id, int size_metric, int control_metric, int nested_metric, int inheritance_metric,
			int recursion_metric) {
		super();
		Id = id;
		this.size_metric = size_metric;
		this.control_metric = control_metric;
		this.nested_metric = nested_metric;
		this.inheritance_metric = inheritance_metric;
		this.recursion_metric = recursion_metric;
	}

	public MetricMeasurement(int size_metric, int control_metric, int nested_metric, int inheritance_metric,
			int recursion_metric) {
		super();
		this.size_metric = size_metric;
		this.control_metric = control_metric;
		this.nested_metric = nested_metric;
		this.inheritance_metric = inheritance_metric;
		this.recursion_metric = recursion_metric;
	}

	public MetricMeasurement() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSize_metric() {
		return size_metric;
	}

	public void setSize_metric(int size_metric) {
		this.size_metric = size_metric;
	}

	public int getControl_metric() {
		return control_metric;
	}

	public void setControl_metric(int control_metric) {
		this.control_metric = control_metric;
	}

	public int getNested_metric() {
		return nested_metric;
	}

	public void setNested_metric(int nested_metric) {
		this.nested_metric = nested_metric;
	}

	public int getInheritance_metric() {
		return inheritance_metric;
	}

	public void setInheritance_metric(int inheritance_metric) {
		this.inheritance_metric = inheritance_metric;
	}

	public int getRecursion_metric() {
		return recursion_metric;
	}

	public void setRecursion_metric(int recursion_metric) {
		this.recursion_metric = recursion_metric;
	}
	
	
}
