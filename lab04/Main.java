import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class WinnerWasCalled extends Exception {
}

class Log {

    public static void info() {
        System.out.println("");
    }

    public static void info(String message) {
        System.out.println(message);
    }

}

class Dice {

    private int sides;

    public int roll() {
        Random rand = new Random();
        int result = rand.nextInt(sides) + 1;

        Log.info("Dice roll: " + result);
        return result;
    }

    public void setSides(int sides){
        this.sides=sides;
    }

}

class Pawn {

    public int position;
    private String name;

    public Pawn(String name) {
        this.position = 0;
        this.name = name;

        Log.info(this.name + " joined the game.");
    }

    public String getName(){
        return this.name;
    }

    protected static int getRandomNuberOfPawns() {
        Random rand = new Random();
        return rand.nextInt(10) + 3;
    }
}

class Settings{

    Scanner sc = new Scanner(System.in);

    public int sides(){
        int sides;
        System.out.println("Podaj liczbę ścian kostki : ");
        do {
            sides = sc.nextInt();
            if(sides<3)WrongData();
        }while (sides<3);
         return sides;
    }

    public int max_positions(){
        int max_pos;
        System.out.println("Podaj liczbę pól na planszy : ");
        do {
            max_pos = sc.nextInt();
            if(max_pos<10)WrongData();
        }while (max_pos<10);

        return max_pos;
    }

    public int max_movments(){
        int max_mov;
        System.out.println("Podaj liczbę ruchów na turę : ");
        do {
            max_mov = sc.nextInt();
            if(max_mov<1)WrongData();
        }while (max_mov<1);
        return max_mov;
    }

    public String RandomName(){
        Random rand = new Random();
        String[] name ={"Bartek","Mateusz","Szymon","Alicja","Kasia","Wojtek","Zuza","Tadeusz","Kamil","Sara",
                "Ula","Paweł","Adrian","Michał","Ala","Wiktor","Łucja","Jagoda","Bożydar","Luke","Obiwan","Joda","ChomikVader"};
        return name[rand.nextInt(name.length)];
    }

    public void WrongData(){
        System.out.println("Błędne dane!!!");
    }


}


class Board {

    private static int max_position = 100;

    public ArrayList<Pawn> pawns;
    public Dice dice;
    public Pawn winner;
    public int turnsCounter;
    private int max_movments;

    public Board() {
        this.pawns = new ArrayList<Pawn>();
        this.dice = null;
        this.winner = null;
        this.turnsCounter = 0;
    }

    public void setMax_position(int max_position){
        Board.max_position =max_position;
    }
    public void setMax_movments(int max_movments){
        this.max_movments =max_movments;
    }



    public void performTurn() throws WinnerWasCalled {
        this.turnsCounter++;
        Log.info();
        Log.info("Turn " + this.turnsCounter);

        for(Pawn pawn : this.pawns) {
            for(int i=0 ; i<max_movments ; i++){
            int rollResult = this.dice.roll();
            pawn.position += rollResult;
            Log.info(pawn.getName() + " new position: " + pawn.position);

            if(pawn.position >= Board.max_position) {
                this.winner = pawn;
                throw new WinnerWasCalled();
            }
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.dice = new Dice();
        Settings settings =new Settings();

        board.dice.setSides(settings.sides());
        board.setMax_position(settings.max_positions());
        board.setMax_movments(settings.max_movments());




        for(int i=3; i<=Pawn.getRandomNuberOfPawns();i++) {
            board.pawns.add(new Pawn(settings.RandomName()));
        }


        try {
            while(true) {
                board.performTurn();
            }
        } catch(WinnerWasCalled exception) {
            Log.info();
            Log.info(board.winner.getName() + " won.");
        }
    }

}