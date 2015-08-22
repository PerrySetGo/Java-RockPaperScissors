import java.util.*;

public class Test2 {
  public static void main(String[] args){


      String playerOneHand = "Rock";
      String playerTwoHand = "Random";

      Random move = new Random();
      if (playerTwoHand == "Random"){
        playerOneHand = moveResult(move.nextInt(3));
        playerTwoHand = moveResult(move.nextInt(3));
        System.out.println("Player 1's move: " + playerOneHand);
        System.out.println("Player 2's move: " + playerTwoHand);
      }

      // run the main code
      Integer gameResults = gameResult(playerOneHand, playerTwoHand);
      String gameResultsFinal;

      if (gameResults == 0){
        gameResultsFinal = String.format("It's a tie!");
      }else if(gameResults == 1){
        gameResultsFinal = String.format("Player 1 wins!");
      }
      else{
        gameResultsFinal = String.format("Player 2 wins!");
      }
      System.out.println(gameResultsFinal);
  }


   //set up the cases for player moves
    public static String moveResult (Integer number){
      String playResult;

      switch(number){
        case 0:
        playResult = "Rock";
          break;

        case 1:
        playResult = "Paper";
          break;

        case 2:
        playResult = "Scissors";
          break;

        default:
        playResult = "Other";
          break;
      }
      return playResult;
  }

    //compare the game moves and determine a winner
    public static Integer gameResult (String playerOne, String playerTwo){
      Integer printOut;

      if (playerOne == playerTwo){
        printOut = 0; // It's a tie!
      }else if(playerOne == "Rock" && playerTwo == "Scissors"){
        printOut = 1; //Player One wins!
      }else if(playerOne == "Paper" && playerTwo == "Rock"){
        printOut = 1;
      }else if(playerOne == "Scissors" && playerTwo == "Paper"){
        printOut = 1;
      }else {
        printOut = 2; // Player Two wins!
      }
      return printOut;
    }

}
