package com.example.newsapp.models

data class NewsItem(
    val title: String,
    val imageUrl: String,
)

val news = listOf(
    NewsItem("El presidente de EE.UU. no muestra signos de arrepentimiento...", "https://tse1.explicit.bing.net/th/id/OIP.zAibgViO82lC2GvdEFnX3QHaHa?rs=1&pid=ImgDetMain&o=7&rm=3"),
    NewsItem("La economía global enfrenta desafíos sin precedentes...", "https://oem.com.mx/diariodequeretaro/img/18751754/1664355593/BASE_LANDSCAPE/1200/Cleopatra.jpg"),
    NewsItem("La tecnología 5G revoluciona las comunicaciones móviles...", "https://www.tarlogic.com/wp-content/uploads/2023/09/riesgos-seguridad-IA-3.jpg"),
    NewsItem("El cambio climático amenaza la biodiversidad mundial...", "https://www.latercera.com/resizer/v2/RO76QH6WSBGDVFFFDRBML6WNBI.jpg?quality=80&smart=true&auth=af0b60c72624f0449cef3e81bf71374fb3b872d76ff9a0597ac669006190de63&width=1200&height=750")
)