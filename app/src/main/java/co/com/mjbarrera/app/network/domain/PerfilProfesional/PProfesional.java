package co.com.mjbarrera.app.network.domain.PerfilProfesional;

import java.util.List;

/**
 * Created by Personal on 25/10/2014.
 */
public class PProfesional {

    private String title;
    private String content;
    private List<PProfesionalPerfil> listPerfil;

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

    public List<PProfesionalPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<PProfesionalPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
}
