package com.example.swlibapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.APICall
import com.example.swlibrary.Categories.Film
import com.example.swlibrary.VCallback

class FilmPage : AppCompatActivity(), RVAdapter.ItemClickListener {
    private lateinit var rvAdapter : RVAdapter
    private var resultsList = arrayListOf<Film>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        APICall.loadInfo(this, "films", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                resultsList = result as ArrayList<Film>
                makeRecyclerList(resultsList)
            }
        })
    }

    override fun onItemClick(view: View?, position: Int) {
        val intent = Intent(this, InfoDialog::class.java)
        val bundle = Bundle()
        bundle.putString("type", "film")
        bundle.putParcelable("Data", resultsList[position])
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun makeRecyclerList(films: ArrayList<Film>?){
        val recyclerView : RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val names = arrayListOf<String>()
        films!!.forEach {
            names.add(it.getFilmTitle())
        }
        rvAdapter = RVAdapter(this, names)
        rvAdapter.setClickListener(this)
        recyclerView.adapter = rvAdapter
    }
}