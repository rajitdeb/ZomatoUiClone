package com.rajit.zomatohomeuiclone

object Constants {

    val foodItems = listOf<FoodItem>(
        FoodItem(
            name = "Zhalzhala Burger",
            price = 220,
            imgDrawable = R.drawable.burger,
            isPromoted = true,
            cuisine = listOf(
                "Biryani",
                "Burger"
            ),
            rating = 4.2f,
            deliveryTime = 30
        ),

        FoodItem(
            name = "Raapchik Pizza",
            price = 370,
            imgDrawable = R.drawable.pizza,
            isPromoted = false,
            cuisine = listOf(
                "Pizza"
            ),
            rating = 4.7f,
            deliveryTime = 35
        ),

        FoodItem(
            name = "Pav Bhaaji",
            price = 90,
            imgDrawable = R.drawable.pav_bhaji,
            isPromoted = true,
            cuisine = listOf(
                "Biryani",
                "Misal"
            ),
            rating = 4.8f,
            deliveryTime = 15
        ),

        FoodItem(
            name = "Misal Pav",
            price = 180,
            imgDrawable = R.drawable.misal_pav,
            isPromoted = false,
            cuisine = listOf(
                "North Indian",
                "South Indian"
            ),
            rating = 3.9f,
            deliveryTime = 40
        ),

        FoodItem(
            name = "Sev Tamaatar Nu Saak",
            price = 350,
            imgDrawable = R.drawable.sev_tamatar_shaak,
            isPromoted = false,
            cuisine = listOf(
                "Gujarati"
            ),
            rating = 4.0f,
            deliveryTime = 60
        ),

        FoodItem(
            name = "Khandvi",
            price = 210,
            imgDrawable = R.drawable.khandvi,
            isPromoted = false,
            cuisine = listOf(
                "Gujarati"
            ),
            rating = 4.0f,
            deliveryTime = 20
        ),

        FoodItem(
            name = "Handvo",
            price = 250,
            imgDrawable = R.drawable.handvo,
            isPromoted = false,
            cuisine = listOf(
                "Gujarati"
            ),
            rating = 4.3f,
            deliveryTime = 40
        ),

        FoodItem(
            name = "Batata Vada",
            price = 120,
            imgDrawable = R.drawable.batata_vada,
            isPromoted = false,
            cuisine = listOf(
                "Marathi"
            ),
            rating = 4.0f,
            deliveryTime = 60
        )
    )

}