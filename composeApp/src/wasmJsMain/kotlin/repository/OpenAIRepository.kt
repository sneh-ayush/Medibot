package repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.Message
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import org.example.project.HfRequest
import org.example.project.HfResponse
import io.ktor.client.plugins.HttpRequestTimeoutException

class OpenAIRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 60000 // 60 seconds
        }
        install(HttpRequestRetry) {
            retryOnExceptionOrServerErrors(maxRetries = 5)
            exponentialDelay(maxDelayMs = 60000) // Increase maxDelayMs
            retryIf { _, response ->
                response.status == HttpStatusCode.TooManyRequests
            }
        }
        install(HttpSend) {

        }
    }

    // Hugging Face API details
    private val hfApiKey = "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" // Get the API key from environment variables
    private  val hfApiUrl = "https://api-inference.huggingface.co/models/google/gemma-1.1-2b-it"

    suspend fun sendMessage(messages: List<Message>): String? {

        val userInput = messages.joinToString("\n") { "${it.role}: ${it.content}" }

        val parameters = buildJsonObject {
            put("max_length", 100)
            put("temperature", 0.5)
        }
        val request = HfRequest(
            inputs = userInput,
            parameters = parameters,
        )
        return try {
            val response = client.post(hfApiUrl) {
                contentType(ContentType.Application.Json)
                header("Authorization", "Bearer $hfApiKey")
                setBody(request)
            }
            val responseBody = response.body<List<HfResponse>>()
            val responseText = responseBody.firstOrNull()?.generated_text

            responseText

        } catch (e: ResponseException) {
            println("Http Error: ${e.message}")
            e.printStackTrace()
            "Http Error"
        } catch (e: HttpRequestTimeoutException) {
            println("Request timeout: ${e.message}")
            e.printStackTrace()
            "Request timed out"
        } catch (e: Exception) {
            println("Error: ${e.message}")
            e.printStackTrace()
            "An unexpected error occurred"
        }
    }
}