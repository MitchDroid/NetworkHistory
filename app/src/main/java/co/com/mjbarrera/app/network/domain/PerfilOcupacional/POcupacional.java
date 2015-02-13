package co.com.mjbarrera.app.network.domain.PerfilOcupacional;

import java.util.List;

/**
 * Created by Personal on 25/10/2014.
 */
public class POcupacional {
    private String title;
    private String content;
    private List<POcupacionalPerfil> listPerfil;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<POcupacionalPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<POcupacionalPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }


}
