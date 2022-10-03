package aaa.bivizul.a34project.data.network

import aaa.bivizul.a34project.domain.model.Stoplos
import aaa.bivizul.a34project.domain.model.Stoplosg
import aaa.bivizul.a34project.domain.model.Stoploss
import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSBASEURL
import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSGURL
import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class StoplosApi {

    val spotloshc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    private fun HttpRequestBuilder.spotlosbase(path: String) {
        url {
            takeFrom(STOPLOSBASEURL)
            encodedPath = path
        }
    }

    suspend fun getStoplosItem(): List<Stoploss> {
        val getspotlositemurl = STOPLOSITEMURL
        val spotloshr = spotloshc.get { spotlosbase(getspotlositemurl) }
        val getspotlositembody = spotloshr.body<List<Stoploss>>()
        return getspotlositembody
    }

    suspend fun getStoplosg(spotlos: Stoplos): Stoplosg {
        val getspotlosurl = STOPLOSGURL
        val spotloshr = spotloshc.post {
            spotlosbase(getspotlosurl)
            contentType(Json)
            setBody(spotlos)
        }
        val getspotlosbody = spotloshr.body<Stoplosg>()
        return getspotlosbody
    }

}