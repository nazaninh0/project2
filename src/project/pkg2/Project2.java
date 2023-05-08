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
    Scanner scan= new Scanner (System.in);
     //int [][]platser = new int [21][21];
    
     public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan= new Scanner (System.in);
        System.out.println("welcome to booking bus");
        System.out.println("|1 |2 |  |3 |4 |\n|5 |6 |  |7 |8 |\n|9 |10|  |11|12|\n|13|14|  |15|16|\n|17|18|19|20|21|\n\n");
        int val=0;
        // när while är true då loopas menyn 
        while (true) {
            System.out.println("menu: \n 1.books an unbooked sitt \n 2. print out all the unbooked plats \n 3. calculate profit \n 4.avboka \n 5.list the age group\n 6.exit" );
            val = scan.nextInt();
            //int loop = 1;
            int personnumber=0;
            int seatnummer=0;
            int multiple_val =0 ; 
            while (val!=0 && val<7){
               int year= 2023;
               if (val == 1){
                   System.out.println("vill boka en 1: fönster plats eller 2:stardand plats");
                   multiple_val = scan.nextInt();
                   if (multiple_val==2 ){
                     System.out.println("ange platsen som du vill boka");
                     seatnummer=scan.nextInt();
                     if (seatnummer==0 && seatnummer>21){
                         System.out.println("ange rätt seat nummer");
                        }   
                     else{
                         // om indexet in fältet är noll då tar vi in personnummert 
                         for (int i = 0 ; i < platser.length; i++) {
                             if (platser[i] == 0) {
                                  try{
                                      System.out.println("skriv in ditt personnummer YYYYMMDD ");
                                      personnumber= scan.nextInt(); 
                                    }
                                   catch(Exception e){
                                      System.out.println("skriv siffror");
                                      scan.nextLine();
                                      continue;
                                    }
                                  
                                  //personnummert sparas i fäletet och man får en plats 
                                  platser[i]=personnumber;
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
                        break; 
                        }
               }
                   else if (multiple_val==1){
                       System.out.println("ange personnumer");
                       personnumber=scan.nextInt();
                     windowseat(personnumber); 
                     break;
                    }
              break;
            }
         else if (val==2) {
             hitta_plats(personnumber); 
              break;
            }
         if(val==3){
             final double PRIS = 299.90; 
             final double BARN_PRIS= 149.0; 
             final double P_PRIS= 199.0; 
             int vuxenbiljett=0; 
             int barnbiljett = 0;
             int pasionarbiljett= 0; 
             double vinst=0; 
             double biljetpris=0; 
             int antalbiljetter = 0; 
             int ålder=0;
             for (int i=0 ; i<platser.length ; i++){
                 if(platser[i]!=0){
                     ålder= platser[i]/10000;
                     int birthyear = (int)ålder;
                     int age = year-birthyear; 
                     System.out.println("platsen är bokad");
                     antalbiljetter++ ;
                     if(age>=18 && age<69){
                         //biljetpris= PRIS; 
                         vuxenbiljett++;
                         break;
                       }
                     if(platser[i]!=0 && age>69){
                         //biljetpris= P_PRIS; 
                         pasionarbiljett++; 
                         break;
                        }
                     if(platser[i]!=0 && age<12){
                         //biljetpris= BARN_PRIS; 
                         barnbiljett++;
                         break;
                        }    
                     break;
                 } 
                }
                double b_total= BARN_PRIS*barnbiljett;
                double p_total= P_PRIS*pasionarbiljett;
                double v_total= PRIS*vuxenbiljett++;
                double total = b_total+v_total+p_total;
                System.out.println("vinsten för antal bokade plats för vuxna är "+ v_total);
                System.out.println("vinsten för bokade plats för pansionärer är "+p_total);
                System.out.println("vinsten för bokade plats för barn är"+b_total);
                System.out.println("vinsten är"+total);
                
                break;
           } 
            //man anger personnummmert och om platsen är inte noll då hittar den platsen som innehåller personnumert och avbokar den 
          else if(val== 4){
              System.out.println("ange ditt person nummer ");
             personnumber= scan.nextInt(); 
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
         
          if (val==5){
             System.out.println("ange personnummer ");
             personnumber=scan.nextInt();
             agegrupp(personnumber);
            
            }  
          if(val==6){
             System.out.println("exit");
             break;
             }        
        }
  }
  }
} 
//En funktion för att hitta bokade platser inom att gå inom fätet och hitta indexet som innehåller personnumer 
public static int hitta_plats(int person_number){
 for (int i=0 ; i<platser.length ; i++){
     if (platser[i]==person_number ){
             System.out.println("du har plats"+(i) );
             return i;
        }
        }
        
    
    return -1;
}
// en funktion för att hitta en ledig fönster plats och spara personnnummert i det 
public static int windowseat ( int person_number){
    for ( int i=0 ; i<platser.length ; i++){
        if (platser[i]==1 ){
            platser[i]=person_number; 
            int IND = -1; 
            for( int y=0 ; y<platser.length ; y++){
                if (platser[y]==person_number){
                    IND=y; 
                    System.out.println("tack för din bokning du har plats "+(y++));
                    break;
                }
            }
             
        }
        else{
            return-1; 
        }
    }
    return -1; 
}
// metoden går inom platser som innehåller personnumert och sorterar dem i olika ålders grupp 
 static void agegrupp(int person_number){
    String pers = Integer.toString(person_number);
    int age = 0 ;
    for (int i=0 ; i<4 ; i++){
        int PERSIND = Integer.parseInt(String.valueOf(pers.charAt(i)));
        switch (i) {
            case 0:
                PERSIND*=1000;
                break;
            case 1:
                PERSIND*=100;
                break;
            case 2:
                PERSIND*=10;
                break;
            default:
                break;
        }
        age+=PERSIND;
    }
     System.out.println("du är "+age);
}
}  
