package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.adapters.CycleAdapter
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.SortType
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_statistics.*


@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var cycleAdapter: CycleAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        when(viewModel.sortType) {
            SortType.DATE -> spFilter.setSelection(0)
            SortType.DISTANCE -> spFilter.setSelection(1)
        }

        viewModel.cycles.observe(viewLifecycleOwner, Observer {
            cycleAdapter.submitList(it)
        })

        spFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    0 -> viewModel.sortCycles(SortType.DATE)
                    1 -> viewModel.sortCycles(SortType.DISTANCE)
                }
            }
        }

    }

    private fun setupRecyclerView() = rvRuns.apply {
        cycleAdapter = CycleAdapter()
        adapter = cycleAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}