package com.carvalho.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void opcaoSelecionada(View view) {
        this.optionSelected("rock");
    }

    public void opcaoPapel(View view) {
        this.optionSelected("paper");
    }

    public void opcaoTesoura(View view) {
        this.optionSelected("scissors");
    }

    public void optionSelected(String optionSelected) {
        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);

        int randomNum = new Random().nextInt(3);
        String[] options = {"rock", "paper", "scissors"};
        String optionsApp = options[randomNum];

        switch (optionsApp) {
            case "rock":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "paper":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "scissors":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (optionsApp == "rock" && optionSelected == "scissors") ||
                (optionsApp == "paper" && optionSelected == "rock") ||
                (optionsApp == "scissors" && optionSelected == "paper")
        ) {
            textResult.setText("Você perdeu \uD83D\uDE41");
        } else if (
                (optionSelected == "rock" && optionsApp == "scissors") ||
                (optionSelected == "paper" && optionsApp == "rock") ||
                (optionSelected == "scissors" && optionsApp == "paper")
        ){
            textResult.setText("Você Ganhou \uD83D\uDE04");
        } else{
            textResult.setText("Empatamos \uD83D\uDE09");
        }

        System.out.println("Item Clicado: " + optionSelected);
    }
}