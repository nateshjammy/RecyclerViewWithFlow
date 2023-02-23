package com.android.recyclerviewwithflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewwithflow.adpater.ItemAdapter
import com.android.recyclerviewwithflow.pojo.MyItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val itemAdapter = ItemAdapter(emptyList())




    var items:List<MyItem> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsFlow = flow {
            // Simulate a network request or database query
            delay(1000)
             items = listOf(MyItem("Item 1",""),
                MyItem("Item 2",""), MyItem("Natesh",""))
            emit(items)

        }

        lifecycleScope.launch {

            itemsFlow.collect(){
                items ->
                itemAdapter.updateItems(items)
            }
        }




        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter


    }


}