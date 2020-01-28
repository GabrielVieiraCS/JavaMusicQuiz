// AUTHOR: GABRIEL VIEIRA
// A SIMPLE MUSIC QUIZ THAT EMPLOYS THE USE OF ARRAYS, ADTs, SORTING ALGORITHMS AND OTHER METHODS TO CREATE A FUN SET OF QUESTIONS THAT CHALLENGES THE PLAYER'S KNOWLEDGE

import java.util.*;
import java.util.Arrays;
import java.io.*;

import javax.lang.model.util.ElementScanner6;
import javax.swing.JOptionPane;

public class mainprojfinal
{
    // MAIN METHOD--------------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws IOException
    {
        // STRINGS TO DISPLAY COLOURS
     String RESET = "\u001B[0m";
     String BLACK = "\u001B[30m";
     String RED = "\u001B[31m";
     String GREEN = "\u001B[32m";
     String YELLOW = "\u001B[33m";
     String BLUE = "\u001B[34m";
     String PURPLE = "\u001B[35m";
     String CYAN = "\u001B[36m";
     String WHITE = "\u001B[37m";

        Question [] questions;
       
        String Name;
        questions = testQuestions();
      
        startgraphics(RED);
        Name = introduction();
        part1(questions, Name, CYAN);
        part2(PURPLE, CYAN);
        part3(Name, YELLOW, RED, BLUE);
        
        System.exit(0);
    } // ENDS main
    //--------------------------------------------------------------------------------------------------------------------
    
    public static void startgraphics(String RED)
    {
        // NESTED LOOP THAT PRINTS A PATTERN USED FOR THE INTRO
       for(int i = 0; i < 6; i++) //LOOP 1
       {
           for(int j = 6; j > i; j--) //LOOP 2
           {
               System.out.println(" ");
           }
           for(int k = 0; k < i*2; k++) //LOOP 3
           {
               System.out.println(RED + "*");
           }
           System.out.println("");
       }

        return;
    }

    // introduction method that obtains the user's name
   
    // Prepares the method to be ready to return an exception/ handle an exception
    public static String introduction() throws IOException 
    {   
        BufferedReader inputStream = new BufferedReader(new FileReader("save.txt"));
        //create the file using FileWriter
       
       
     //Custom button text
      String inputName = "";
      int g = -1;

      //While loop used to keep prompting for the player's name if no input has been entered
      while (g < 0)
      {
        inputName=
        JOptionPane.showInputDialog(null,
        "Please enter your name!",
        "Name",
        JOptionPane.QUESTION_MESSAGE); 

        
        if(inputName.length() > 0)
        {
            g++;
            JOptionPane.showMessageDialog(null,
            "Thank you " + inputName + "!",
            "Thanks",
            JOptionPane.PLAIN_MESSAGE);
        } 
        else
        {
            System.out.println("Please enter your name!");
        }
      }

      save1(inputName);

      String choice = 
      JOptionPane.showInputDialog(null,
        "Would you like to save? (y/n)",
        "SAVE",
        JOptionPane.QUESTION_MESSAGE); 

        if (choice.equals("y"))
        {
            String inputStram = inputName;
            inputStram = inputStream.readLine();
            while(inputStram!=null)
            {
                //This is the output
                
                inputStram = inputStream.readLine();
            }
        }else

        //Tidies the program by closing the IO streams
        inputStream.close();
        

        return inputName;
    } // ENDS introduction method

    // Saves user's name in a .txt document
    public static void save1(String inputName) throws IOException
    {
        PrintWriter outputStream = new PrintWriter (new FileWriter("save.txt"));
        outputStream.println(inputName);
        outputStream.close();
    }

    // PART 1/3 OF QUESTIONS
    public static void part1(Question[] questions, String Name, String CYAN)
    {
        Scanner userans = new Scanner(System.in);
        int userscore = 0;
        
        System.out.println("PART 1:");
        System.out.println("Hello " + Name + ", let's see how well you do in Part 1!");
       
        for(int i = 0; i < questions.length; i++)
        {
            System.out.println(questions[i].query);
            String answer = userans.nextLine();
                if (answer.equals(questions[i].answer) && answer.length() > 0)
                {
                    userscore++;
                }
                else if (answer.length() > 0)
                {
                    userscore = userscore + 0;
                }
                else if (answer.length() < 1)
                {
                    System.out.println("No lucky guess?");
                }
       
        }
       
        System.out.println(CYAN + "You scored " + userscore + " / " + questions.length + ".");
        return;
    }

