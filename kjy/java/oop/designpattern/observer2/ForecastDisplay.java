package designpattern.observer2;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer{

	Observable observable;
	private float temperature;
	private float humidity;
	
	public ForecastDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
		
	}
	
	public void display(){
		System.out.println("Forecast conditions : "+this.temperature+"F degrees and "+this.humidity+"% humidity");
	}
	

}
