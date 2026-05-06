package com.example.andevformula.s02_layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ConstraintLayoutsExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        val (title, subtitle, button) = createRefs()

        Text(
            text = "AnDev Formula",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, margin = 20.dp)
            }
        )

        Text(
            text = "AnDev Formula is a Full Stack App Development Session by Neat Roots",
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(subtitle) {
                start.linkTo(title.start)
                top.linkTo(title.bottom, margin = 8.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints //Occupy Available Width
            }
        )

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(subtitle.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Click Here")
        }

    }

}