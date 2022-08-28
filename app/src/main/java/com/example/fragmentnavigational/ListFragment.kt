package com.example.fragmentnavigational

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList=view.findViewById<RecyclerView>(R.id.product_list).apply {

            layoutManager=LinearLayoutManager(activity)

            adapter=ProductAdapter{

                val bundle=Bundle()                // bundle is used to send data from one fragment to another fragment
                bundle.putInt("ID",it.id)
                findNavController().navigate(R.id.detail,bundle)

            }
            setHasFixedSize(true)
        }
        (productList.adapter as ProductAdapter).submitList(products)


    }

}