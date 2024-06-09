package org.example;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class QuizCardBuilder {
    private ArrayList<QuizCard> cardList = new ArrayList<>();
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;
    public static void main(String[] args){
        new QuizCardBuilder().go();
    }
    public void go(){
        JFrame window = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();


    }

    public void nextCard(){

    }

    public void saveCard(){

    }

    public void clearCard(){

    }

    private void saveFile(File file){

    }
}
