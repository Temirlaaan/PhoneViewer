package com.example.phoneviewer.network


data class MainDTO(
    val result: Boolean,
    val data: Data,
    val errors: List<Any?>
)

data class Data(
    val section_list: List<SectionList>,
    val all_items_count: Long,
    val page_items_count: Long,
    val page_number: Long,
    val items: List<Item>,
    val breadcrumbs: List<Breadcrumb>
)

data class Breadcrumb(
    val name: String,
    val code: String,
    val nameRu: String? = null,
    val id: Long? = null
)

data class Item(
    val id: Long,
    val xml_id: String,
    val name: String,
    val title: String,
    val code: String,
    val type: Long,
    val price: Long,
    val photos: List<String>,
    val city_exist: Boolean,
    val video_link: List<String>? = null,
    val code_1c: String,
    val express: Boolean,
    val express_delivery: Boolean,
    val is_intercity: Boolean,
    val rating: Long,
    val reviews_count: Long,
    val pod_order_item: Boolean,
    val pod_order_time: Any? = null,
    val preorder: Boolean,
    val preorder_start: Any? = null,
    val preorder_sum: Any? = null,
    val preorder_link: Any? = null,
    val service: Boolean,
    val digital: Boolean,
    val in_compare: Boolean,
    val in_favorites: Boolean,
    val stickers: StickersUnion,
    val new_item: Boolean,
    val same_product_properties: List<String>,
    val metrics: Metrics,
    val availability: String,
    val prices: Prices,
    val bonus: Long,
    val has_gift: Boolean,
    val gifts: List<Any?>,
    val city_code_for_kaspi: String
)

enum class Availability {
    CityExist
}

data class Metrics(
    val name: String,
    val brand: String,
    val category: String
)

data class Prices(
    val discounted_price: Long,
    val base_price: Long,
    val has_discount: Boolean
)

sealed class StickersUnion {
    class AnythingArrayValue(val value: List<Any?>) : StickersUnion()
    class StickersClassValue(val value: StickersClass) : StickersUnion()
}

data class StickersClass(
    val trade_in_aktsiya: New? = null,
    val delivery_express: DeliveryExpress? = null,
    val new: New? = null
)

data class DeliveryExpress(
    val color: String,
    val name: String,
    val link: Any? = null
)

data class New(
    val code: Code,
    val color: Color,
    val name: Name,
    val link: String? = null
)

enum class Code {
    New,
    TradeInAktsiya
}

enum class Color {
    E61771
}

enum class Name {
    TradeIn,
    Новинка
}

data class SectionList(
    val name: String,
    val code: String
)

data class MetaTags(
    val title: String,
    val description: String,
    val keywords: String,
    val og_title: String,
    val og_type: String,
    val og_image: String,
    val og_image_width: String,
    val og_image_height: String,
    val canonical: Any? = null,
    val noindex: Any? = null
)