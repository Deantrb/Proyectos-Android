package Interface;

import java.util.List;

import Model.KBD;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("consultar.php")
    Call<List<KBD>> getKBD();
}
