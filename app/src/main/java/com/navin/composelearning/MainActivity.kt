package com.navin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navin.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(
                        persons
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Greeting(
    persons: List<Person>
) {
    var sections = listOf("A", "B", "C", "D", "E")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
//            itemsIndexed(items = persons) { position, person ->
//                Log.d("TAG", "Position $position")
//                AdapterItem(person)
//            }
            sections.forEach { section ->
                stickyHeader {
                    Text(
                        text = "Section $section",
                        modifier = Modifier.fillMaxWidth()
                            .background(color = Color.LightGray)
                            .padding(all = 12.dp)
                    )
                }
                items(5) {
                    Text(text = "Item $it of section $section")
                }
            }
        }

    }
}

@Composable
fun AdapterItem(person: Person) {
    Row(
        modifier = Modifier.fillMaxWidth().height(104.dp)
            .background(color = Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            text = person.name, color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Column(
            modifier = Modifier.fillMaxHeight().padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = person.age.toString(), color = Color.Black, fontSize = 22.sp)
            Text(text = person.sex, color = Color.Blue, fontSize = 22.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Surface(color = MaterialTheme.colors.background) {
            Greeting(
                persons
            )
        }
    }
}

var persons = listOf<Person>(
    Person("Navin", 34, "M"),
    Person("Varsha", 34, "F"),
    Person("Sanjit", 34, "M"),
    Person("Sarika", 34, "F"),
    Person("Varsha", 34, "F"),
    Person("Sanjit", 34, "M"),
    Person("Navin", 34, "M"),
    Person("Varsha", 34, "F"),
)

data class Person(var name: String, var age: Int, var sex: String)