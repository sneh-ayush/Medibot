package org.example.project

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Message(val role: String, val content: String)
@Serializable
data class HfRequest(val inputs: String, val parameters: JsonElement)

@Serializable
data class HfResponse(val generated_text: String)
