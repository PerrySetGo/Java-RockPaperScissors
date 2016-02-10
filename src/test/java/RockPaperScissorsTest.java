import org.junit.*;
import static org.junit.Assert.*;

public class RockPaperScissorsTest {

  @Test
  public void isTieIfMovesAreSame_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(0, (int) testRockPaperScissors.gameResult("Rock", "Rock"));
   }

  @Test
  public void RockWinsAgainstScissors_true() {
   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
   assertEquals(1, (int) testRockPaperScissors.gameResult("Rock", "Scissors"));
  }

  @Test
  public void ScissorsWinsAgainstPaper_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
     assertEquals(1, (int) testRockPaperScissors.gameResult("Scissors", "Paper"));
 }
  @Test
  public void PaperWinsAgainstRock_true() {
   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
   assertEquals(1, (int) testRockPaperScissors.gameResult("Paper", "Rock"));
  }

  @Test
  public void Player2WinsWithScissors_true() {
   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
   assertEquals(2, (int) testRockPaperScissors.gameResult("Paper", "Scissors"));
  }
  @Test
  public void Player2WinsWithPaper_true() {
   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
   assertEquals(2, (int) testRockPaperScissors.gameResult("Rock", "Paper"));
  }

  @Test
  public void Player2WinsWithRock_true() {
   RockPaperScissors testRockPaperScissors = new RockPaperScissors();
   assertEquals(2, (int) testRockPaperScissors.gameResult("Scissors", "Rock"));
  }
 }
