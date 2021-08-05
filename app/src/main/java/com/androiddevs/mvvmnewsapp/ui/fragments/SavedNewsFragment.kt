package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.adapters.NewsAdapter
import com.androiddevs.mvvmnewsapp.databinding.FragmentBreakingNewsBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentSavedNewsBinding
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    private lateinit var binding: FragmentSavedNewsBinding
    val viewModel: NewsViewModel by viewModels()
    lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            val bundle=Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )

        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(binding.root.context)
        }
    }


}