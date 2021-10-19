package com.example.picsumphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.picsumphotos.adapters.ListPagingAdapter
import com.example.picsumphotos.databinding.ActivityMainBinding
import com.example.picsumphotos.models.ListDataItem
import com.example.picsumphotos.retrofit.ApiClient
import com.example.picsumphotos.room.AppDatabase
import com.example.picsumphotos.viewmodels.ListViewModel
import com.example.picsumphotos.viewmodels.ViewModelsFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDatabase: AppDatabase
    private val listPagingAdapter by lazy { ListPagingAdapter() }
    private lateinit var listViewModel: ListViewModel
    private lateinit var listDataItem: ListDataItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)

        listViewModel = ViewModelProviders.of(
            this,
            ViewModelsFactory(ApiClient.apiService)
        )[ListViewModel::class.java]

        lifecycleScope.launch {
            listViewModel.list.collectLatest {
                listPagingAdapter.submitData(it)
            }
        }
        binding.rv.adapter = listPagingAdapter


    }
}