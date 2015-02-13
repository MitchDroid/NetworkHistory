package co.com.mjbarrera.app.network.domain.PerfilPrograma;

import java.util.List;

/**
 * Created by Personal on 25/10/2014.
 */
public class PPrograma {

    private String title;
    private String content;
    private List<PProgramaPerfil> listPefil;
    private List<PProgramaConocimientos> listConocimientos;
    private List<PProgramaHabilidades> listHabilidades;


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

    public List<PProgramaPerfil> getListPefil() {
        return listPefil;
    }

    public void setListPefil(List<PProgramaPerfil> listPefil) {
        this.listPefil = listPefil;
    }

    public List<PProgramaConocimientos> getListConocimientos() {
        return listConocimientos;
    }

    public void setListConocimientos(List<PProgramaConocimientos> listConocimientos) {
        this.listConocimientos = listConocimientos;
    }

    public List<PProgramaHabilidades> getListHabilidades() {
        return listHabilidades;
    }

    public void setListHabilidades(List<PProgramaHabilidades> listHabilidades) {
        this.listHabilidades = listHabilidades;
    }
}
