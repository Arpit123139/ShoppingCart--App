package com.example.fragmentnavigational

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


val products= mutableListOf<Product>(Product(1, "Pixel 3a", 45000F, R.drawable.phone,
    "Meet Pixel 3a. Premium. For less.",
    "Save your photos and videos with free, unlimited storage in high quality with Google Photos."),
    Product(2, "Google Home", 7000F, R.drawable.google_home,
        "Help is here. Meet Google Home.",
        "Get answers, play songs, tackle your day, enjoy your entertainment and control your smart home with just your voice."),
    Product(3, "Pixel Stand", 6500F, R.drawable.pixel_stand,
        "Fast, wireless charging.",
        "Charge your Pixel wirelessly with Pixel Stand, and do more with your Google Assistant."),
    Product(4, "Chromecast", 3500F, R.drawable.chromecast,
        "Stream from your device to your TV.",
        "Enjoy hundreds of Android or iPhone apps2, and play or pause directly from your phone.")
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}