package ru.techmas.magicmirror.interfaces.views


import ru.techmas.magicmirror.api.models.PhotoDTO

interface PersonView : BaseView {

    fun showPhoto(photo: PhotoDTO)
}
