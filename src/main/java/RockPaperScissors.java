import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.*;

public class RockPaperScissors {
  public static void main(String[] args){
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      String userOne = request.queryParams("userOne");
      String playerOneHand = request.queryParams("userOneRadio");

      String userTwo = request.queryParams("userTwo");
      String playerTwoHand = request.queryParams("userTwoRadio");

      //if the user two field is left blank, the computer plays.
      if (userTwo == ""){
        userTwo = "Computer";
      }

      if (playerTwoHand.equals("Random")){
        Random move = new Random();
        playerTwoHand = moveResult(move.nextInt(3));
        System.out.println("playerTwoHand" + playerTwoHand);
      }

      //main code
      Integer gameResults = gameResult(playerOneHand, playerTwoHand);
      System.out.println("gameResults " + gameResults);
      String gameResultsFinal;

      switch(gameResults){
        case 0:
        gameResultsFinal = String.format("It's a tie! Both %s and %s win :)", userOne, userTwo);
          break;
        case 1:
        gameResultsFinal = String.format("%s wins!" , userOne);
          break;
        case 2:
        gameResultsFinal = String.format("%s wins!" , userTwo);
          break;
        default:
        gameResultsFinal = "ERROR. Please try again later.";
          break;
      }
      model.put("userOne", userOne);
      model.put("userOneRadio", playerOneHand);
      model.put("userTwo", userTwo);
      model.put("userTwoRadio", playerTwoHand);
      model.put("gameResultsFinal", gameResultsFinal);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

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

    public static Integer gameResult (String playerOne, String playerTwo){
      Integer printOut;

      if (playerOne.equals(playerTwo)){
        printOut = 0; // It's a tie!
      }else if(playerOne.equals("Rock") && playerTwo.equals("Scissors")){
        printOut = 1; //Player One wins!
      }else if(playerOne.equals("Paper") && playerTwo.equals("Rock")){
        printOut = 1;
      }else if(playerOne.equals("Scissors") && playerTwo.equals("Paper")){
        printOut = 1;
      }else {
        printOut = 2; // Player Two wins!
      }
      return printOut;
    }
}
