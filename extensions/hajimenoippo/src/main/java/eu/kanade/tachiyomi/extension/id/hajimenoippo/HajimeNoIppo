package eu.kanade.tachiyomi.extension.id.hajimenoippo

import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.Page
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.source.online.ParsedHttpSource
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class HajimeNoIppo : ParsedHttpSource() {

    override val name = "Hajime no Ippo (Mandiri)"
    override val baseUrl = "https://w31.hajime-noippo.com"
    override val lang = "id"
    override val supportsLatest = false

    override fun popularMangaRequest(page: Int) = GET(baseUrl, headers)

    override fun popularMangaSelector() = "body"

    override fun popularMangaFromElement(element: Element) = SManga.create().apply {
        title = "Hajime no Ippo"
        url = "/"
        description = "Baca komik Hajime no Ippo."
        thumbnail_url = "https://w31.hajime-noippo.com/wp-content/uploads/2024/04/images-32.jpeg"
        status = SManga.ONGOING
    }

    override fun popularMangaNextPageSelector(): String? = null

    override fun chapterListSelector() = "ul li a"

    override fun chapterFromElement(element: Element) = SChapter.create().apply {
        name = element.text()
        url = element.attr("href").substringAfter(baseUrl)
    }

    override fun pageListParse(document: Document): List<Page> {
        return document.select(".entry-content img").mapIndexedNotNull { i, element ->
            val imageUrl = element.attr("data-src").ifEmpty {
                element.attr("src")
            }
            
            if (imageUrl.endsWith("lazy_placeholder.gif") || imageUrl.isEmpty()) {
                null
            } else {
                Page(i, "", imageUrl)
            }
        }
    }

    override fun imageUrlParse(document: Document) =
        throw UnsupportedOperationException("Not used")

    override fun latestUpdatesRequest(page: Int) =
        throw UnsupportedOperationException("Not used")

    override fun latestUpdatesSelector() =
        throw UnsupportedOperationException("Not used")

    override fun latestUpdatesFromElement(element: Element) =
        throw UnsupportedOperationException("Not used")

    override fun latestUpdatesNextPageSelector() =
        throw UnsupportedOperationException("Not used")

    override fun mangaDetailsParse(document: Document) = SManga.create()

    override fun searchMangaRequest(page: Int, query: String, filters: FilterList) =
        throw UnsupportedOperationException("Not used")

    override fun searchMangaSelector() =
        throw UnsupportedOperationException("Not used")

    override fun searchMangaFromElement(element: Element) =
        throw UnsupportedOperationException("Not used")

    override fun searchMangaNextPageSelector() =
        throw UnsupportedOperationException("Not used")
}
