package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.example1.R
import com.rick.workclass.ejemplo.com.example.example1.data.model.MenuModel
import com.rick.workclass.ejemplo.com.example.example1.data.model.PostCardModel
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.PostCardComponent
import kotlinx.coroutines.launch


@Composable
fun componentsScreen(navController: NavController) {
    val MenuOptions = arrayOf(
        MenuModel(1,"Buttons","Buttons",Icons.Filled.ThumbUp),
        MenuModel(2,"Floating Buttons","Floating Buttons",Icons.Filled.Add),
        MenuModel(3,"Progress","Progress",Icons.Filled.Refresh),
        MenuModel(4,"Chips","Chips",Icons.Filled.AccountBox),
        MenuModel(5,"Sliders","Sliders",Icons.Filled.Star),
        MenuModel(6,"Badges","Badges",Icons.Filled.ShoppingCart),
        MenuModel(7,"Switch","Switch",Icons.Filled.Check),
        MenuModel(8,"SnackeBars","SnackeBars",Icons.Filled.Notifications ),
        MenuModel(9,"AlertDialog","AlertDialog",Icons.Filled.Warning),
        MenuModel(10,"Bars","Bars",Icons.Filled.Person)


    )
    var option by rememberSaveable { mutableStateOf("Buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(MenuOptions){ item ->

                NavigationDrawerItem(
                    icon = { Icon(item.icon, contentDescription = "") },
                    label = { Text(item.title) },
                    selected = false,
                    onClick = {
                        option = item.option
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                    }
                }


            }
        }
    ) {
        Column {
            when (option) {
                "Buttons" -> {
                    buttons()
                }

                "Floating Buttons" -> {
                    FloatingButtons()
                }

                "Progress" -> {
                    Progress()
                }

                "Chips" -> {
                    chips()
                }

                "Sliders" -> {
                    Sliders()
                }

                "Switch" -> {
                    Switches()
                }

                "Badges" -> {
                    Badges()
                }

                "SnackeBars" -> {
                    SnackeBars()
                }

                "AlertDialog" -> {
                    AlertDialogs()
                }

                "Bars" -> {
                    Bars()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun buttons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }
        ElevatedButton(onClick = {}) {
            Text("Tonal")
        }
        TextButton(onClick = {}) {
            Text("Tonal")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add Button")
        }
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add Button")
            Text("Button")
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun chips() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = {
                Text("Filter Chip")
            },
            leadingIcon = if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }

        )
        InputChipExample("Dismiss", {})
    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
) {
    var enable by remember { mutableStateOf(true) }
    if (!enable) return

    InputChip(
        label = { Text(text) },
        selected = enable,
        onClick = {
            onDismiss()
            enable = !enable
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = { SliderPosition = it },
            steps = 10,
            valueRange = 0f..100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked2 = it },
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch check",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = { checked3 = it }
        )
    }
}

@Preview
@Composable
fun Badges() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = androidx.compose.ui.graphics.Color.Red,
                        contentColor = androidx.compose.ui.graphics.Color.White
                    ) {
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart icon"
            )
        }
        Button(
            onClick = { itemCount++ }
        ) {
            Text("Add item")
        }
    }
}

@Preview
@Composable
fun SnackeBars() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar() {
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }
        Button(::launchSnackBar) {
            Text("Send message")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var showalertDialog by remember { mutableStateOf(false) }
        var selectOption by remember { mutableStateOf("") }

        if (showalertDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "Warning Icon") },
                title = { Text("Confirm Deletion") },
                text = { Text("Are you sure you want to delete the file?") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectOption = "Confirmed"
                            showalertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectOption = "Canceled"
                            showalertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = { showalertDialog = true }) {
            Text("Delete file")
        }
        Text(selectOption)

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = androidx.compose.ui.graphics.Color.Black,
                titleContentColor = androidx.compose.ui.graphics.Color.White
            ),
            title = {Text("Screen Title")},
            actions = {
                IconButton(onClick = {}) {
                   Icon(Icons.Filled.Search, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, contentDescription = "")
                }
            }
        )
        val arraydefault = arrayOf(
            PostCardModel(1,"","", R.drawable.autos),
            PostCardModel(2,"","", R.drawable.jordan),
            PostCardModel(3,"","", R.drawable.kobe)
        )
        LazyColumn (
            modifier = Modifier.fillMaxSize()
                .weight(1f)
        ){
            items(arraydefault){
                item -> PostCardComponent(item.id,item.title,item.text,item.image)
            }
        }
            BottomAppBar (
                containerColor = androidx.compose.ui.graphics.Color.Cyan,
                contentColor = androidx.compose.ui.graphics.Color.Black
            ){
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {},

                ) {
                    Icon( Icons.Filled.Star, contentDescription ="")
                }
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {},

                    ) {
                    Icon( Icons.Filled.ShoppingCart, contentDescription ="")
                }
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {},

                    ) {
                    Icon(Icons.Filled.Refresh, contentDescription ="")
                }
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {},

                    ) {
                    Icon(Icons.Filled.Notifications, contentDescription ="")
                }
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {},

                    ) {
                    Icon( Icons.Filled.Build, contentDescription ="")
                }
            }
        }


    }








