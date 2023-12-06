package com.example.login.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Interview(
  navController: NavController,
) {


  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Home") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer
        )
      )
    },
    content = { innerPadding ->
      Column(
        modifier = Modifier
          .padding(innerPadding)
          .padding(horizontal = 16.dp)
          .padding(top = 16.dp)
          .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Column() {
          Text(
            "Interview:",
            style = MaterialTheme.typography.displayMedium,
          )
          }
        Button(
          onClick = { },
        ) {
          Text (
            text = "Start Interview",
            style = MaterialTheme.typography.bodyLarge
          )
          Spacer(modifier = Modifier.width(5.dp).fillMaxWidth().padding(10.dp))
          Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
          )
        }
        }



    }
  )
}
