package com.rick.workclass.ejemplo.com.example.example1.ui.App

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.example1.R


@Composable
fun StockApp(navHostController: NavHostController) {
    Categoria()
}

@Preview(showBackground = true)
@Composable
fun Categoria() {
    barra_ayuda()

    Card(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    )
    {

        Text(
            text = stringResource(R.string.category),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)


        )
        Card(
            modifier = Modifier
                .padding(5.dp)

        ) {
            Compra_categoria()
            anuncio()
            marcas()
            marcas_populares()
            tendencia()

            sneakers_tendencia()
            anuncio()
            marcas()
            marcas_populares()
        }

    }



}

@Composable
fun sneakers() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(100.dp)
                .height(125.dp),
            painter = painterResource(R.drawable.jordan),
            contentDescription = "Sneakers",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Sneakers",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun ropa() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(100.dp)
                .height(125.dp),
            painter = painterResource(R.drawable.ropa),
            contentDescription = "Ropa",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Ropa",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)

        )
    }

}

@Composable
fun calzado() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(100.dp)
                .height(125.dp),
            painter = painterResource(R.drawable.calzado),
            contentDescription = "Calzado",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Calzado",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)

        )
    }

}

@Composable
fun accesorio() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(100.dp)
                .height(125.dp),
            painter = painterResource(R.drawable.accesorio),
            contentDescription = "Accesorios",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Accesorios",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)

        )
    }

}
@Composable
fun Compra_categoria(){
    Row(
        modifier = Modifier
            .height(175.dp)
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        sneakers()
        ropa()
        calzado()
        accesorio()
    }
}

@Composable
fun anuncio() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        painter = painterResource(R.drawable.anuncio),
        contentDescription = "Sneakers",
        contentScale = ContentScale.Fit
    )
}

@Composable
fun marcas() {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.brand),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(10.dp)

        )
        Text(
            text = "See All Brands",
            fontSize = 15.sp,
            color = colorResource(R.color.green_text),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            Icons.Filled.ArrowForward,
            contentDescription = "Arrow Icon",
            tint = colorResource(R.color.green_text),

            modifier = Modifier
                .size(40.dp, 28.dp)
                .align(Alignment.CenterVertically)
        )

    }
}

@Composable
fun tendencia() {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.trend),
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Ver todo",
            fontSize = 15.sp,
            color = colorResource(R.color.green_text),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            Icons.Filled.ArrowForward,
            contentDescription = "Arrow Icon",
            tint = colorResource(R.color.green_text),
            modifier = Modifier
                .size(40.dp, 28.dp)
                .align(Alignment.CenterVertically)
        )

    }
}

@Composable
fun marcas_populares() {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(160.dp)
                    .height(125.dp),
                painter = painterResource(R.drawable.jordan2),
                contentDescription = "Marca jordan",
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(160.dp)
                    .height(125.dp),
                painter = painterResource(R.drawable.supreme),
                contentDescription = "Marca Supreme",
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(160.dp)
                    .height(125.dp),
                painter = painterResource(R.drawable.louis),
                contentDescription = "Marca louis",
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun jordan_5() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .width(120.dp)

    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(150.dp)
                .height(120.dp),
            painter = painterResource(R.drawable.jordan5),
            contentDescription = "Sneakers",
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(R.string.jordan5),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(3.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.oferta),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "$6,780",
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
    }

}

@Composable
fun jordan() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .width(120.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(150.dp)
                .height(120.dp),
            painter = painterResource(R.drawable.jordan),
            contentDescription = "Sneakers",
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(R.string.jordan),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(3.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(R.string.oferta),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "$6,760",
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
    }


}

@Composable
fun kobe() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .width(140.dp)
    ) {
        Image(
            modifier = Modifier
                .background(Color.White)
                .width(150.dp)
                .height(120.dp),
            painter = painterResource(R.drawable.kobe),
            contentDescription = "Sneakers",
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(R.string.kobe),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(3.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(R.string.oferta),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "$6,740",
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.Start)
        )
    }


}
@Composable
fun sneakers_tendencia(){
    Row(
        modifier = Modifier
            .height(214.dp)
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        jordan_5()
        jordan()
        kobe()
    }
}

@Composable
fun barra_ayuda() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(50.dp),
            Arrangement.SpaceEvenly

        ) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "Search",
                tint = colorResource(R.color.Icon_color),
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .align(Alignment.CenterVertically)
            )

            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                tint = colorResource(R.color.Icon_color),
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                Icons.Filled.FavoriteBorder,
                contentDescription = "Arrow Icon",
                tint = colorResource(R.color.Icon_color),
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                Icons.Filled.Notifications,
                contentDescription = "Arrow Icon",
                tint = colorResource(R.color.Icon_color),
                modifier = Modifier
                    .size(30.dp, 40.dp)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                Icons.Filled.Person,
                contentDescription = "Arrow Icon",
                tint = colorResource(R.color.Icon_color),
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .align(Alignment.CenterVertically)

            )

        }
    }
}