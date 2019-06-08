package com.packtpub.hands.on.reactive.kotlin.chapter12.webfluxexample

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class CustomerRouter(val customerHandler: CustomerHandler) {
  @Bean
  fun customerRoutes() = router {
    "/functional".nest {
      "/customer".nest {
        GET("/{id}")(customerHandler::get)
        POST("/")(customerHandler::post)
      }
      "/customers".nest {
        GET("/")(customerHandler::search)
      }
    }
  }
}
