package com.example.swlibapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.APICall
import com.example.swlibrary.Categories.Planet
import com.example.swlibrary.VCallback

class PlanetPage : AppCompatActivity(), RVAdapter.ItemClickListener {
    private lateinit var rvAdapter : RVAdapter
    private var resultsList = arrayListOf<Planet>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        APICall.loadInfo(this, "planets", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                resultsList = result as ArrayList<Planet>
                makeRecyclerList(resultsList)
            }
        })
    }

    override fun onItemClick(view: View?, position: Int) {
        val intent = Intent(this, InfoDialog::class.java)
        val bundle = Bundle()
        bundle.putString("type", "planet")
        bundle.putParcelable("Data", resultsList[position])
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun makeRecyclerList(planets: ArrayList<Planet>?){
        val recyclerView : RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val names = arrayListOf<String>()
        planets!!.forEach {
            names.add(it.getPlanetName())
        }
        rvAdapter = RVAdapter(this, names)
        rvAdapter.setClickListener(this)
        recyclerView.adapter = rvAdapter
    }
}