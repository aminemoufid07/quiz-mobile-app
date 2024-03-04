package com.example.quizzapp_berhil_moufid;

public class Questions {

    private String mQuestions[] = {
            "Can you guess this logo ?",
            "What about this logo ?",
            "Okay, and this logo ?",
            "Guess this logo ?",
            "Can you guess this logo ?",
            "Now try to guess this logo ?",
            "And this logo ?",
            "Can you guess this logo ?",
            "Guess the logo ?",
            "Can you guess this logo ?"
    };

    private String mChoice[] [] = {
            {"AmaZone","Amazonia","Amazon"},
            {"Ferretti","Ferris","Ferrari"},
            {"Google","Gogol","Goggle"},
            {"MacDinner","McDonald's","MacDonny's"},
            {"Nake","Nick","Nike"},
            {"Pinning","Pinterest","Pintastic"},
            {"PlayStation","PlayBox","PlayNation"},
            {"StarCup","Starbucks","Star Beans"},
            {"Shell","SeaShell","ShellOil"},
            {"Telsa","Tesler","Tesla"}
    };

    private String mImages[] = {
            "amzn",
            "ferr",
            "g",
            "mcdon",
            "nik",
            "pin",
            "play",
            "sb",
            "shell",
            "tes"
    };

    private String mQuestionsType[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton"
    };

    private String mCorrectAnswers[] = {
            "Amazon",
            "Ferrari",
            "Google",
            "McDonald's",
            "Nike",
            "Pinterest",
            "PlayStation",
            "StarBucks",
            "Shell",
            "Tesla"
    };

    public String getQuestions(int q){
        String questions = mQuestions[q];
        return questions;
    }

    public String[] getChoice(int q) {
        String [] choice = mChoice[q];
        return choice;
    }

    public String getImages(int q) {
        String img = mImages[q];
        return img;
    }

    public String getType(int q) {
        String type = mQuestionsType[q];
        return type;
    }

    public int getLength(){
        return mQuestions.length;
    }

    public String getCorrectAnswers(int q) {
        String correct = mCorrectAnswers[q];
        return correct;
    }
}