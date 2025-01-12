# Expense-Tracker-App

## 🛠 Features
- **Coming Soon**

## ⚙️ Tech Stack
- ![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=flat&logo=android-studio&logoColor=white)
- ![Android SDK](https://img.shields.io/badge/Android%20SDK-808080?style=flat&logo=android&logoColor=white)
- ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
- ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat&logo=jetpack-compose&logoColor=white)

## 🚀 Getting Started
- **Coming Soon**

## 🧩 Architecture
The app will use the **MVVM** architecture. This is a well known architecture for
Android applications. I'll use the **Expense Tracker App** to showcase this
architecture in the codebase.

## 📂 Package Structure
> 📘 Notes:
> I'm highlighting the package structure used for the project because I believe this is very
> important in achieving the following goals:
> 1. Scalability
> 2. Maintainability
> 3. Readability
> 4. Easier Collaboration
>
> See the following [article](https://medium.com/@kliment.jonceski/a-guide-to-modern-android-project-package-structures-3a9bb385307d) for more information on the importance of package structure.

Given the nature of the project size and goals, the package structure chosen reflects this.  
The following illustrates the package structure used for the project:

**data**: `The data layer handles all data in the app.`.  
&emsp;-- *model*  
&emsp;-- *repository*  
&emsp;-- *local*  
&emsp;-- *remote*  
**domain**: `The domain Layer is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels.`  
&emsp;-- *model*   
&emsp;-- *usecase*   
**ui**: `The UI Layer is typically the user interface.`  
&emsp;-- *view*   
&emsp;-- *viewmodel*   
**di**: `The di layer contains all dependency injection for the project.`   
**util**: `The util layer contains all utils defined for the project. Across all layers.`


## 🔀 Branching Strategy
- The project uses the [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) branching strategy.
- The `main` branch represents the production environment.
- The `development` branch represents the development environment.
- The `feature-xxx` branch represents feature work.

## 🗂️ Project Management
- Follow the project progress over on the [board](https://github.com/users/KaylenTPillay/projects/1)

## 👀 Demo
- **Coming Soon**

## Attribution
### Icon Attribution
- [Wallet SVG - Marta Konyk](https://www.svgrepo.com/svg/415743/banking-cash-money)
