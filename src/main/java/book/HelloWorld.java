package book;

import book.model.BookRequest;
import book.model.BookResponse;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    public void jsonInputHandler(Map<String, String> input) {
        String s = input.get("s");
        System.out.println("Hello, " + s);
    }

    public BookResponse pojoInputHandler(BookRequest request) {
        String title = request.getTitle();
        BookResponse response = new BookResponse();
        response.setTitle("Book title from request -->".concat(title));
        return response;
    }

    public Map<String, Object> contextInputHandler(Context context) {
        String invokedFunction = context.getFunctionName();
        Integer timeRemaining = context.getRemainingTimeInMillis();
        Integer memoryLimit = context.getMemoryLimitInMB();
        Map<String, Object> response = new HashMap<>();
        response.put("InvokedFunction", invokedFunction);
        response.put("TimeRemaining", timeRemaining);
        response.put("MemoryLimit", memoryLimit);
        return response;
    }

    public String handleEnvironmentVariable(Object event) {
        String databaseUrl = System.getenv("DATABASE_URL");
        return " The Database Url is -->".concat(databaseUrl);
    }
}