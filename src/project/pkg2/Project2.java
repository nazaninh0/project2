/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.pkg2;

import java.util.Scanner;

/**
 *
 * @author nazanin.heydari
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    static int [] platser= {1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1};
    static Scanner scan= new Scanner (System.in);
    public static final int YEAR = 2023;
    public static final double biljettpris = 299.90;
    public static final double barn_pris = 149.0;
    public static final double SENIOR_pris = 199.0;
    static int[] unga = new int[0];
    static int[] medel = new int[0];
    static int[] gamla = new int[0];
     //int [][]platser = new int [21][21];
    
     public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan= new Scanner (System.in);
        while(true){
          System.out.println("welcome to booking bus");
          System.out.println("|1 |2 |  |3 |4 |\n|5 |6 |  |7 |8 |\n|9 |10|  |11|12|\n|13|14|  |15|16|\n|17|18|19|20|21|\n\n");
         int year= 2023; 
         int val =0 ;
         while (true) {
             System.out.println("Vill du: \n1. Boka sittplats\n2. Hitta bokad plats\n3. Avboka plats \n4. beräkna vinsten \n 5. lista folk grupp \n 6. avsluta");
              val = 0;
                try {
                    val = scan.nextInt();
                    if(val < 0 && val > 6) {
                        System.out.println("<ERROR: Välj ett av menyvalen tack.>");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("<ERROR: Välj ett av menyvalen tack.>");
                    scan.nextLine();
                }
            }
            switch (val){
                case 1: 
                    int platsval=0;
                    System.out.println("1: standard , 2: fönster");
                    platsval= scan.nextInt();
                    if (platsval==1){
                        standardseat(addpersonnumer());
                    }
                    else{
                        windowseat(addpersonnumer());
                    }
                 break;
                case 2: 
                    hitta_plats(addpersonnumer());
                    break;
                case 3: 
                    avboka(addpersonnumer());
                    break;
                case 4: 
                    calculateprofit();
                    break; 
                case 5 : 
                 listAgeGroup();
                 break; 
                case 6: 
                 System.out.println("du har avslutat programmet");
                break;
            }
        }
}
     private static int addpersonnumer(){
        int personnummer=0;
        System.out.print("Skriv in ditt personnummer (yyyymmdd): "); 
        try {
         personnummer = scan.nextInt();
         String persString = Integer.toString(personnummer);
         int längd = persString.length();
         if(längd == 8) {
             System.out.println("du har person nummer"+ personnummer); 
           } 
         else {
             System.out.println("<ERROR: Personnummer ej giltigt.>");
            }
         return -1;
        } 
        catch (Exception e) {
           System.out.println("<ERROR: Personnummer ej giltigt.>");
           scan.nextLine();
         } 
         return personnummer; 
    }
//En funktion för att hitta bokade platser inom att gå inom fätet och hitta indexet som innehåller personnumer 
public static int hitta_plats(int personnumber)
{
 for (int i=0 ; i<platser.length ; i++){
     if (platser[i]==personnumber){
             System.out.println("du har plats"+(i) );
             return i;
        }
    }
    return -1;
}
public static int standardseat (int personnumber){
    for (int i=0 ; i<platser.length ; i++){
        if( platser [i]==0 ){
            platser[i]= personnumber; 
            int IND= -1 ; 
            for (int y=0 ; y<platser.length ;y++){
               if(platser[y]== personnumber){
                 IND = y;
                 System.out.println("tack för din bookning"+ "du har plats "+ (y++));
                 break;
                }
            }
        break;
    }
}
    return -1 ;
}
public static int avboka ( int personnumber){
     for ( int i= 0 ; i<platser.length ; i++){
              if (platser[i]==personnumber){
                  platser[i]=0; 
                  System.out.println("nu är din plats är avbokat");
                 break;
               }
              if(platser[i]==0 && platser[i]==1 ){
                  System.out.println("din bokning finns inte");
                  break; 
                }
            } 
     return -1;
}
// en funktion för att hitta en ledig fönster plats och spara personnnummert i det 
public static int windowseat ( int personnumber)
{
    for ( int i=0 ; i<platser.length ; i++){
        if (platser[i]==1 ){
            platser[i]=personnumber; 
            int IND = -1; 
            for( int y=0 ; y<platser.length ; y++){
                if (platser[y]==personnumber){
                    IND=y; 
                    System.out.println("tack för din bokning du har plats "+(y++));
                    break;
                }
            }
            break; 
        }
    }
    return -1; 
}
private static void calculateprofit (){
      int vuxenbiljett=0; 
      int barnbiljett = 0;
      int pasionarbiljett= 0; 
      double vinst=0; 
      double biljetpris=0; 
      int antalbiljetter = 0; 
      float ålder=0;
         for (int i=0 ; i<platser.length ; i++){
            if(platser[i]!=0 && platser[i]!=1){
              ålder= platser[i]/10000;
               int birthyear = (int)ålder;
               int age = 2023-birthyear; 
                     System.out.println("platsen är bokad");
                     antalbiljetter++ ;
                     if(age>=18 && ålder<69){
                         vuxenbiljett++;
                         
                       }
                     if( ålder>69){
                         pasionarbiljett++; 
                         
                        }
                     if(age<12){
                         barnbiljett++;
                        }    
            }     
        }
        double adultProfit = vuxenbiljett* biljettpris;
        double childProfit = barnbiljett * barn_pris;
        double seniorProfit = pasionarbiljett * SENIOR_pris;
        double totalProfit = adultProfit + childProfit + seniorProfit;
        
         System.out.println("Profit breakdown:");
        System.out.println("Adult tickets: " + vuxenbiljett+ " (Profit: " + adultProfit + ")");
        System.out.println("Child tickets: " + barnbiljett + " (Profit: " + childProfit + ")");
        System.out.println("Senior tickets: " + pasionarbiljett+ " (Profit: " + seniorProfit + ")");
        System.out.println("Total profit: " + totalProfit);
} 
        private static void listAgeGroup() {
            int ålder=0;
        for (int personnumber : platser)
            if(personnumber !=0 && personnumber!=1){
              int birthYear = personnumber / 10000;
               int birthyear = (int)ålder;
               int age = 2023-birthyear; 
            String ageGroup;
            if (age < 12) {
                ageGroup = "Child";
            } else if (age < 18) {
                ageGroup = "Teen";
            } else if (age>=18 && ålder<69) {
                ageGroup = "Adult";
            } else {
                ageGroup = "Senior";
            }
            System.out.println("Person number: " + personnumber + ", Age group: " + ageGroup);
        }
    }
}

