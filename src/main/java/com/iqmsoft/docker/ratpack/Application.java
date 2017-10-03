package com.iqmsoft.docker.ratpack;

import java.time.LocalDateTime;
import java.util.Optional;

import ratpack.handling.Context;
import ratpack.server.RatpackServer;

public class Application {

    public static void main(String[] args) throws Exception {
        Application instance = new Application();
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get("hello", ctx -> ctx.render("Hello, world!\n"))
                        .get("time", ctx -> ctx.render(LocalDateTime.now().toString() + "\n"))
                        .get("greet/:name", instance::greet)
                        .get("env/:name", instance::printEnvironmentVariable)));
    }

    private void greet(Context ctx) {
        ctx.render("Hello, " + ctx.getPathTokens().get("name") + "!\n");
    }

    private void printEnvironmentVariable(Context ctx) {
        String variable = ctx.getPathTokens().get("name");
        String value = Optional.ofNullable(System.getenv(variable)).orElse("???");
        ctx.render(variable + " = " + value + "\n");
    }
}
