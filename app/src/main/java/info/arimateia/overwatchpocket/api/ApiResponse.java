package info.arimateia.overwatchpocket.api;

import java.util.List;

/**
 * Created by felipets on 7/18/17.
 */

public class ApiResponse<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
