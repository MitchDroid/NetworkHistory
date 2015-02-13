package co.com.mjbarrera.app.network.domain.PerfilEgreso;

import java.util.List;


/**
 * Created by Personal on 25/10/2014.
 */
public class PEgreso {

    private String title;
    private String content_uno;
    private String content_dos;
    private List<PEgresoFunciones> listFunciones;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_uno() {
        return content_uno;
    }

    public void setContent_uno(String content_uno) {
        this.content_uno = content_uno;
    }

    public String getContent_dos() {
        return content_dos;
    }

    public void setContent_dos(String content_dos) {
        this.content_dos = content_dos;
    }

    public void setListFunciones(List<PEgresoFunciones> listFunciones) {
        this.listFunciones = listFunciones;
    }

    public List<PEgresoFunciones> getListFunciones() {
        return listFunciones;
    }
}
