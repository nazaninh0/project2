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
    static int [] platser= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Scanner scan= new Scanner (System.in);
     //int [][]platser = new int [21][21];
     public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan= new Scanner (System.in);
        System.out.println("welcome to booking bus");
        System.out.println("|1 |2 |  |3 |4 |\n|5 |6 |  |7 |8 |\n|9 |10|  |11|12|\n|13|14|  |15|16|\n|17|18|19|20|21|\n\n");
        final double PRIS = 299.90; 
        final double BARN_PRIS= 149.0; 
        final double P_PRIS= 199.0; 
        while (true) {
            System.out.println("menu: \n 1.books an unbooked sitt \n 2. print out all the unbooked plats \n 3. calculate profit \n 4.avboka \n 5.finish the program" );
            int val = scan.nextInt();
            //int loop = 1;
            int personnumber = 0;
            int seatnummer=0;
            while (val!=0){
               int year= 2023;
               if (val == 1){
                  for (int i = 0; i < platser.length; i++) {
                     System.out.println("ange platsen som du vill boka");
                     seatnummer=scan.nextInt();
                        if (seatnummer==0 && seatnummer>21){
                            System.out.println("ange rätt seat nummer");
                        }
                        else{
                            if (platser[i] == 0) {
                                 try{
                                     System.out.println("skriv in ditt födelse år 4 siffror ");
                                      personnumber= scan.nextInt();  
                                 }
                                 catch(Exception e){
                                     System.out.println("skriv siffror");
                                     scan.nextLine();
                                     continue;
                                 }
                                 platser[i]=personnumber;
                                 platser[i]+=seatnummer;
                                 platser[i]++;
                                 System.out.println("tack för din bookning"+ "du har plats "+seatnummer );
                                 //loop = 0;
                                 break;
                            }
                         
                            else {
                                System.out.println("den här platsen är tyvärr upptagen");
                                break;
                            }
                }  
                   
                }
               
               break;}
                if (val==2)
                {
                 hitta_plats(personnumber , seatnummer); 
                 break;
                }
                if(val==3)
                {
                  int vuxenbiljett=0; 
                  int barnbiljett = 0;
                  int pasionarbiljett= 0; 
                  double vinst=0; 
                  double biljetpris=0; 
                  int ålder= year-personnumber; 
                  int antalbiljetter = 0; 
                   for (int i=0 ; i<platser.length ; i++){
                          if(platser[i]!=0){
                              System.out.println("platsen är bokad");
                             antalbiljetter++ ; 
                              if(platser[i]!=0 && ålder>18 && ålder<69){
                              biljetpris= PRIS; 
                              vuxenbiljett++;
                            }
                           if(platser[i]!=0&& ålder>69){
                             biljetpris= P_PRIS; 
                             pasionarbiljett++; 
                            }
                           if(platser[i]!=0 && ålder<12){
                              biljetpris= BARN_PRIS; 
                              barnbiljett++;
                            }
                        }
                    
                    }
                  vinst+=biljetpris;
                  double total = PRIS*antalbiljetter++;
                  double b_total= BARN_PRIS*barnbiljett++;
                  double p_total= P_PRIS*pasionarbiljett++;
                  double v_total= PRIS*vuxenbiljett++; 
                  System.out.println("vinsten för antal bokade plats för vuxna är "+ v_total);
                  System.out.println("vinsten för bokade plats för pansionärer är "+p_total);
                  System.out.println("vinsten är"+total);
                  System.out.println("vinsten för bokade plats för barn är"+b_total);
                  break;
                }    
            
                if(val== 4)
                {
                  System.out.println("ange ditt person nummer ");
                  personnumber= scan.nextInt(); 
                 for ( int i= 0 ; i<platser.length ; i++){
                     if (platser[i]==personnumber){
                         platser[i]=0; 
                         System.out.println("nu är din plats är avbokat");
                         break;
                        }
                     if(platser[i]==0){
                         System.out.println("din bokning finns inte");
                        }
                }
                }
               if (val==5){
                 System.out.println("exit");
                 break;
                }  
               
            }
  }
}

public static int hitta_plats(int person_number , int seat_number){
 for (int i=0 ; i<platser.length ; i++){
     if (platser[i]==person_number){
         platser[i]++;
         System.out.println("du har plats"+(i++) +" och seat nummer" +platser[i]);
         break;
        }
    }
  return -1;
}
}
  




   
