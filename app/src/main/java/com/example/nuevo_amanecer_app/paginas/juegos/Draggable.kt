import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testdraganddrop.ui.theme.TestDragAndDropTheme
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource

@Composable
fun DragableObj(goodState: Int, drawImage: Int, onChangeState: (Int) -> Unit
) {
    var x1 = 0f
    var x2 = 500f
    var x3 = -1*x2

    var margin = x2 - x1 / 2

    var state by remember { mutableStateOf(0) }

    var boxOffsetX by remember { mutableStateOf( 0f) }
    var boxOffsetY by remember { mutableStateOf(0f) }


    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxWidth()
    ){
    // two texts justifyed
    Image(
        painter = painterResource(id = drawImage),
        contentDescription = null,
        modifier = Modifier
            .offset { IntOffset(boxOffsetX.roundToInt(), boxOffsetY.roundToInt()) }
            .size(100.dp)
            .padding(16.dp)
            // if state is equal to goodState border is green
            .border(2.dp, if (state == goodState) Color.Green else Color.Red)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset: Offset ->
                        println("onDragStart")
                        println(offset)/*
                                boxOffsetX = offset.x
                                boxOffsetY = offset.y*/

                    },
                    onDragEnd = {
                        println("onDragEnd")
                        if (boxOffsetX > x1 - margin && boxOffsetX < x1 + margin) {
                            boxOffsetX = x1
                            state = 0
                        } else if (boxOffsetX > x2 - margin) {
                            boxOffsetX = x2
                            state = 1
                        } else if (boxOffsetX < x3 + margin) {
                            boxOffsetX = x3
                            state = -1
                        }
                        onChangeState(state)
                        boxOffsetY = 0f
                    },
                    onDragCancel = {
                        println("onDragCancel")
                        if (boxOffsetX > x1 - margin && boxOffsetX < x1 + margin) {
                            boxOffsetX = x1
                            state = 0
                        } else if (boxOffsetX > x2 - margin) {
                            boxOffsetX = x2
                            state = 1
                        } else if (boxOffsetX < x3 + margin) {
                            boxOffsetX = x3
                            state = -1
                        }
                        onChangeState(state)
                        boxOffsetY = 0f
                    },
                    onDrag = { change, dragAmount ->
                        println("onDrag")
                        println(change)
                        println(dragAmount)
                        change.consume()
                        boxOffsetX += dragAmount.x
                        boxOffsetY += dragAmount.y
                    }
                )
            }
    )}
}

@Preview(showBackground = true, device = "id:Nexus 10")
@Composable
fun GamePrev() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Center
    ) {
        var listOfImages by remember { mutableStateOf(
            listOf<Int>(R.drawable.avion, R.drawable.avion, R.drawable.avion))
        }
        var listOfGoodStates by remember { mutableStateOf(
            listOf<Int>(1, -1, 1)
        ) }

        var listOfStates by remember { mutableStateOf(listOf<Int>(0, 0, 0)) }

        var posImages = listOf<Pair<Int, Int>>(
            Pair(R.drawable.avion, 1),
            Pair(R.drawable.carro, 1),
            Pair(R.drawable.leon, -1),
            Pair(R.drawable.perro, -1)
        )

        var shuffledImages = posImages.shuffled()
        for (i in listOfImages.indices) {
            listOfImages = listOfImages.toMutableList().also { it[i] = shuffledImages[i].first }
            listOfGoodStates = listOfGoodStates.toMutableList().also { it[i] = shuffledImages[i].second }
        }

        var isAllGood by remember { mutableStateOf(false) }

        fun changeState(index: Int, state: Int) {
            listOfStates = listOfStates.toMutableList().also { it[index] = state }
            for (i in listOfStates.indices) {
                if (listOfStates[i] != listOfGoodStates[i]) {
                    return
                }
            }


            var shuffledImages = posImages.shuffled()
            for (i in listOfImages.indices) {
                listOfImages = listOfImages.toMutableList().also { it[i] = shuffledImages[i].first }
                listOfGoodStates = listOfGoodStates.toMutableList().also { it[i] = shuffledImages[i].second }
            }
            isAllGood = true
            //GamePrev()
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
            , horizontalAlignment = Alignment.CenterHorizontally){
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            )
            {
                Text(text = "Vivo")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "No Vivo")
            }
            LazyColumn(content = {
                itemsIndexed(listOfImages) {
                        index, item ->
                    DragableObj(listOfGoodStates[index], item, { state -> changeState(index, state) })

                }
            }, modifier = Modifier.fillMaxSize() )
        }

    }
}
