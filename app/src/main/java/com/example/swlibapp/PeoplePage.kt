package com.example.swlibapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swlibrary.APICall
import com.example.swlibrary.Categories.Person
import com.example.swlibrary.VCallback

class PeoplePage : AppCompatActivity(), RVAdapter.ItemClickListener {
    private lateinit var rvAdapter : RVAdapter
    private var resultsList = arrayListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_page)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        APICall.loadInfo(this, "people/", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                resultsList = result as ArrayList<Person>
                makeRecyclerList(resultsList)
            }
        })
    }

    override fun onItemClick(view: View?, position: Int) {
        val intent = Intent(this, InfoDialog::class.java)
        val bundle = Bundle()
        bundle.putString("type", "person")
        bundle.putParcelable("Data", resultsList[position])
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun makeRecyclerList(people: ArrayList<Person>?){
        Log.d("RESULTS MAIN", people!![0].getPersonName())
        val recyclerView : RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val names = arrayListOf<String>()
        people.forEach {
            names.add(it.getPersonName())
        }
        rvAdapter = RVAdapter(this, names)
        rvAdapter.setClickListener(this)
        recyclerView.adapter = rvAdapter
    }

}