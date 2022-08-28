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


class ThanksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thanks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val Thank: TextView =view.findViewById(R.id.thanku1)
        val msg: TextView =view.findViewById(R.id.msg)


        var product1:Product?=null               // Product? is the name of the class which has the data class
        val id=arguments?.getInt("ID")      // arguements is the storage where bundle are stored which has the key value pair
        // It can be null may be that key does not exsist like in HashMap in java

        id?.let {
            product1= products.find { it.id==id }
        }


        // now the variable defined above can be null if No product is found with the same id in the mutable list products...
        product1?.let {
            with(it){

               Thank.text="THANK YOU"
               msg.text="Thank you for shopping from our site I hope u like the interface and further continue shopping by clicking on continue Shopping"

                val buy: Button =view.findViewById(R.id.continue1);
                buy.setOnClickListener{
                    val bundle=Bundle()
                    bundle.putInt("ID",this.id)
                    findNavController().navigate(R.id.action_thanksFragment_to_listFragment,bundle)
                }
            }
        }
    }

}