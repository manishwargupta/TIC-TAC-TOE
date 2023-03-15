import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class tictactoe {

    static ArrayList<Integer> playerpos = new ArrayList<Integer>();
    static ArrayList<Integer> Compos = new ArrayList<Integer>();
    
    public static void main(String[] args) {
       
        System.out.println(" -/- WELCOME TO THE TIC - TAC - TOE GAME -/-");

        // for printing board

        char [][] gameboard = {{' ',' ',' '},
                               {' ',' ',' '},
                               {' ',' ',' '}};

         

        board(gameboard);

        while(true){
            Scanner sc = new Scanner (System.in);
            System.out.print("\n Enter your position between 1-9 : ");
            int playerposition=sc.nextInt();
            while (playerpos.contains(playerposition) || Compos.contains(playerposition)){
                System.out.println("This position is already taken ! Enter next pos :");
                playerposition = sc.nextInt();
            }
       
            placesymbol(gameboard,playerposition,"Player");
            String checkwinner = WinnerCond();
           if (checkwinner.length()>0){
            System.out.println(checkwinner);
            break;
           }

            Random rd = new Random();
            int Compposition = rd.nextInt(9)+1;
            while (playerpos.contains(Compposition) || Compos.contains(Compposition)){
            
                Compposition = rd.nextInt(9)+1;
            }

            placesymbol(gameboard,Compposition,"Computer");
            board(gameboard);
            checkwinner = WinnerCond();
           if (checkwinner.length()>0){
            System.out.println(checkwinner);
            break;
           }
           
        }

        }

    
    //Method for printing board

     static void board(char[][] gameboard){
        System.out.println(gameboard[0][0]+" | "+gameboard[0][1]+" | "+gameboard[0][2]); 
        System.out.println("-"+" + "+"-"+" + "+"-");
        System.out.println(gameboard[1][0]+" | "+gameboard[1][1]+" | "+gameboard[1][2]); 
        System.out.println("-"+" + "+"-"+" + "+"-");  
        System.out.println(gameboard[2][0]+" | "+gameboard[2][1]+" | "+gameboard[2][2]);
    }


    // Board Game Specification and Symbol

    public static void placesymbol(char[][] gameboard,int pos,String userinput){

        char symbol = ' ';
        if (userinput=="Player"){
            symbol = 'X';
            playerpos.add(pos);
        }else if (userinput == "Computer" ){
            symbol = 'O';
            Compos.add(pos);
        }
        switch(pos){

            case 1:{
                gameboard [0][0]=symbol;
                break;
            }

            case 2:{
                gameboard [0][1]=symbol;
                break;
            }

            case 3:{
                gameboard [0][2]=symbol;
                break;

            }

            case 4:{
                gameboard [1][0]=symbol;
                break;

            }

            case 5:{
                gameboard [1][1]=symbol;
                break;

            }

            case 6:{
                gameboard [1][2]=symbol;
                break;

            }

            case 7:{
                gameboard [2][0]=symbol;
                break;

            }

            case 8:{
                gameboard [2][1]=symbol;
                break;

            }

            case 9:{
                gameboard [2][2]=symbol;
                break;

            }
            default :{
                break;
            }

           
        }
    }

    // Condition to check the winner and Loser.
    
    public static String WinnerCond(){

        List FirstRow = Arrays.asList(1,2,3);
        List SecondRow = Arrays.asList(4,5,6);
        List ThirdRow = Arrays.asList(7,8,9);
        List FirstCol = Arrays.asList(1,4,7);
        List SecondCol = Arrays.asList(2,5,8);
        List ThirdCol= Arrays.asList(3,6,9);
        List Diag1 = Arrays.asList(1,5,9);
        List Diag2 = Arrays.asList(7,5,3);

        List <List> winner  = new ArrayList<List>();
        winner.add(FirstRow);
        winner.add(SecondRow);
        winner.add(ThirdRow);
        winner.add(FirstCol);
        winner.add(SecondCol);
        winner.add(ThirdCol);
        winner.add(Diag1);
        winner.add(Diag2);

        for(List l : winner){
            if (playerpos.containsAll(l)){
                return " Hurray! You Won ";
            }
            else if (Compos.containsAll(l)){
                return "Oops! You Lose";
            }else if(playerpos.size()+Compos.size()==9){
                return " TIE";
            }
        }

        return "";

    }
     
    
}
