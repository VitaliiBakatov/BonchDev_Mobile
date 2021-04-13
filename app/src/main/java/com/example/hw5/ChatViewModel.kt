package com.example.hw5

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
        val list = data.value  ?: mutableListOf()
        list.add(ItemChat(message, true))
        list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
        list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
        data.value = list
    }
}