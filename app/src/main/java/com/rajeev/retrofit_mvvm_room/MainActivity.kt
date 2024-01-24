package com.rajeev.retrofit_mvvm_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rajeev.retrofit_mvvm_room.api.QuoteService
import com.rajeev.retrofit_mvvm_room.api.RetrofitHelper
import com.rajeev.retrofit_mvvm_room.databinding.ActivityMainBinding
import com.rajeev.retrofit_mvvm_room.repo.QuoteRepo
import com.rajeev.retrofit_mvvm_room.viewModals.MainViewModal
import com.rajeev.retrofit_mvvm_room.viewModals.MainViewModalFactory

class MainActivity : AppCompatActivity() {
    lateinit var txtQuotes: TextView
    lateinit var txtAuthor: TextView
    lateinit var mainViewModal: MainViewModal
    private lateinit var binding: ActivityMainBinding
    private var index = 0
    private lateinit var shareQuote :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = (application as QuoteApplication).quoteRepo

        mainViewModal =
            ViewModelProvider(this, MainViewModalFactory(repository)).get(MainViewModal::class.java)

        getQuotes(index)
    }


    fun getQuotes(index: Int) {
        mainViewModal.quotesLivedata.observe(this, Observer {
            if (index < 0 || index > it.results.size) {
                Toast.makeText(this@MainActivity, "indexOutOfBound", Toast.LENGTH_SHORT).show()
            } else {
                binding.quoteText.text = it.results[index].content
                binding.quoteAuthor.text = it.results[index].author
            }
            shareQuote = it.results[index].content.toString()
        })
    }

    fun onPrevious(view: View) {
        getQuotes(--index)
    }
    fun onNext(view: View){
        getQuotes(++index)
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plan")
        intent.putExtra(Intent.EXTRA_TEXT,shareQuote)
        startActivity(intent)
    }
}