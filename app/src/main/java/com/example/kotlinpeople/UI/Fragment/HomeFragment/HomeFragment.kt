package com.example.kotlinpeople.ui.fragment.HomeFragment

import Coroutines
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpeople.R
import com.example.kotlinpeople.other.QuoteItem
import com.example.kotlinpeople.other.QuotesResponse
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import hide
import kotlinx.android.synthetic.main.home_fragment_layout.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import show


class HomeFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: HomeViewModelFactory by instance()

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = Coroutines.main {
        progress_bar.show()
        viewModel.quotes.await().observe(this, Observer {
            progress_bar.hide()
            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(quoteItem: List<QuoteItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(quoteItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }


    private fun List<QuotesResponse>.toQuoteItem(): List<QuoteItem> {
        return this.map {
            QuoteItem(it)
        }
    }

}