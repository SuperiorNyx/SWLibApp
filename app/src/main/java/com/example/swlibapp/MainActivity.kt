package com.example.swlibapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
    }

    fun loadPeople(view: View) {
        val intent = Intent(this, PeoplePage::class.java)
        startActivity(intent)
    }
    fun loadFilms(view: View) {
        val intent = Intent(this, FilmPage::class.java)
        startActivity(intent)
    }

    fun loadPlanets(view: View) {
        val intent = Intent(this, PlanetPage::class.java)
        startActivity(intent)
    }

    fun loadSpecies(view: View) {
        val intent = Intent(this, SpeciesPage::class.java)
        startActivity(intent)
    }

    fun loadStarships(view: View) {
        val intent = Intent(this, StarshipPage::class.java)
        startActivity(intent)
    }

    fun loadVehicles(view: View) {
        val intent = Intent(this, VehiclePage::class.java)
        startActivity(intent)
    }
}