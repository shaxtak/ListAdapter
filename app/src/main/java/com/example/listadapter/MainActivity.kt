package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listadapter.adapter.UserAdapter
import com.example.listadapter.databinding.ActivityMainBinding
import com.example.listadapter.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<User>
    private lateinit var userAdapter: UserAdapter
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        userAdapter = UserAdapter()
        binding.rv.adapter = userAdapter

        userAdapter.itemClick = {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }


        loadData()
    }

    private fun loadData() {
        list = ArrayList()
        for (i in 0.. 100){
            list.add(User("Avengers", "$i$i$i",   "yaqinda", R.drawable.avengers1))
        }
        userAdapter.submitList(list)
    }
}