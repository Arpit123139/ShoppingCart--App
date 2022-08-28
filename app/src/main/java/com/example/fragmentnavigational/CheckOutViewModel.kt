package com.example.fragmentnavigational

import androidx.lifecycle.ViewModel

class CheckOutViewModel(id:Int,initialQuantity:Int):ViewModel() {
    val product:Product?= products.find{id==it.id}

    private var _qty=initialQuantity

    val qty:Int                     // We have set the getter to get the quantity and it cannot be accessed by the outside class
        get()=_qty

    fun addQty(qty:Int){
        _qty+=qty
    }
    fun reduceQty(qty:Int){
        if((_qty-qty)>0){
            _qty-=qty
        }
    }
}