package com.rajit.zomatohomeuiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.zomatohomeuiclone.ui.theme.Purple40
import com.rajit.zomatohomeuiclone.ui.theme.RatingGreen
import com.rajit.zomatohomeuiclone.ui.theme.ZomatoHomeUICloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZomatoHomeUICloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(10.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(Constants.foodItems.size) { position ->
                            FoodItemCard(Constants.foodItems[position])
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodItemCard(foodItem: FoodItem = Constants.foodItems[0]) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column {

            // Banner Section - Food Image, Save Button, Promoted Tv, Offers Slip
            BannerSection(foodItem)

            // Item Details
            ItemDetailsSection(foodItem)
        }
    }
}

@Composable
fun ItemDetailsSection(foodItem: FoodItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // Row 1
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = foodItem.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )

            RatingView(foodItem)

        }

        // Row 2
        Row(modifier = Modifier.fillMaxWidth()) {

            // Cuisine Details
            Text(
                text = foodItem.cuisine.joinToString { it }, // Comma-separated cuisines
                color = Color.DarkGray,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Food Item Price
            Text(
                text = "Rs. ${foodItem.price} for One",
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )

        }

        // Divider
        Divider(color = Color.Gray.copy(0.1f))

        // Environment Friendly Message
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_eco),
                contentDescription = null,
                tint = RatingGreen,
                modifier = Modifier.height(42.dp)
            )

            Text(
                text = "Zomato funds environmental projects to offset the delivery carbon footprint",
                style = TextStyle(color = Color.DarkGray, fontSize = 12.sp),
                modifier = Modifier.weight(1f)
            )

            Icon(
                painterResource(id = R.drawable.ic_trending),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .height(24.dp)
                    .background(color = Purple40, shape = CircleShape)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun RatingView(foodItem: FoodItem) {
    Row(
        modifier = Modifier
            .background(color = RatingGreen, shape = RoundedCornerShape(4.dp))
            .padding(vertical = 4.dp, horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${foodItem.rating} ",
            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
        )

        Icon(
            painterResource(id = R.drawable.ic_star),
            contentDescription = "Star Icon",
            tint = Color.White,
            modifier = Modifier.height(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerSection(foodItem: FoodItem = Constants.foodItems[0]) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = foodItem.imgDrawable),
            contentDescription = "${foodItem.name} Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.FillBounds
        )

        // Promoted Tag - if Food Item is up for Promotion
        if (foodItem.isPromoted) {
            Text(
                "Promoted",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.DarkGray.copy(0.6f), shape = RoundedCornerShape(4.dp))
                    .padding(vertical = 4.dp, horizontal = 6.dp)
                    .align(Alignment.TopStart)
            )
        }

        // Save To Favourites Button
        Icon(
            painter = painterResource(id = R.drawable.ic_bookmark),
            contentDescription = "Save to Favourites Button",
            modifier = Modifier
                .padding(paddingValues = PaddingValues(top = 10.dp, end = 10.dp))
                .height(32.dp)
                .background(color = Color.White, shape = CircleShape)
                .padding(4.dp)
                .align(Alignment.TopEnd),
            tint = Color.Black
        )

        // Offer Strip - 60% off Upto Rs. 120
        Row(
            modifier = Modifier
                .padding(bottom = 18.dp)
                .background(
                    color = Color.Blue.copy(0.9f),
                    shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)
                )
                .padding(6.dp)
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Discount Icon
            Icon(
                painter = painterResource(id = R.drawable.ic_disc),
                contentDescription = "Discount Icon",
                tint = Color.White,
                modifier = Modifier.height(16.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            val offerTxt = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White)) {
                    append("60% Off\n")
                }
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color.White)) {
                    append("UpTo Rs. 120")
                }
            }

            Text(offerTxt)

        }

        // Delivery Time
        Text(
            text = "${foodItem.deliveryTime} Min",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            ),
            modifier = Modifier
                .padding(end = 10.dp, bottom = 18.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

