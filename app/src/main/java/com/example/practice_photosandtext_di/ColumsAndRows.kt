package com.example.practice_photosandtext_di

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/*
Ahora crearemos la columa con las filas de cada texto
*/

@Composable
fun LazyColumWithPhotosAndText(){
    //Esta función tiene que estar si creamos un TOAST
    val context = LocalContext.current

    //Creamos una columna para que podamos scrollear
    LazyColumn(
        verticalArrangement = Arrangement.Center
    ){
        items(getPhotoAndText()) { allPhotosAndText -> //Nombre que le damos a los elementos
            //En el item pondremos la acción que queremos realizar
            ItemPhotoAndText(
                /*Determinamos la acción que queremos que haga
                en este caso queremos que muestre el mensaje en el TOAST*/
                photoAndText = allPhotosAndText) {
                Toast.makeText(
                    context, //La variable que hemos creado y va con el toast
                    it.text, //Lo que queremos que muestre cuando clicke el user
                    Toast.LENGTH_SHORT //Que aparezca poco el toast (la animación)
                ).show() //Para mostrarlo
            }
        }
    }
}