    // PART 2/3 OF QUESTIONS
    public static void part2(String PURPLE, String CYAN)
    {
        QuestionPro q1 = createquestion("What year was the famous Live Aid Concert?"
        +" (a) 1992 / (b) 1987 / (c) 1985 / (d) 1986 / (e) 1976", "c");
       
        QuestionPro q2 = createquestion("How many Grammy Awards has Beyoncé won? "
        +"(a) 22 / (b) 21 / (c) 19 / (d) 14 / (e) 26", "a");

        QuestionPro q3 = createquestion("Who was the first artist to be indicted into the Rock & Roll Hall of Fame?"
        + " (a) Eric Clapton / (b) George Harrison / (c) Chuck Berry / (d) Albert King / (e) Slash", "a");

        QuestionPro q4 = createquestion("Who is the composer of the Star Wars film franchise?"
        + " (a) Hans Zimmer / (b) John Williams / (c) Danny Elfman / (d) James Horner", "b");
        Scanner answersc = new Scanner(System.in);

        int userscore = 0; //A variable that tracks the userscore out of the number of questions asked
        
        System.out.println(" ");
        System.out.println(PURPLE + "PART 2:");
        System.out.println(q1.querypro);
        String answer1 = answersc.nextLine();
        if(answer1.equals(q1.answerpro))
        {
            userscore++;
        }

        System.out.println(q2.querypro);
        String answer2 = answersc.nextLine();
        if(answer2.equals(q2.answerpro))
        {
            userscore++;
        }

        System.out.println(q3.querypro);
        String answer3 = answersc.nextLine();
        if(answer3.equals(q3.answerpro))
        {
            userscore++;
        }

        System.out.println(q4.querypro);
        String answer4 = answersc.nextLine();
        if(answer4.equals(q4.answerpro))
        {
            userscore++;
        }

        System.out.println(CYAN + "You scored " + userscore + "/4.");
       
    }

    // PART 3/3 OF QUESTIONS
    public static void part3(String Name, String YELLOW, String RED, String BLUE)
    {
        BonusQuestion b1 = createbonus("How many total awards has Taylor Swift won during her career?",23); 

        BonusQuestion b2 = createbonus ("How many total awards has Ed Sheeran won during his career?.",97);

        BonusQuestion b3 = createbonus("How many total awards has Kanye West won during his career?",92); 
       
        System.out.println("");
        System.out.println(YELLOW + "PART 3 (BONUS)");
        System.out.println("Thank you for playing so far " + Name + ". Let's see if you are smart enough (or lucky) for this part!");
        System.out.println("");

        // COLLECTS THE USER'S INPUT
        Scanner userans = new Scanner(System.in);

        // AN ARRAY THAT WILL STORE THE USER's INPUT
        int [] useranswer = new int[3];
        
        //INTRODUCES THE QUESTION TO PLAYER
        System.out.println(RED + "IMPORTANT INFO: One artist has 92 awards, another has 23, and the last has 97.");
        System.out.println("");
        System.out.println(YELLOW + "Match the awards to the artist!");

        System.out.println(YELLOW + b1.querybonus);
        useranswer[0] = userans.nextInt();

        System.out.println(YELLOW + b2.querybonus);
        useranswer[1] = userans.nextInt();
        
        System.out.println(YELLOW + b3.querybonus);
        useranswer[2] = userans.nextInt();

        System.out.println(BLUE + "You entered: Taylor Swift - " + useranswer[0] + ", Ed Sheeran - " + useranswer[1] + ", Kanye West - " + useranswer[2] + ".");

        // PUTS THE CORRECT ANSWERS INTO AN ARRAY SO THEY CAN BE ORDERED
        int[] actualanswer = new int[3];
        actualanswer[0] = b1.answerbonus; //23
        actualanswer[1] = b2.answerbonus; //97
        actualanswer[2] = b3.answerbonus; //92

        
        //METHOD THAT ORDERS THE ARRAY WITH A SORT METHOD
        BubbleSort(actualanswer);
       
    }

