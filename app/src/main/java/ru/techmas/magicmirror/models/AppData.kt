package ru.techmas.magicmirror.models

import ru.techmas.magicmirror.api.models.PhotoDTO
import ru.techmas.magicmirror.api.models.UserDTO

data class AppData(
        var user: UserDTO = UserDTO(),
        var photo: PhotoDTO = PhotoDTO()
)