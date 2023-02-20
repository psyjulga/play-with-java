package weather;

// ähnlich wie eine factory function
public class WeatherInfo {
  
  private String timestamp;
  private String temperature;

  public WeatherInfo(String timestamp,String temperature){
    this.timestamp=timestamp;
    this.temperature=temperature;
  }

  public String getTimestamp(){
     return timestamp;
  }

  public String getTemperature(){
     return temperature;
  }

}
