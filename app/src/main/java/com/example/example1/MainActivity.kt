package com.example.example1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.example1.ui.theme.Example1Theme
import com.rick.workclass.ejemplo.com.example.example1.data.ViewModel.AccountViewModel
import com.rick.workclass.ejemplo.com.example.example1.ui.App.StockApp
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.AccountsScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.AppScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.BottomStreets
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.DatePickers
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.FavoriteAccountsScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.HomeScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.LoginScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.MainMenuScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.ManageAccountScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.NotificationScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.NotificationScreenPreview
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.PullAndRefresh
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.ScreenCamara
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.SegmentedButtons
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.TestScreen
import com.rick.workclass.ejemplo.com.example.example1.ui.Screens.componentsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Example1Theme {

                ComposableMultiScreenApp()


            }


            }
        }
    }
@Composable
fun ComposableMultiScreenApp(){
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}
@Composable
fun SetupNavGraph(navController : NavHostController){
NavHost(navController = navController, startDestination = "Main_menu"){
    composable("Main_menu"){ MainMenuScreen(navController)}
    composable("Home_Screen"){ HomeScreen(navController) }
    composable("test_screen"){ TestScreen(navController) }
    composable("StockApp") { StockApp(navController) }
    composable("components_screen") { componentsScreen(navController) }
    composable("LoginScreen"){ LoginScreen(navController)}
    composable("AccountsScreen"){ AccountsScreen(navController)}
    composable("ManageAccountsScreen"){ ManageAccountScreen(navController) }
    composable("ScreenCamara"){ ScreenCamara(navController) }
    composable("Calendar"){ AppScreen(navController) }
    composable("NotificationesPush"){ NotificationScreenPreview(navController) }
    composable(
        route = "manageAcScreen/{id}",
        arguments = listOf(navArgument("id") { defaultValue = -1 })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
        ManageAccountScreen(
            navController = navController,
            accountId = id // <-- aquí es importante nombrarlo
        )
    }
    composable("FavoriteAccountsScreen"){ FavoriteAccountsScreen(navController) }
}
}