    // A METHOD USED TO CREATE A BUBBLESORT ALGORITHM TO PUT THE ACTUAL VALUES IN ASCENDING ORDER TO MATCH THE ORDER OF ARTISTS
    public static void BubbleSort(int[] actualanswer)
    {
        int i, j, k = 0;
        for(i = 0; i < actualanswer.length - 1; i++)
        {
            for(j = 0; j < actualanswer.length -1 -i; j++) // -i as we take away the number of iterations already sorted
            {
                if(actualanswer[j] > actualanswer[j+1])
                {
                    k = actualanswer[j]; //k variable is used as a temp variable to allow the swap
                    actualanswer[j] = actualanswer[j+1];
                    actualanswer[j+1] = k;
                }
            }
        }
        //REVEALS ACTUAL ANSWER IN CORRECT ORDER
        System.out.println("");
        System.out.println("The answer relative to the order above is: " + java.util.Arrays.toString(actualanswer));

        return;
    } //ENDS BubbleSort method

    // METHOD THAT CREATES THE FIRST SET OF QUESTIONS AS AN ARRAY
    public static Question[] testQuestions()
    {
        String question1 = "Brian May is famously the guitarist for which band?"
                         + "(a) Queen / (b) Pink Floyd / (c) Cream";

        String question2 = "What was the first electric guitar ever produced?"
                         + "(a) The Rickenbacker/ (b) Fender Telecaster / (c) Les Paul";

        String question3 = "Jimmy Page is an English musician who formed which rock band in 1968?"
                         + "(a) The Yardbirds/ (b) Led Zeppelin/ (c) The Beatles";
        
        Question [] questions = {
            new Question(question1, "a"),
            new Question(question2, "a"),
            new Question(question3, "b")
        };

        return questions;
    } // Returns array of questions back to main to be passed to amother method

   
    // METHOD THAT CREATES A QUESTION TYPE TO BE USED IN HARDER QUESTIONS
    public static QuestionPro createquestion(String querypro, String answerpro)
    {
        QuestionPro q = new QuestionPro();

        q.querypro = querypro;
        q.answerpro = answerpro;

        return q;
    }

    // SETTER METHOD FOR PART 2 QUESTIONS
    public void setQueryPro(QuestionPro q, String querypro)
    {
        q.querypro = querypro;
    }

    // SETTER METHOD FOR PART 2 QUESTIONS
    public String getQueryPro(QuestionPro q)
    {
        return q.querypro;
    }

    // SETTER METHOD FOR PART 2 ANSWERS
    public void setAnswerPro(QuestionPro q, String answerpro)
    {
        q.answerpro = answerpro;
    }

    // GETTER METHOD FOR PART 3 ANSWERS
    public String getAnswerPro(QuestionPro q)
    {
        return q.answerpro;
    }

    //METHOD THAT CREATES A BONUS QUESTION TYPE
    public static BonusQuestion createbonus(String querybonus, int answerbonus)
    {
        BonusQuestion b = new BonusQuestion();

        b.querybonus = querybonus;
        b.answerbonus = answerbonus;

        return b;
    }

    //SETTER METHOD FOR THE BONUS QUESTION
    public void setBonusQuery(BonusQuestion b, String querybonus)
    {
        b.querybonus = querybonus;
    }

    //GETTER METHOD FOR THE BONUS QUESTION
    public String getBonusQuery(BonusQuestion b)
    {
        return b.querybonus;
    }

    //SETTER METHOD FOR THE BONUS ANSWER
    public void setBonusAnswer(BonusQuestion b, int answerbonus)
    {
        b.answerbonus = answerbonus;
    }

    //GETTER METHOD FOR THE BONUS ANSWER
    public int getBonusAnswer(BonusQuestion b)
    {
        return b.answerbonus;
    }
}



//----------------------------------------------------------------------------------------------------------------------
class Question
{
    String query;
    String answer;

    public Question(String query, String answer)
    {
        this.query = query;
        this.answer = answer; 
        // The "this" keyword is used to differentiate an instance variable from a local variable
    }
} // ENDS class Question

class QuestionPro
{
    String querypro;
    String answerpro;
} // ENDS class QuestionPro

class BonusQuestion
{
    String querybonus;
    int answerbonus;
} //ENDS class BonusQuestion
//----------------------------------------------------------------------------------------------------------------------


