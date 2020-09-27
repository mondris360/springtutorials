package util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    boolean successful;
    int statusCode;
    String message;
    Object data;

    // overloaded constructor

    public Response(boolean successful, int statusCode, String message) {
        this.successful = successful;
        this.statusCode = statusCode;
        this.message = message;
    }
}
