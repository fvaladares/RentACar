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
    private var items: MutableList<Agency>?,
    private val context: Context,
    private val viewModel: RentViewModel,
    private val view: SelectAgencyFragment,
) : RecyclerView.Adapter<AgencyAdapter.AgencyViewHolder>() {


    fun update(agencies: MutableList<Agency>) {
        if (items == null) {
            items = agencies
        } else if (items != null) {
            items!!.clear()
            items!!.addAll(agencies)
        }

        notifyDataSetChanged()
    }

    class AgencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: MaterialTextView =
            view.findViewById(R.id.agency_tv_name)
        val textViewPhone: MaterialTextView =
            view.findViewById(R.id.agency_tv_phone)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AgencyViewHolder {
        val adapterLayoutInflater = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.list_item_agency,
                parent,
                false
            )
        return AgencyViewHolder(adapterLayoutInflater)
    }

    override fun onBindViewHolder(
        holder: AgencyViewHolder,
        position: Int,
    ) {
        val item = items?.get(position)
        holder.apply {
            if (item != null) {
                textViewName.text = item.name
                textViewPhone.text = item.phone
            }

        }
    }

    override fun getItemCount(): Int = items?.size!!
}
