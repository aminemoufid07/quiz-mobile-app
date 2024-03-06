package com.example.quizzapp_berhil_moufid;

public class Questions {

    private String mQuestions[] = {
            "Pouvez-vous deviner ce logo ?",
            "Et celui-ci ?",
            "OK, et ce logo ?",
            "Devinez ce logo ?",
            "Pouvez-vous deviner ce logo ?",
            "Essayez maintenant de deviner ce logo ?",
            "Et ce logo ?",
            "Pouvez-vous deviner ce logo ?",
            "Devinez le logo ?",
            "Pouvez-vous deviner ce logo ?"
    };

    private String mImagesUnfull[] = {
            "lays",
            "burgerking",
            "cisco",
            "hp",
            "levis",
            "nestle",
            "northface",
            "intel",
            "ups",
            "ferrari"
    };
    private String mImagesFull[] = {
            "laysfull",
            "burgerkingfull",
            "ciscofull",
            "hpfull",
            "levisfull",
            "nestlefull",
            "northfacefull",
            "intelfull",
            "upsfull",
            "ferrarifull"
    };

    private String mCorrectAnswers[] = {
            "lays",
            "burgerking",
            "cisco",
            "hp",
            "levis",
            "nestle",
            "thenorthface",
            "intel",
            "ups",
            "ferrari",

    };

    public String getQuestion(int q) {
        return mQuestions[q];
    }

    public String getImage(int q) {
        return mImagesUnfull[q];
    }

    public int getLength() {
        return mQuestions.length;
    }
    public String getImageFull(int q) {
        return mImagesFull[q];
    }

    public String getCorrectAnswer(int q) {
        return mCorrectAnswers[q];
    }
}
