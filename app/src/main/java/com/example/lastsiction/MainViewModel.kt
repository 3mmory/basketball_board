package com.example.lastsiction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var team1ScoreValue = 0
    private var team2ScoreValue = 0

    private val _team1Score = MutableLiveData(team1ScoreValue)
    val team1Score: LiveData<Int> get() = _team1Score

    private val _team2Score = MutableLiveData(team2ScoreValue)
    val team2Score: LiveData<Int> get() = _team2Score

    private val _resultMessage = MutableLiveData<String>()
    val resultMessage: LiveData<String> get() = _resultMessage

    fun increaseTeam1Score() {
        team1ScoreValue += 1
        _team1Score.value = team1ScoreValue
    }

    fun increaseTeam2Score() {
        team2ScoreValue += 1
        _team2Score.value = team2ScoreValue
    }

    fun showResult() {
        _resultMessage.value = when {
            team1ScoreValue > team2ScoreValue -> "Team 1 wins!"
            team2ScoreValue > team1ScoreValue -> "Team 2 wins!"
            else -> "It's a tie!"
        }
    }
}
