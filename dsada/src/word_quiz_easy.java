package dsada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;  //adds Arrays utility from java library 
import java.util.List;  //adds List utility from java library 
import java.util.Scanner;  //adds Scanner utility from java library 
import java.util.Collections;  //adds Collections utility from java library  

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

public class word_quiz_easy extends JPanel {
private mainframe F;

	public word_quiz_easy(mainframe f) {
		F=f;
		setBounds(100, 100, 1008, 592);
		setLayout(null);
	}
	
	int correct=0, number, i;
    String question, answer;
    String EasyQuestion, EasyAnswer ;//문제 답난이도와 경로
    String path = word_quiz_easy.class.getResource("").getPath();
    boolean time = true;//시간 조절   
    word_quiz_easy[] quizBank = new word_quiz_easy[11];             
    List<word_quiz_easy> quizList = Arrays.asList(quizBank);    
    
    public static void main(String[] args){ //start of main { 
    	word_quiz_easy bank = new word_quiz_easy();  //creates new Quiz object 
        bank.bankList();  //assigns name of portion of program to build the collection of questions and answers 
        bank.askQuestion();//assigns name of portion of program to ask the questions 
    }  //end main 
    
    public void bankList(){ //start of bankList 
    i = 0;
    for(int k = 0; k < 11; k++){
       quizBank[k] = new EasyQuiz();
    }
   try {
   BufferedReader Easy_Question = new BufferedReader(new FileReader(path + "EasyQuestion"));
      BufferedReader Easy_Answer = new BufferedReader(new FileReader(path + "EasyAnswer"));
      while((EasyQuestion = Easy_Question.readLine()) != null){
         {
                quizBank[i].question =  EasyQuestion;
                   i++;
            }
   } 
      i = 0;
      while((EasyAnswer = Easy_Answer.readLine()) != null){
         {
               quizBank[i].answer = EasyAnswer;
               i++;
         }
   } 
    quizBank[10].question ="아";
    quizBank[10].answer = "아";

   } catch (FileNotFoundException e) {//파일이 예외처리
      e.printStackTrace();
      } 
      catch (IOException e) {
      // TODO Auto-generated catch block
         e.printStackTrace();
      }
         Collections.shuffle(quizList);  //shuffles the list
         
      }

      //end of bankList 
    

    public Image correct_image(String Problem_Name){//문제의 이름과 일치하는 
          Image image = null;
           try{
               File sourceimage = new File(path + Problem_Name);
               image = ImageIO.read(sourceimage);
            } 
              catch (IOException e) {
         e.printStackTrace();
      
       }
      return image;
    }
    
    class Basic_askQuestion extends SwingWorker<Void,Integer>{
    	public Void doInBackground(){
                for (number=1; number<6; number++){  //start of counter for loop (문제 숫자 조정)
                   correct_image(quizBank[number].question);
                   System.out.printf("%d. %s?%n", number, quizBank[number].question);
                   //prints question(이걸 그림으로 할지, 아니면 워드로 할지) 
                    System.out.println("Please Write Your Answers:");  
                    while(true)
                    {
                       try {
                                Thread.sleep(1000);
                             } 
                       catch (InterruptedException e) {
                                   e.printStackTrace();
                             }
                       String enter = Integer.toString(leaplisten.current_state);
                       //if(Vowel[0].answer==enter){  //checks the users input          
                       if(leap==2){
                         System.out.println("*** Correct! ***"); 
                          correct = correct + 1;//counts number of correct answers 
                          break;
                        }  //end of if 
                    }
                    System.out.printf(" Your score is %d/%d%n", correct, number-1);  //prints results 
                
            }  //end of askQuestion 
			return null;
    		
    	}
    	protected void process(List<Integer> a){
    		
    	}
    }
} // end of panel