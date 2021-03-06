package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.adapter.AgencyAdapter
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectAgencyBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel


class SelectAgencyFragment : Fragment() {

    private lateinit var agencyAdapter: AgencyAdapter
    private var binding: FragmentSelectAgencyBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    //    private val sharedViewModel: RentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d(TAG, "onCreateView()")
        val fragmentBinding = FragmentSelectAgencyBinding.inflate(
            inflater,
            container,
            false
        )

        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")

        val layoutManager = LinearLayoutManager(context)


        agencyAdapter = AgencyAdapter(
            mutableListOf(),
            requireParentFragment().requireContext(),
            sharedViewModel,
            this@SelectAgencyFragment
        )

        binding?.apply {
            selectAgencyFragment = this@SelectAgencyFragment
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            selectAgencyRv.apply {
                adapter = agencyAdapter
                this.layoutManager = layoutManager
                setHasFixedSize(true)
            }


        }
    }


    /**
     * Navigate back to [StartFragment]
     */
    fun returnToStartFragment() {
        sharedViewModel.setLocation(binding!!.selectAgencyEtAgencyName.text.toString())
        Toast.makeText(context, "Botao acionado", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_selectAgencyFragment_to_startFragment)
    }

    fun getAgencies() {
        Log.w("RENT_SelectAgencyF", "getAgencies(): -> Starting")
        sharedViewModel.searchAgenciesWS()




        sharedViewModel.agencies.observe(viewLifecycleOwner, Observer { agencies ->
            agencies?.let {
                agencyAdapter.update(it)
                Log.d("RECYCLER building", it.toString())
            }
        })


        Log.w("RENT_SelectAgencyF", "getAgencies(): -> finishing")
    }


    companion object {
        const val TAG = "RENTSelectAgency"
    }
}

