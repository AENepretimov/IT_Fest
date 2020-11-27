package com.example.testandroid241120;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //переменные для привязки эл-тов разметки
    private TextView tvScore;
    private Button btn1, btn2, btn3;
    //флаги для отслеживания цвета
    private boolean isGreenBtn1, isGreenBtn2, isGreenBtn3;

    //баллы
    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //обнуляем при запуске активности
        score = 0;

        //задаем элементы поиском по Id
        tvScore = (TextView) findViewById(R.id.tv_score);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);

        //красим кнопки в зеленый
        isGreenBtn1 = setGreenBtn(btn1);
        isGreenBtn2 = setGreenBtn(btn2);
        isGreenBtn3 = setGreenBtn(btn3);

        //ставим слушателя нажатий
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickBtn( isGreenBtn1 );

            }
        });

        //ставим слушателя нажатий
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickBtn( isGreenBtn2 );

            }
        });

        //ставим слушателя нажатий
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickBtn( isGreenBtn3 );

            }
        });

    }

    //увеличить баллы и показать
    public void incScoreAndView(){
        //увеличили
        score++;
        //показали
        tvScore.setText( score.toString() );
    }

    //уменьшить баллы и показать
    public void decScoreAndView(){
        //уменьшили
        score -= 3;
        //показали
        tvScore.setText( score.toString() );
    }

    //установить цвет кнопки в зеленый
    public boolean setGreenBtn(Button btn){
        //изменили цвет на зеленый
        btn.setBackgroundColor(getResources().getColor(R.color.myGreen));
        //вернули true для установки флага зеленого цвета (см. вызов метода в начале onCreate)
        return true;
    }

    //изменить цвет и проверить остался ли он зеленым
    public boolean changeColorBtnGreen(Button btn){

        //делаем рандом
        if(Math.random() < 0.5){
            //если рандом в первой части отрезак (0 до 1), то делаем кнопку красной
            btn.setBackgroundColor(getResources().getColor(R.color.myRed));
            //говорим, что кнопка изменила зеленый цвет
            return false;
        }else {
            //если рандом во второй части промежутка, то оставляеем зеленый
            //(удобно использовать написанный выше метод, устанавливающий зеленый цвет)
            return setGreenBtn(btn);
        }

    }

    //действия по нажатию на кнопку, подаем в параметры ее цвет
    public void clickBtn(boolean isGreen){

        //проверяем цвет
        if (isGreen){
            //увеличиваем баллы
            incScoreAndView();
        }else {
            //уменьшаем баллы
            decScoreAndView();
        }

        //сменяем цвета кнопок, записывая изменения во флаги
        isGreenBtn1 = changeColorBtnGreen(btn1);
        isGreenBtn2 = changeColorBtnGreen(btn2);
        isGreenBtn3 = changeColorBtnGreen(btn3);

    }

}