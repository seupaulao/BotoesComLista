package com.pjlaapps.botoescomlista

import android.os.Bundle
import android.widget.ScrollView
import android.widget.Scroller
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pjlaapps.botoescomlista.ui.theme.BotoesComListaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotoesComListaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Telinha(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Telinha(name: String, modifier: Modifier = Modifier) {

    // Estado que guarda a lista atual exibida na LazyColumn
    var listaAtual = remember {
        mutableStateOf<List<String>>(listaB)
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Exemplo de Botões com Lista",
        )
        Row {
            Button(
                onClick = { listaAtual.value = listaA },
                modifier = modifier.padding(8.dp)
            ) {
                Text(text = "Genesis 1")
            }
            Button(
                onClick = { listaAtual.value = listaB},
                modifier = modifier.padding(8.dp)
            ) {
                Text(text = "Levitico 11")
            }
        }


        LazyColumn (
            modifier = modifier
                .padding(8.dp),
            userScrollEnabled = true,

        ){
            // Add 5 items
            items(listaAtual.value) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BotaoComListaPreview() {
    BotoesComListaTheme {
        Telinha("Android")
    }
}