package com.example.fragmentnavigational

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ProductImage: ImageView =view.findViewById(R.id.image)
        val ProductName: TextView =view.findViewById(R.id.name)
        val ProductPrize: TextView =view.findViewById(R.id.Prize)
        val ProductDescription: TextView =view.findViewById(R.id.LongDescription)
        val ProductDescription1: TextView =view.findViewById(R.id.Description)


        var product1:Product?=null               // Product? is the name of the class which has the data class
        val id=arguments?.getInt("ID")      // arguements is the storage where bundle are stored which has the key value pair
        // It can be null may be that key does not exsist like in HashMap in java

        id?.let {
            product1= products.find { it.id==id }
        }


        // now the variable defined above can be null if No product is found with the same id in the mutable list products...
        product1?.let {
            with(it){

                ProductImage.setImageResource(ImageId)
                ProductName.text=name
                ProductPrize.text="Price: Rs ${this.prize} "
                ProductDescription.text=LongDescription
                ProductDescription1.text=shortDescription

                 val buy:Button=view.findViewById(R.id.Buy);
                 buy.setOnClickListener{
                     val bundle=Bundle()
                     bundle.putInt("ID",this.id)
                     findNavController().navigate(R.id.action_detailFragment_to_checkOutFragment,bundle)
                }
            }
        }
    }


}