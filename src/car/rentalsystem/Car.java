package car.rentalsystem;

public class Car {
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	
	//constructor 
	
	public Car(String carID, String brand,String model,double basePricePerDay) {
		this.carId = carId;
		this.brand= brand;
		this.model= model;
		this.basePricePerDay=basePricePerDay;
		this.isAvailable= true;
	
	}
	// method for value access
	public String getCarId() 
	{
		return carId;
	}
	public String getBrand()
	{
		return brand;
	}
	public String getModel()
	{
		return model;
	}
	public double calculatePrice(int rentalDays) 
	{
		return basePricePerDay*rentalDays;
	}
	public boolean isAvailable() 
	{
		return isAvailable;
	
	}
	
	public void rent() {
		isAvailable = false ;
		
	}
	public void returncar() {
		isAvailable = true;
		
	}
}
