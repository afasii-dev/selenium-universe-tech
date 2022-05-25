package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int status;
    private String error;
}
