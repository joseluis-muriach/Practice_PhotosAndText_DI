package com.example.practice_photosandtext_di

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Data class con foto y el texto
data class PhotoText(
    @DrawableRes var photos: Int,
    var text: String,
    var points: String
)

fun getPhotoAndText(): List<PhotoText> {
    return listOf(
        PhotoText(
            R.drawable.images1,
            "María Mata",
            "Puntos: 2014"

        ),
        PhotoText(
            R.drawable.images2,
            "Antonio Sanz",
            "Puntos 2056"
        ),
        PhotoText(
            R.drawable.images3,
            "Carlos Perez",
            "Puntos 5231"
        ),
        PhotoText(
            R.drawable.images4,
            "Bea Martos",
            "Puntos 6218"
        ),
        PhotoText(
            R.drawable.images5,
            "Juan Alcaraz",
            "Puntos 1892"
        ),
        PhotoText(
            R.drawable.images6,
            "Augusto Renato",
            "Puntos 2231"
        ),
        PhotoText(
            R.drawable.images7,
            "Juan Miguel",
            "Puntos 1954"
        ),
        PhotoText(
            R.drawable.images8,
            "Miguel Angel",
            "Puntos 3691"
        ),
    )
}

@Composable
fun ItemPhotoAndText(photoAndText: PhotoText, onItemSelected: (PhotoText) -> Unit) {
    //Creamos la row para la foto y el titulo
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(photoAndText) }, //Ahora la fila es toda clickable
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        //Pasamos ahora la imagen y el texto (que va todo junto)
        Image(
            painter = painterResource(id = photoAndText.photos),
            contentDescription = "",
                contentScale = ContentScale.Inside, //Ajusta dentro del espacio disponible
            modifier = Modifier
                .padding(10.dp)
        )
        //Creamos la columna para añadir el texto y la puntuación
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text( //Texto
                photoAndText.text,
                fontSize = 15.sp,
                modifier = Modifier.padding(5.dp)
            )

            Text( //Puntuación
                photoAndText.points,
                fontSize = 15.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

