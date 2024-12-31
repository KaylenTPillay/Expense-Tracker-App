package com.kaylen.pillay.expensetracker.ui.view.dashboard.state

import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.bottomappbar.state.BottomAppBarSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.fullscreendialog.state.FullScreenDialogSharedStateModel
import com.kaylen.pillay.expensetracker.ui.view.sharedcomponent.topappbar.state.TopAppBarSharedStateModel
import kotlinx.collections.immutable.ImmutableList

/*
 * Designed and developed by Kaylen Travis Pillay.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

data class DashboardStateModel(
    val topAppBar: TopAppBarSharedStateModel,
    val bottomAppBar: BottomAppBarSharedStateModel,
    val summaryItems: ImmutableList<DashboardSummaryItemStateModel>,
    val fullScreenDialog: FullScreenDialogSharedStateModel? = null
)
