package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.rick.workclass.ejemplo.com.example.example1.data.ViewModel.AccountViewModel
import com.rick.workclass.ejemplo.com.example.example1.data.model.AccountModel
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.TopBarComponent

@Composable
fun ManageAccountScreen (
    navController: NavController,
    accountId: Int? = null,
    viewModel: AccountViewModel= viewModel()
){
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    LaunchedEffect(accountId) {
        accountId?.let {
            viewModel.getAccount(it) { response ->
                if (response.isSuccessful) {
                    account.value = response.body() ?: AccountModel()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ){
        TopBarComponent("Add/Update Account", navController, "ManageAccountScreen")

        // Campos
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.name,
            onValueChange = { account.value = account.value.copy(name = it) },
            label = { Text("Account Name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.secondary,  // Color del texto cuando está enfocado
                unfocusedTextColor = Color.Gray)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.username,
            onValueChange = { account.value = account.value.copy(username = it) },
            label = { Text("Account Username") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.secondary,  // Color del texto cuando está enfocado
                unfocusedTextColor = Color.Gray)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.password,
            onValueChange = { account.value = account.value.copy(password = it) },
            label = { Text("Account Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.secondary,  // Color del texto cuando está enfocado
                unfocusedTextColor = Color.Gray)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.description,
            onValueChange = { account.value = account.value.copy(description = it) },
            label = { Text("Account Description") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.secondary,  // Color del texto cuando está enfocado
                unfocusedTextColor = Color.Gray)
        )

        FilledTonalButton(
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            onClick = {
                TryCreateAccount(account, context, viewModel, accountId)
            }
        ){
            Text("Save/Update Account")
        }
        if(accountId != null){
            FilledTonalButton(
                modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .fillMaxWidth(),
                onClick = {TryDeleteAccount(context, viewModel, accountId)}
            ){
                Text("Delete Account")
            }
        }
    }
}

fun TryCreateAccount(
    accountState: MutableState<AccountModel>,
    context: Context,
    viewModel: AccountViewModel,
    accountId: Int?
){
    val acc = accountState.value

    if (
        acc.name.isEmpty() ||
        acc.username.isEmpty() ||
        acc.password.isEmpty() ||
        acc.description.isEmpty()
    ) {
        Toast.makeText(context, "None of the fields can be empty", Toast.LENGTH_SHORT).show()
        return
    }

    if (accountId == null) {
        viewModel.createAccount(acc) { jsonResponse ->
            val createAcStatus = jsonResponse?.get("store")?.toString()?.replace("\"", "")

            if (createAcStatus == "success") {
                Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error creating account", Toast.LENGTH_SHORT).show()
            }
        }
    } else {
        viewModel.updateAccount(accountId, acc) { jsonResponse ->
            val updateAcStatus = jsonResponse?.get("update")?.asString
            if (updateAcStatus == "success") {
                Toast.makeText(context, "Account updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error updating account", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

fun TryDeleteAccount(
    context: Context,
    viewModel: AccountViewModel,
    accountId: Int
){
    viewModel.deleteAccount(accountId) { jsonResponse ->
        val deleteAcStatus = jsonResponse?.get("delete")?.asString
        if (deleteAcStatus == "success") {
            Toast.makeText(context, "Account deleted successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Error deleting account", Toast.LENGTH_SHORT).show()
        }
    }
}
