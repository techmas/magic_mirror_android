package ru.techmas.magicmirror.api.models

import com.google.gson.annotations.SerializedName

class HashResponse<T>(): HashMap<String, ArrayList<T>>()