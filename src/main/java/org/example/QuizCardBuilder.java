package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);

        mainPanel.add(new JLabel("Question"));
        mainPanel.add(qScroller);
        mainPanel.add(new JLabel("Answer"));
        mainPanel.add(aScroller);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(event -> nextCard());
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(event -> clearAll());

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(event -> saveCard());

        menuBar.add(newMenuItem);
        menuBar.add(saveMenuItem);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);


    }

    private void nextCard(){
        QuizCard newCard = new QuizCard(question.getText(), answer.getText());
        cardList.add(newCard);

        clearCard();

    }

    private void saveCard(){
        QuizCard newCard = new QuizCard(question.getText(), answer.getText());
        cardList.add(newCard);


        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(frame);
        saveFile(jFileChooser.getSelectedFile());

    }

    private void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();

    }

    private void saveFile(File file){
        try{

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for(QuizCard quizCard : cardList ){
                bufferedWriter.write(quizCard.getQuestion() + "/");
                bufferedWriter.write(quizCard.getAnswer() + "\n");

            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    private void clearAll(){
        cardList.clear();
        clearCard();
    }


    private JScrollPane createScroller(JTextArea textArea){
        JScrollPane jScrollPane = new JScrollPane(textArea);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        return jScrollPane;

    }

    private JTextArea createTextArea(Font font){
        JTextArea jTextArea  = new JTextArea(6,20);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setFont(font);

        return  jTextArea;

    }
}
