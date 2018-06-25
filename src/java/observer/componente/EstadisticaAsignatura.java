/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.componente;

import Adapter.DAOAdapter;
import Adapter.DBAction;
import dao.DAOFactory;
import observer.design.ObservadorEstadistica;
import to.AsignaturaTO;
import to.UsuarioAsignaturaTO;


import to.UsuarioTemaTO;


/**
 *
 * @author kevinMC
 */
public class EstadisticaAsignatura implements ObservadorEstadistica{

    @Override
    public void update(UsuarioTemaTO subtema) {
        DBAction adapter = new DAOAdapter();
        
        AsignaturaTO id_asignatura = adapter.obtenerAsignaturaporTema(subtema.getIdTema().getIdTema());
        
        int temasT = adapter.obtenerTemasporAsignatura(id_asignatura.getIdAsignatura());
        
        UsuarioAsignaturaTO usuarioA = new UsuarioAsignaturaTO();
        usuarioA.setIdAsignatura(id_asignatura);
        usuarioA.setIdUsuario(subtema.getIdUsuario());
        
        int temasCompletos = DAOFactory.getInstance().getTemaDAO().getTemasCompletados(usuarioA);
        double porcentaje = temasT*100/temasCompletos;
        usuarioA.setPorcentaje(porcentaje);
        adapter.actualizarUsuarioAsignatura(usuarioA);
        
    }
    
}
