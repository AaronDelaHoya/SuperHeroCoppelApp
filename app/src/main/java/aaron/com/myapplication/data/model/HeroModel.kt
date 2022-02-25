package aaron.com.myapplication.data.model

data class Result(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data : Data
)

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<HeroModel>
)

data class HeroModel(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Series,
    val stories: Stories,
    val events: Events,
    val urls: List<Url>
)

data class Thumbnail(
    val path: String,
    val extension: String
)

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)

data class Url(
    val type: String,
    val url: String
)

data class Item(
    val resourceURI: String,
    val name: String
)

data class ItemX(
    val resourceURI: String,
    val name: String
)

data class ItemXX(
    val resourceURI: String,
    val name: String,
    val type: String
)

data class ItemXXX(
    val resourceURI: String,
    val name: String
)