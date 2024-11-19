package com.pedroluislinero.examenkotlin.Ejercicio1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.random.Random

/* Ejercicio 1: Lista de Videojuegos
Objetivo: Crear una pantalla que muestre una lista de videojuegos, cada uno con una imagen,
un nombre y un precio.
Pasos:

1. Define una data class con name, price y imageUrl.
2. Usa LazyColumn para mostrar la lista de productos.
3. Cada elemento de la lista debe mostrar una AsyncImage, un Text para el nombre de
mayor tamaño y otro Text para el precio.
4. La imagen de cada uno se obtendrá de
https://loremflickr.com/400/400/seville?lock=1, cambiando el número para que sean
distintas. */

data class Juego(
    val name: String,
    val price: Double,
    val imageUrl: String
)


val listaJuegos = List(100) { i ->
    val precio = Random.nextDouble(1.0, 100.0)
    Juego("Juego $i", precio, "https://loremflickr.com/400/400/seville?lock=$i")
}

@Composable
fun Ejercicio1(juegos: List<Juego>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(juegos) { juego ->
            ProductoItem(juego)
        }
    }
}

@Composable
fun ProductoItem(juego: Juego) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = juego.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = juego.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "$${juego.price}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}