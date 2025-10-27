package com.apolodevsystem.todoperformance.di

import com.apolodevsystem.todoperformance.TaskViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModules = listOf(
    module {
        viewModel {
            TaskViewModel()
        }
    }
)