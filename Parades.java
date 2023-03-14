import java.time.LocalDateTime;

public class Parades{
  private String name;
  private int originYear;
  private int numOfMembers;
  private String city;
  private LocalDateTime dateAndStartTime;
  private String startStreet;
  private String endStreet;

  
  public Parades(String newName, int newOriginYear, int newNumOfMembers, String newCity,
                LocalDateTime newDateAndStartTime, String NewStartStreet, String newEndStreet){
    name = newName;
    originYear = newOriginYear;
    numOfMembers = newNumOfMembers;
    city = newCity;
    dateAndStartTime = newDateAndStartTime;
    startStreet = NewStartStreet;
    endStreet = newEndStreet;
                }

  
  public String getName(){return name;}
  public int getOriginYear(){return originYear;}
  public int getNumOfMembers(){return numOfMembers;}
  public String getCity(){return city;}
  public LocalDateTime getDateAndStartTime(){return dateAndStartTime;}
  public String getStartStreet(){return startStreet;}
  public String getEndStreet(){return endStreet;}

  
  public void setName(String newName){name = newName;}
  public void setOriginYear(int newOriginYear){originYear = newOriginYear;}
  public void setNumofMembers(int newNumOfMembers){numOfMembers = newNumOfMembers;}
  public void setCity(String newCity){city = newCity;}
  public void setDateandStartTime(LocalDateTime newDateandStartTime){dateAndStartTime = newDateandStartTime;}
  public void setStartStreet(String newStartStreet){startStreet = newStartStreet;}
  public void setEndStreet(String newEndStreet){endStreet = newEndStreet;}

  public String toString(){
    return name + "\nOrigin Year: " + originYear + "\nMembers: " + numOfMembers + 
      "\nCity: " + city + "\nDate and Start Time: " + dateAndStartTime + "\nStarts on: " + startStreet + "\nEnds on: " + endStreet;
  }
  
  
}

