package com.packtpub.hands.on.reactive.kotlin.chapter11

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import io.ktor.locations.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
  install(ContentNegotiation) {
    jackson {
      enable(SerializationFeature.INDENT_OUTPUT)
    }
  }

  val customerService = CustomerService()

  routing {
    get("/customer/{id}") {
      val id: Int = call.parameters["id"]?.toInt() ?: 1
      call.respond(customerService.getCustomer(id))
    }

    get("/customers") {
      call.respond(customerService.getCustomers())
    }

    post("/customer/{id}") {
      val id: Int = call.parameters["id"]?.toInt() ?: 1
      val customer = call.receive<Customer>()
      customerService.saveCustomer(id, customer)
      call.response.header(HttpHeaders.Location, "http://locahost:8080/customer/$id")
      call.respond(HttpStatusCode.Created)
    }
  }
}
