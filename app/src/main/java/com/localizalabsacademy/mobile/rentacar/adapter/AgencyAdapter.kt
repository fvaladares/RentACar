package com.localizalabsacademy.mobile.rentacar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.model.Agency
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel
import com.localizalabsacademy.mobile.rentacar.ui.SelectAgencyFragment


class AgencyAdapter(
    private val items: List<Agency>,
    private val context: Context,
    private val viewModel: RentViewModel,
    private val view: SelectAgencyFragment,
) : RecyclerView.Adapter<AgencyAdapter.AgencyAdapterViewHolder>() {


    class AgencyAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: MaterialTextView = view.findViewById(R.id.agency_tv_name)
        val textViewPhone: MaterialTextView = view.findViewById(R.id.agency_tv_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgencyAdapterViewHolder {
        val adapterLayoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.agency_item_list, parent, false)
        return AgencyAdapterViewHolder(adapterLayoutInflater)
    }

    override fun onBindViewHolder(holder: AgencyAdapterViewHolder, position: Int) {
        val item = items[position]
        holder.textViewName.text = item.name
        holder.textViewPhone.text = item.phone
    }

    override fun getItemCount(): Int = items.size
}


//
//class AgencyAdapter(private val items: ArrayList<Agency>) :
//    RecyclerView.Adapter<AgencyAdapter.ViewHolder>() {
//
//    class ViewHolder: RecyclerView.ViewHolder(val binding: Agenc) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgencyAdapter.ViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: AgencyAdapter.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//}
//
