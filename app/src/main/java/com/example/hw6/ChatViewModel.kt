package com.example.hw6

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ChatViewModel : ViewModel() {

    private val msgFromReceiver = arrayOf(
        "Кек",
        "Лол",
        "Бидон",
        "Лупа",
        "Пупа",
        "Привет",
        "Пока",
        "Я твой собеседник и у меня облачко сообщения немного другое!",
        "Ладно",
        "Смотри прикол покажу",
        "Хачите прикол??",
        "Кто прочитал, тот здохнет"
    )

    var data: MutableLiveData<MutableList<ItemChat>> = MutableLiveData()

    fun updateMessageList(message: String) {
        val handler = Handler(Looper.getMainLooper())
        val list = data.value ?: mutableListOf()
        list.add(ItemChat(message, true))
        data.value = list
        handler.postDelayed({
            list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
            data.value = list
            handler.postDelayed({
                list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
                data.value = list
            }, 500)
        }, 500)

    }
}