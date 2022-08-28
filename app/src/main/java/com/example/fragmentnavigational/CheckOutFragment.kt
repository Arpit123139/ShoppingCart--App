package com.example.fragmentnavigational

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController





//                             THIS IS WITHOUTH VIEW MODEL

//override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//    super.onViewCreated(view, savedInstanceState)
//
//    val ProductImage: ImageView =view.findViewById(R.id.image)
//    val ProductName: TextView =view.findViewById(R.id.name)
//    val ProductPrize: TextView =view.findViewById(R.id.Prize)
//    val Total: TextView =view.findViewById(R.id.Total)
//    val ProductDescription1: TextView =view.findViewById(R.id.Description)
//    val ShoppingCart:TextView=view.findViewById(R.id.shoppingcart)
//
//    var product1:Product?=null               // Product? is the name of the class which has the data class
//    val id=arguments?.getInt("ID")      // arguements is the storage where bundle are stored which has the key value pair
//    // It can be null may be that key does not exsist like in HashMap in java
//
//    id?.let {
//        product1= products.find { it.id==id }
//    }
//
//
//    // now the variable defined above can be null if No product is found with the same id in the mutable list products...
//    product1?.let {
//        with(it){
//
//            ProductImage.setImageResource(ImageId)
//            ProductName.text=name
//            ProductPrize.text="Price: Rs ${this.prize} "
//            Total.text="Order Total : ${prize}"
//            ShoppingCart.text="Shopping Cart"
//            ProductDescription1.text=shortDescription
//
//            val buy: Button =view.findViewById(R.id.checkOut1);
//            buy.setOnClickListener{
//                val bundle=Bundle()
//                bundle.putInt("ID",this.id)
//                findNavController().navigate(R.id.action_checkOutFragment_to_thanksFragment,bundle)
//            }
//        }
//    }
//}

                                      //  WITH VIEW MODEL TWO EXTRA CLASS ARE CREATED
class CheckOutFragment : Fragment() {
    private lateinit var viewModel:CheckOutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_out, container, false)
    }
    //private var quantity=1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ProductImage: ImageView =view.findViewById(R.id.image)
        val ProductName: TextView =view.findViewById(R.id.name)
        val ProductPrize: TextView =view.findViewById(R.id.Prize)
        val Total: TextView =view.findViewById(R.id.Total)
        val ProductDescription1: TextView =view.findViewById(R.id.Description)
        val ShoppingCart:TextView=view.findViewById(R.id.shoppingcart)
        val qt:TextView=view.findViewById(R.id.textView)


        val id=arguments?.getInt("ID")      // arguements is the storage where bundle are stored which has the key value pair


        val viewModelFactory=CheckOutViewModelFactory(id,1)         // WE need a View Model factory only when we pass a Arguement in the view Model
        viewModel=ViewModelProvider(this,viewModelFactory).get(CheckOutViewModel::class.java)

        setData(viewModel.product,ProductImage,ProductName,ProductPrize,ProductDescription1,Total,ShoppingCart,qt)

        val increase=view.findViewById<Button>(R.id.increase)
        increase.setOnClickListener{
            viewModel.addQty(1)
            qt.text="Quantity : ${viewModel.qty}"
        }

        val decrease=view.findViewById<Button>(R.id.decrease)
        decrease.setOnClickListener{
            viewModel.reduceQty(1)
            qt.text="Quantity : ${viewModel.qty}"
        }

        val buy: Button =view.findViewById(R.id.checkOut1);
        buy.setOnClickListener{
            val bundle=Bundle()
            viewModel.product?.let { it1 -> bundle.putInt("ID", it1.id) }
            findNavController().navigate(R.id.action_checkOutFragment_to_thanksFragment,bundle)
        }

    }

    private fun setData(product: Product?, ProductImage: ImageView, ProductName: TextView, ProductPrize: TextView, ProductDescription1: TextView, Total: TextView, ShoppingCart: TextView, qt: TextView) {

        product?.run {

            ProductImage.setImageResource(ImageId)
            ProductName.text=name
            ProductPrize.text="Price: Rs ${this.prize} "
            Total.text="Order Total : ${prize}"
            ShoppingCart.text="Shopping Cart"
            ProductDescription1.text=shortDescription
            qt.text="Quantity : ${viewModel.qty}"
        }



    }


}