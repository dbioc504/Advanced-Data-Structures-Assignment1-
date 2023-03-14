import java.time.LocalDateTime;
import java.util.*;



class Main {
    public static void main(String[] args) {
      Parades p1 = new Parades("NOMTOC", 1951, 625,"Algiers", LocalDateTime.of(2023, 2, 18, 10, 45), "Holiday Drive", "General Meyer");
      Parades p2 = new Parades("Endymion", 1967, 3200, "Mid-City", LocalDateTime.of(2023, 2, 18, 4, 00), "City Park Avenue", "Orleans Avenue");
      Parades p3 = new Parades("Krewe of Hermes", 1937, 827, "Uptown", LocalDateTime.of(2023, 2, 17, 5, 30), "Magazine Street", "Baronne Street");
      Parades p4 = new Parades("Krewe d'Etat", 1996, 545, "Uptown", LocalDateTime.of(2023, 2, 17, 6, 30), "Jefferson Street", "Chartres Street");
      Parades p5 = new Parades("Krewe of Morpheus", 2000, 800, "Uptown", LocalDateTime.of(2023, 2, 17, 7, 00), "Magazine Street", "Andrew Higgins Street");
      Parades p6 = new Parades("Krewe of Bacchus", 1968, 1600, "Uptown", LocalDateTime.of(2023, 2, 19, 5, 15), "Tchoupitoulas Street", "Napolean Avenue");
      Parades p7 = new Parades("Krewe of Orpheus", 1993, 1500, "Uptown", LocalDateTime.of(2023, 2, 20, 6, 00), "Tchoupitoulas Street", "Convention Center");
      Parades p8 = new Parades("Krewe of Zulu", 1909, 1500, "Uptown", LocalDateTime.of(2023, 2, 21, 8, 00), "South Claiborne", "Broad Street");
      Parades p9 = new Parades("Krewe of Rex", 1872, 440, "Uptown", LocalDateTime.of(2023, 2, 21, 10, 30), "South Claiborne", "Broad Street");
      Parades p10 = new Parades("Krewe of Crescent City", 1947, 2500, "Uptown", LocalDateTime.of(2023, 2, 21, 11, 00), "South Claiborne", "Tulane Avenue");
      ArrayList<Parades> domsGoToParades = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
      Collections.shuffle(domsGoToParades);
      
      //Function Call 2
      LocalDateTime time1 = LocalDateTime.of(2023, 2, 21, 1, 30);
      System.out.println("Same Day Parades:\n" + sameDayParades(domsGoToParades, time1) + "\n\n");

      //Function Call 3
      System.out.println("Same Day Parades in order: \n" + sameDayParadesInOrder(domsGoToParades, time1) + "\n\n");

      //Function Call 4
      System.out.println("Same Starting Street Parades:\n" + sameStartStreet(domsGoToParades, "South Claiborne") + "\n\n");

      //Function Call 5
      System.out.println("Same Ending Street Parades:\n" + sameEndStreet(domsGoToParades, "Broad Street") + "\n\n");

      //Function Call 6
      System.out.println("Sorted by Age:\n" + sortedByAge(domsGoToParades) + "\n\n");

      //Function Call 7
      System.out.println("After This Time: \n" + afterThisTime(domsGoToParades, p2.getDateAndStartTime()) + "\n\n");

      //Function Call 8
      ArrayList<String> cities = new ArrayList<>(Arrays.asList("Mid-City", "Algiers"));
      System.out.println("Parades in these certain cities: \n" + certainCities(domsGoToParades, cities) + "\n\n");

      //Function Call 9
      System.out.println("Member Count Between These Numbers: \n" + CertainNumOfMembers(domsGoToParades, 1000, 1500) + "\n\n");

      //Function Call 10
      System.out.println("Change these street names: " + streetNameCorrection(domsGoToParades, "Magazine Street", "Eagle Street"));
    }

    public static ArrayList<Parades> sameDayParades(ArrayList<Parades> allParades, LocalDateTime paradeDate){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade : allParades){
        if(parade.getDateAndStartTime().isEqual(paradeDate)){
          result.add(parade);
        }
      }
      return result;
    }

  
    public static ArrayList<Parades> sameDayParadesInOrder(ArrayList<Parades> allParades, LocalDateTime paradeDate){
      ArrayList<Parades> sameDay = new ArrayList<>();
      sameDay = sameDayParades(allParades, paradeDate);
      ArrayList<Parades> result = new ArrayList<>();
      ArrayList<LocalDateTime> timeList = new ArrayList<>();
      for (Parades parade: sameDay){
        timeList.add(parade.getDateAndStartTime());
      }
      Collections.sort(timeList);
      for (LocalDateTime time : timeList){
        for(Parades parade: sameDay){
          if(parade.getDateAndStartTime() == time){
            result.add(parade);
          }
        }
      }
      return result;
    }

  
    public static ArrayList<Parades> sameStartStreet(ArrayList<Parades> allParades, String StreetName){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade: allParades){
        if (parade.getStartStreet() == StreetName){
          result.add(parade);
        }
      }
      return result;
    }

  
    public static ArrayList<Parades> sameEndStreet(ArrayList<Parades> allParades, String StreetName){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade: allParades){
        if (parade.getEndStreet() == StreetName){
          result.add(parade);
        }
      }
      return result;       
    }


    public static ArrayList<Parades> sortedByAge(ArrayList<Parades> allParades){
      ArrayList<Parades> result = new ArrayList<>();
      ArrayList<Integer> years = new ArrayList<>();
      for (Parades parade: allParades){
        years.add(parade.getOriginYear());
      }
      Collections.sort(years);
      for (int year: years){
        for (Parades parade: allParades){
          if (parade.getOriginYear() == year){
            result.add(parade);
          }
        }
      }
      return result;
    }

  
    public static ArrayList<Parades> afterThisTime(ArrayList<Parades> allParades, LocalDateTime T){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade: allParades){
        if(parade.getDateAndStartTime().isAfter(T)){
          result.add(parade);
        }
      }
      return result;
    }


    public static ArrayList<Parades> CertainNumOfMembers(ArrayList<Parades> allParades, int M1, int M2){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade: allParades){
        if (parade.getNumOfMembers() >= M1 && parade.getNumOfMembers() <= M2){
          result.add(parade);
        }
      }
      return result;
    }

  
    public static ArrayList<Parades> certainCities(ArrayList<Parades> allParades, ArrayList<String> cities){
      ArrayList<Parades> result = new ArrayList<>();
      for (Parades parade : allParades){
        for (String city : cities){
          if (parade.getCity() == city){
            result.add(parade);
          }
        }
      }
      for (int i = 0; i<result.size(); i++) {
        for (int j = i; j<result.size(); j++) {
          if(result.get(j).getDateAndStartTime().isBefore(result.get(i).getDateAndStartTime())) {
            Parades temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
          }
        }
      }
      return result;
    }

    public static ArrayList<Parades> streetNameCorrection(ArrayList<Parades> allParades, String street1, String street2){
      ArrayList<Parades> result = new ArrayList<>();
      for(Parades parade: allParades){
        if (parade.getStartStreet() == street1){
          parade.setStartStreet(street2);
          result.add(parade);
        }
        if (parade.getEndStreet() == street1){
            parade.setEndStreet(street2);
            result.add(parade);
          }
        }
      return result;
      }
    }
  
