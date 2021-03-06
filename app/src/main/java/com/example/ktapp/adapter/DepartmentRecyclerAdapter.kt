package com.example.ktapp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktapp.R
import com.example.ktapp.model.Department
import com.example.ktapp.view.EquipmentsActivity
import kotlinx.android.synthetic.main.department_card.view.*
import org.w3c.dom.Text


class DepartmentRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Department> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DepartmentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.department_card, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DepartmentViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    class DepartmentViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val description: TextView = itemView.view_description
        val id: TextView = itemView.id_department

        init{
            itemView.setOnClickListener {
                val departmentId = this.itemView.id_department.text.toString()
                val intent = Intent(itemView.context, EquipmentsActivity::class.java)
                intent.putExtra("depId", departmentId)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(department: Department){
            id.text = department.id.toString()
            description.text = department.description
        }
    }

    fun submitList(departments: List<Department>){
        items = departments
    }

    interface OnCardViewListener{
        fun onCardViewClicked(position: Int)
    }

}