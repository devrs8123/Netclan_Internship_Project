package com.example.netclaninternshipproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.netclaninternshipproject.ui.theme.NetclanInternshipProjectTheme
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.netclaninternshipproject.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Example products for different menus
        val productsMenu1 = listOf("Product A", "Product B", "Product C")
        val productsMenu2 = listOf("Product X", "Product Y", "Product Z")
        val productsMenu3 = listOf("Product 1", "Product 2", "Product 3")

        // Set click listeners for menu buttons
        binding.menu1.setOnClickListener { displayProducts(productsMenu1) }
        binding.menu2.setOnClickListener { displayProducts(productsMenu2) }
        binding.menu3.setOnClickListener { displayProducts(productsMenu3) }

        // Display menu1 products by default
        displayProducts(productsMenu1)

        val myImage = findViewById<ImageView>(R.id.refine_button)

        myImage.setOnClickListener {
            // Start a new activity when the image is clicked
            val intent = Intent(this, RefineActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayProducts(products: List<String>) {
        // Clear existing views in the product container before adding new ones
        binding.container.removeAllViews()

        // Iterate through products list and create CardViews dynamically
        for (product in products) {
            val cardView = createCardView(product)
            binding.container.addView(cardView)
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun createCardView(productName: String): CardView {
        val cardView = CardView(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(16, 16, 16, 16)
        cardView.layoutParams = layoutParams
        cardView.radius = 16F

        val inflater = LayoutInflater.from(this)
        val cardContent = inflater.inflate(R.layout.card_view_content, cardView, false)
        // Assuming you have a TextView inside your card view layout to display product name
        val productNameTextView = cardContent.findViewById<TextView>(R.id.productNameTextView)
        productNameTextView.text = productName

        cardView.addView(cardContent)
        return cardView
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetclanInternshipProjectTheme {
        Greeting("Android")
    }
}