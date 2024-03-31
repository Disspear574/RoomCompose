package ru.disspear574.roomcompose

import android.app.Application
import ru.disspear574.roomcompose.data.MainBD

class App: Application() {
    val database by lazy { MainBD.createBD(this) }
}