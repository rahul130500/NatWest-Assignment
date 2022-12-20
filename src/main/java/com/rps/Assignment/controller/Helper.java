package com.rps.Assignment.controller;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;

import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Helper {
    public static int GenerateRandomNumber(){
        Random random = new Random();
        int value = random.nextInt(3) ;
        return value;
    }
    // Function to check whether player move is valid or not
    public static boolean CheckValidMove(String PlayerMove){
        String[] ValidMoves =new String[] {"ROCK", "PAPER", "SCISSOR"};
        return Arrays.asList(ValidMoves).contains(PlayerMove);
    }
    // Function to generate the computer's move
    public static String GenerateComputerMove(){
        String[] moves =new String[] {"ROCK", "PAPER", "SCISSOR"};
        int value = GenerateRandomNumber();
        return moves[value];
    }

    // Function to compare the moves and to get the result
    public static String GetResult(String Player, String Computer){
        if (Objects.equals(Player, Computer)){
            return "It is a tie";
        }else if(Objects.equals(Player, "ROCK")){
            if(Objects.equals(Computer, "PAPER")) return "Computer wins";
            else return "Player wins";
        }else if(Objects.equals(Player, "PAPER")){
            if(Objects.equals(Computer, "SCISSOR")) return "Computer wins";
            else return "Player wins";
        }else {
            if(Objects.equals(Computer, "ROCK")) return "Computer wins";
            else return "Player wins";
        }
    }
    public static String PlayGame(String playerMove, Logger logger){
        String ans;
        if(Helper.CheckValidMove(playerMove)){
            String computerMove = GenerateComputerMove();
            logger.info("Player Move is " + playerMove);
            logger.info("Computer Move is " + computerMove);
            ans = GetResult(playerMove, computerMove);
        }else{
            ans = "Player move is invalid";
        }
        return ans;
    }
}
