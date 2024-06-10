package org.example;

public class QuizCard {

    private String question;
    private String answer;

    public QuizCard(String question, String answer){
        this.answer = answer;
        this.question = question;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }
}
