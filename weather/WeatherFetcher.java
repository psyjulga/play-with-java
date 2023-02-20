package weather;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherFetcher {

  // SINGLETON => only one instance
  private static WeatherFetcher instance;
  // empty constructor => private
  private WeatherFetcher(){}

      public static WeatherFetcher getInstance(){
        if(instance==null) instance = new WeatherFetcher();
        return instance;
      }

      // FETCH
      public WeatherInfo[] fetchWeatherInfo(String city) throws ParserConfigurationException, SAXException, IOException{

       String apiKey = "639e2d241e77fdfe191b24cbf78d97d1";
       String uri = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&mode=xml&units=metric&appid="+apiKey;
       
       // FACTORY PATTERN
       // DocumentBuilderFactory:
       // "Defines a factory API that enables applications 
       // to obtain a parser that produces DOM object trees 
       // from XML documents."
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = factory.newDocumentBuilder();
      Document doc = docBuilder.parse(uri);

      NodeList times = doc.getElementsByTagName("time");

        // ???? Ist es nicht ein Array vom Typ Strings ?
        // nein, weil es jeweils eine Instanz vom Typ WeatherInfo ist?
        // genau - es sind nicht nur die daten,
        // sondern jeweils das komplette objekt mit methoden etc
        WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];

        for (int x=0; x<times.getLength(); x++){
        Node time = times.item(x);
        NamedNodeMap timeAttributes = time.getAttributes();
        Node fromItem = timeAttributes.getNamedItem("from");
        String timeStamp = fromItem.getNodeValue();
        // we save the timestamp

        NodeList children = time.getChildNodes();

        for(int y=0; y<children.getLength();y++){
          Node child = children.item(y);
          String nodeName = child.getNodeName();

          if(nodeName=="temperature"){
            String temp = child.getAttributes().getNamedItem("value").getNodeValue();
            // we save the temperature
            weatherInfos[x] = new WeatherInfo(timeStamp, temp);
            // we save timestamp and temperature
            // als WeatherInfo Instanzen in einem Array
          }
        }
      }
        return weatherInfos;

      }
  
      // doc.getDocumentElement().getTagName();
      // XML Datei => Erstes "Dropdown" Element
    }
