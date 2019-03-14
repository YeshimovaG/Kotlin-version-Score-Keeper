package com.example.android.scorekeeperkotlinvers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView


/** при нажатии кнопки win должно прибавиться 3 очка, при нажатии кнопки draw прибавляется 1,
 *при нажатии кнопки foul прибавляется 1 балл отдельно к счетчику fouls*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        /***global variables?? если разделить onCreate от остального кода (как например в джаве),
         * то глобальные переменные не "используются", поэтому у меня всё в одной куче*/

        var scoreTeamA = 0

        var scoreTeamB = 0

        var foulsTeamA = 0

        var foulsTeamB = 0


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /** пробовала toString(score) - выдает ошибку.  вообще не уверена, может структура кода неверная?*/
        fun displayForTeamA(score: Int) {
            var scoreView = findViewById<TextView>(R.id.team_a_score)
            scoreView.toString()
        }

        fun displayForTeamB(score: Int) {
            var scoreView = findViewById<TextView>(R.id.team_b_score)
            scoreView.toString()
        }

        fun displayFoulsForTeamA(score: Int) {
            val scoreView = findViewById<View>(R.id.team_a_fouls) as TextView
            scoreView.toString()
        }

        fun displayFoulsForTeamB(score: Int) {
            val scoreView = findViewById<View>(R.id.team_b_fouls) as TextView
            scoreView.toString()
        }

        /**изначально мои кнопки в джаве были привязаны через xml-овский onClick, прочитала
         *что в котлине такое не работает (только с плагинами), переделала, кажется всё непрвильно :)*/

        //**Adds 3 points to Team A.*/

        fun addThreeToTeamA() = findViewById<Button>(R.id.addThreeToTeamA_button)
        addThreeToTeamA().setOnClickListener {
            scoreTeamA += 3
            displayForTeamA(scoreTeamA)
        }

        //**Adds 3 points to Team B.*/

        fun addThreeToTeamB() = findViewById<Button>(R.id.addThreeToTeamB_button)
        addThreeToTeamB().setOnClickListener {
            scoreTeamB += 3
            displayForTeamB(scoreTeamB)
        }

        //**Adds 1 point to Team A.*/

        fun addOneToTeamA() = findViewById<Button>(R.id.addOneToTeamA_button)
        addOneToTeamA().setOnClickListener {
            scoreTeamA += 1
            displayForTeamA(scoreTeamA)
        }

        //**Adds 1 foul to Team A.*/
        fun foulOneToTeamA() = findViewById<Button>(R.id.foulOneToTeamA_button)
        foulOneToTeamA().setOnClickListener {
            foulsTeamA += 1
            displayFoulsForTeamA(foulsTeamA)
        }

        //**Adds 1 point to Team B.*/
        fun addOneToTeamB() = findViewById<Button>(R.id.addOneToTeamB)
        addOneToTeamB().setOnClickListener {
            scoreTeamB += 1
            displayForTeamB(scoreTeamB)
        }

        //**Adds 1 foul to Team B.*/
        fun foulOneToTeamB() = findViewById<Button>(R.id.addFoulOneToTeamB)
        foulOneToTeamB().setOnClickListener {
            foulsTeamB += 1
            displayFoulsForTeamB(foulsTeamB)
        }

        fun resetScore() = findViewById<Button>(R.id.resetScore_button)
        resetScore().setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            foulsTeamA = 0
            foulsTeamB = 0
            displayForTeamA(scoreTeamA)
            displayForTeamB(scoreTeamB)
            displayFoulsForTeamA(foulsTeamA)
            displayFoulsForTeamB(foulsTeamB)
        }
    }
}
