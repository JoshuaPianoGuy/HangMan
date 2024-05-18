import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Hangman{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("1 or 2 players?");
        Scanner keyboard = new Scanner(System.in);
        String chosenWord;
        String numPlayers = keyboard.nextLine();
        List<String> words = new ArrayList<>();
        if(numPlayers.equals("1")){
            Scanner scanner = new Scanner(new File("words_alpha.txt"));
             while(scanner.hasNext()){
            words.add(scanner.nextLine());
        }
        Random random = new Random();
        chosenWord = words.get(random.nextInt(words.size()));
        }
        else{
            System.out.println("Player 1, please enter your word: ");
            chosenWord = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Time to guess Player 2");
        }
       
        List<Character> playerGuess = new ArrayList<>();
        int wrongCount = 0;
        while(true){
            printHangedMan(wrongCount);
            if(wrongCount>=6){
                System.out.println("You lose!");
                System.out.println("The correct word was \'" + chosenWord + "\'");
                break;
            }
            printWordState(chosenWord, playerGuess);
            if(!(getPlayerGuess(keyboard, chosenWord, playerGuess))){
                wrongCount++;
            };
            if(printWordState(chosenWord, playerGuess)){
                System.out.println("You win!!!");
                break;
            }
        }    

    }
    public static boolean printWordState(String chosenWord, List<Character> playerGuess){
        int correctCount = 0;
        for(int i = 0; i < chosenWord.length(); i++){
            if(playerGuess.contains(chosenWord.charAt(i))){
                System.out.print(chosenWord.charAt(i));
                correctCount++;
            }
            else{
                System.out.print("_");
            }
        }
        System.out.println();
        return (chosenWord.length() == correctCount);
    }
    public static boolean getPlayerGuess(Scanner keyboard, String chosenWord, List<Character> playerGuess){
        System.out.println("Please enter a character:");
        String guess = keyboard.nextLine();
        playerGuess.add(guess.charAt(0));
        return (chosenWord.contains(guess));

    }
    public static void printHangedMan(int wrongCount){
        System.out.println(" ------- ");
            System.out.println(" |     | ");
            if (wrongCount >=1){
                System.out.println(" O ");
            }
            if(wrongCount >=2){
                System.out.print("\\ ");
                if (wrongCount >=3){
                    System.out.println("/");
            }
            }
            else{
                System.out.println("");
            }
            if (wrongCount >=4){
                    System.out.println(" | ");
            }
            if(wrongCount >=5){
                System.out.print("/ ");
                if (wrongCount >=6){
                    System.out.println("\\");
            }
            }
            else{
                System.out.println("");
            }
    }
}
