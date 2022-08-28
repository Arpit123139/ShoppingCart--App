package com.example.fragmentnavigational

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val listener: (Product) -> Unit): ListAdapter<Product, ProductAdapter.ProductViewHolder>(DiffCallback()) {

    inner class ProductViewHolder(view : View): RecyclerView.ViewHolder(view)     // It inherits from RecyclerView.viewHolder()
    {// the view mentioned above is the inflated view
        val ProductImage: ImageView =view.findViewById(R.id.image)
        val ProductName: TextView =view.findViewById(R.id.name)
        val ProductPrize: TextView =view.findViewById(R.id.Prize)
        val ProductDescription:TextView=view.findViewById(R.id.Description)

        init {
            itemView.setOnClickListener{
                listener.invoke(getItem(adapterPosition))               // the .invoke ProductAdapter{} in MainActivity
            }
        }

        fun bind(countryData:Product) {
            // this method is invoked when the views are recycled and only data is changed...................
            with(countryData)
            {
                ProductImage.setImageResource(ImageId)
                ProductName.text=name                              // Here we do not have parameter position so we directly iterate
                ProductPrize.text="Prize: Rs ${prize}"                       // through ProductData.................................
                ProductDescription.text=shortDescription
            }
        }

    }


    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        // this is a function which is intially called when itially the views are established according to the scrren size
        val itemLayout=
            LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return ProductViewHolder(itemLayout)
    }

    override  fun onBindViewHolder( holder: ProductViewHolder,position: Int)
    {
        holder.bind(getItem(position))
    }


}

class DiffCallback : DiffUtil.ItemCallback<Product>()
{
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem==newItem
    }
}