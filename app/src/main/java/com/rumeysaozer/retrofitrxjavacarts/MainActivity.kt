package com.rumeysaozer.retrofitrxjavacarts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rumeysaozer.retrofitrxjavacarts.model.Todos
import com.rumeysaozer.retrofitrxjavacarts.service.TodoAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val todoAPIService = TodoAPIService()
    private val disposable = CompositeDisposable()
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataFromAPI()
    }
    fun getDataFromAPI(){
        disposable.add(
            todoAPIService.getDatas()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Todos>(){

                    override fun onSuccess(t: Todos) {
                        findViewById<TextView>(R.id.limit).text =   t.limit.toString()
                        findViewById<TextView>(R.id.skip).text = t.skip.toString()
                        findViewById<TextView>(R.id.total).text = t.total.toString()
                        val myStringBuilder = StringBuilder()
                        for (data in t.todos){
                           myStringBuilder.append(data.todo)
                            myStringBuilder.append("\n")
                            myStringBuilder.append(data.id)
                            myStringBuilder.append("\n")
                            myStringBuilder.append(data.userId)
                            myStringBuilder.append("\n")
                            myStringBuilder.append(data.completed)
                        }
                        findViewById<TextView>(R.id.todo).text = myStringBuilder
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }
}